package com.iot.nero.facade_balance.facade.impl;

import com.iot.nero.facade.IBalanceFacade;
import com.iot.nero.facade_balance.dao.BalanceDao;
import com.iot.nero.parent_balance.constant.CONSTANT;
import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_balance.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 下面的代码很重要，涉及到人民币和连接数的转换
 * 注意事务问题
 *
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:46
 */
@Service
public class BalanceFacade implements IBalanceFacade {


    @Autowired
    private BalanceDao balanceDao;

    /**
     * 获取开发者余额
     * @param Did
     * @return
     */
    public Balance getBalanceByDId(Integer Did) {
        return  balanceDao.findByDid(Did);
    }

    /**
     * 检测余额是否足够 在创建应用的时候检查
     * @param dId
     * @param maxConnect
     * @return
     */
    public Balance checkBalance(Integer dId, Integer maxConnect) throws BalanceNotEnoughException, BalanceNotFoundException {
        Balance balance = balanceDao.findByDid(dId);
        if(balance==null){
            throw new BalanceNotFoundException(CONSTANT.BALANCE_NOT_FOUND);
        }
        if(maxConnect>balanceDao.findByDid(dId).getRestConnCount()) {
            throw new BalanceNotEnoughException(CONSTANT.BALANCE_NOT_ENOUGH);
        }else{
            return balance;
        }
    }

    /**
     * 充值
     * @param uid
     * @param money
     * @return
     */
    public synchronized Balance recharge(Integer uid, Integer money) throws BalanceNotFoundException, RechargeFailedException {
        Balance balance = balanceDao.findByDid(uid);
        if(balance==null){
            throw new BalanceNotFoundException(CONSTANT.BALANCE_NOT_FOUND);
        }
        if(balanceDao.rechargeById(balance.getId(),
                balance.getTotalMoney()+money,
                balance.getRestMoney()+money)<1){
            throw new RechargeFailedException(CONSTANT.RECHARGE_FAILED);
        }
        return balanceDao.findByDid(uid);
    }

    /**
     * 消费 人命币余额变连接数，不可逆
     *
     * 此处很重要
     *
     * @param uid
     * @param connCount
     * @return
     */
    public synchronized Balance consume(Integer uid, Integer connCount) throws BalanceNotFoundException, MoneyNotEnoughException, PriceConfigNotFoundException, ConsumeFailedException {

        Balance balance = balanceDao.findByDid(uid);
        if(balance==null){
            throw new BalanceNotFoundException(CONSTANT.BALANCE_NOT_FOUND);
        }

        //此数应该从配置系统读取
        String price = "5";
        if(price==null || "".equals(price)){
            throw new PriceConfigNotFoundException(CONSTANT.PRICE_CONFIG_NOT_FOUND);
        }
        Integer money = Integer.valueOf(price)*connCount;
        if(money>balance.getRestMoney()){
            throw new MoneyNotEnoughException(CONSTANT.MONEY_NOT_ENOUGH);
        }

        if(balanceDao.consumeById(balance.getId(),
                balance.getRestConnCount()+connCount,
                balance.getRestMoney()-money,
                balance.getTotalConnCount()+connCount)<1){
            throw new ConsumeFailedException(CONSTANT.CONSUME_FAILED);
        }

       return balanceDao.findByDid(uid);
    }

    public Balance consumeConn(Integer dId, Integer maxConnect) throws BalanceNotFoundException, ConnDecreaseFailedException {
        Balance balance = balanceDao.findByDid(dId);
        if(balance==null){
            throw new BalanceNotFoundException(CONSTANT.BALANCE_NOT_FOUND);
        }

        if(balanceDao.updateConn(dId,balance.getRestConnCount()-maxConnect)<1){
            throw new ConnDecreaseFailedException(CONSTANT.CONN_DESCRISE_FAILED);
        }
        balance.setRestConnCount(balance.getRestConnCount()-maxConnect);

        return balance;
    }

    public Balance initDeveloperBanance(Integer did) throws BalanceInitException {
        Balance balance = balanceDao.findByDid(did);
        if(balance==null){
            Integer balanceInit = balanceDao.insertConn(did,20);
            if(balanceInit<1){
                throw new BalanceInitException(CONSTANT.BALANCE_INIT_FAILED);
            }
            return balanceDao.findByDid(did);
        }
        return balance;
    }

}
