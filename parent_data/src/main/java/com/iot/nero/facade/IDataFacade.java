package com.iot.nero.facade;


import com.iot.nero.parent_data.entity.MQMessage;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   下午1:19
 */
public interface IDataFacade {
    /**
     * 储存消息
     * @param id
     * @param from
     * @param to
     * @param qos
     * @param message
     * @return
     */
    Integer saveMessage(Integer id, String from, String to, String qos, String message);

    /**
     * 获取信息列表
     * @param aid
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getMessageByPage(Integer aid, Integer page, Integer num);

    /**
     * 获取客户端发送消息
     * @param aid
     * @param clientId
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getClientSendMessageByPage(Integer aid, String clientId, Integer page, Integer num);

    /**
     * 获取客户端接收消息
     * @param aid
     * @param clientId
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getClientReceivedMessageByPage(Integer aid, String clientId, Integer page, Integer num);

    /**
     * 获取设备发送数据条数
     * @param aid
     * @param clientId
     * @return
     */
    Integer getClientSendMessageCount(Integer aid, String clientId);

    /**
     * 获取当前应用总发送消息数
     * @param uid
     * @param id
     * @return
     */
    Integer getSendMessageCount(Integer uid, Integer id);

    /**
     * 时间获取历史数据
     * @param appId
     * @param fromTime
     * @param toTime
     * @return
     */
    List<MQMessage> getDataByTime(Integer appId, String fromTime, String toTime);


    /**
     * 获取产品设备数据
     * @param appId
     * @param clientId
     * @param fromTime
     * @param toTime
     * @return
     */
    List<MQMessage> getClientDataByTime(Integer appId, String clientId, String fromTime, String toTime);

    /**
     * 获取当前值
     * @param appId
     * @param clientId
     * @return
     */
    MQMessage getClientDataByCurrent(Integer appId, String clientId);

    /**
     * 获取历史数据分页
     * @param appId
     * @param clientId
     * @param from
     * @param to
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getClientDataByTimePage(Integer appId, String clientId, String from, String to, Integer page, Integer num);
}
