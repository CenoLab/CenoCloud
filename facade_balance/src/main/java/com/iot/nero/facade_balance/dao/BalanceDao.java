package com.iot.nero.facade_balance.dao;

import com.iot.nero.parent_balance.entity.Balance;
import org.apache.ibatis.annotations.Param;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   下午12:46
 */
public interface BalanceDao {

    /**
     * 查找
     * @param did
     * @return
     */
    Balance findByDid(
            @Param("did") Integer did);

    /**
     * 人命币转换成 连接数
     * @param id
     * @param restConn
     * @param restMoney
     * @param totalConn
     * @return
     */
    Integer consumeById(
            @Param("id") Integer id,
            @Param("restC") Integer restConn ,
            @Param("restM") Integer restMoney,
            @Param("restT") Integer totalConn);

    /**
     * 人命币充值
     * @param id
     * @param totalMoney
     * @param restMoney
     * @return
     */
    Integer rechargeById(@Param("id") Integer id,
                         @Param("totalM") Integer totalMoney,
                         @Param("restM") Integer restMoney);

    /**
     * 更新连接数
     * @param dId
     * @param connNum
     * @return
     */
    Integer updateConn(@Param("did") Integer dId,
                   @Param("connNum") Integer connNum);

    /**
     * 初始化消费
     * @param did
     * @param i
     * @return
     */
    Integer insertConn(@Param("did") Integer did, @Param("conn") int i);
}
