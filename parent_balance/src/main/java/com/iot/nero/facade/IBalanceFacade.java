package com.iot.nero.facade;

import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_balance.exception.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:40
 */
public interface IBalanceFacade {

    /**
     * 获取开发者消费
     * @param Did
     * @return
     */
    Balance getBalanceByDId(Integer Did);

    /**
     * 检测余额是否足够
     * @param dId
     * @param maxConnect
     * @return
     */
    Balance checkBalance(Integer dId, Integer maxConnect) throws BalanceNotEnoughException, BalanceNotFoundException;

    /**
     * 充值
     * @param uid
     * @param money
     * @return
     */
    Balance recharge(Integer uid,Integer money) throws BalanceNotFoundException, RechargeFailedException;

    /**
     * 消费
     * @param uid
     * @param connCount
     * @return
     */
    Balance consume(Integer uid,Integer connCount) throws BalanceNotFoundException, MoneyNotEnoughException, PriceConfigNotFoundException, ConsumeFailedException;

    /**
     * 连接数 余额减
     * @param dId
     * @param maxConnect
     * @return
     */
    Balance consumeConn(Integer dId, Integer maxConnect) throws BalanceNotFoundException, ConnDecreaseFailedException;

    /**
     * 初始化消费余额
     * @param id
     * @return
     */
    Balance initDeveloperBanance(Integer id) throws BalanceInitException;
}
