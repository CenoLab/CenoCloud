package com.iot.nero.facade_data.dao;

import com.iot.nero.parent_data.entity.MQMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   下午1:23
 */
public interface DataDao {


    /**
     * 创建数据表
     * @param tableName
     * @return
     */
    Integer createTable(@Param("name") String tableName);

    /**
     * 储存消息值数据库
     * @param table
     * @param aid
     * @param from
     * @param to
     * @param qos
     * @param message
     * @return
     */
    Integer saveMessage(@Param("table") String table,
                        @Param("aid") Integer aid,
                        @Param("from") String from,
                        @Param("to") String to,
                        @Param("qos") String qos,
                        @Param("message") String message);

    /**
     * 查询消息记录
     * @param table
     * @param aid
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getMessageByPage(@Param("table") String table,
                                     @Param("aid") Integer aid,
                                     @Param("page") Integer page,
                                     @Param("num") Integer num);

    /**
     * 分页查询客户端发送消息
     * @param table
     * @param aid
     * @param clientId
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getSendMessageByPage(
            @Param("table") String table,
            @Param("aid") Integer aid,
            @Param("clientId") String clientId,
            @Param("page") Integer page,
            @Param("num") Integer num);

    /**
     * 分页查询客户端接收消息
     * @param table
     * @param aid
     * @param clientId
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getReceivedMessageByPage(@Param("table") String table,
                                             @Param("aid") Integer aid,
                                             @Param("clientId") String clientId,
                                             @Param("page") Integer page,
                                             @Param("num") Integer num);

    /**
     * 查询设备发送数
     * @param table
     * @param aid
     * @param clientId
     * @return
     */
    Integer getSendMessageCount(@Param("table") String table,
                                    @Param("aid") Integer aid,
                                    @Param("clientId") String clientId);

    /**
     * 查询应用发送消息数
     * @param clientPoolTableName
     * @param id
     * @return
     */
    Integer getAppSendMessageCount(@Param("table") String clientPoolTableName, @Param("aid") Integer id);

    /**
     * 获取时序数据
     * @param table
     * @param fromTime
     * @param toTime
     * @return
     */
    List<MQMessage> getAppSendMessageByTime(
            @Param("table") String table,
            @Param("from") String fromTime,
            @Param("to") String toTime);

    /**
     * 获取产品设备数据
     * @param table
     * @param clientId
     * @param fromTime
     * @param toTime
     * @return
     */
    List<MQMessage> getAppClientSendMessageByTime(
            @Param("table") String table,
            @Param("clientId") String clientId,
            @Param("from") String fromTime,
            @Param("to") String toTime);

    /**
     * 获取当前值
     * @param table
     * @param clientId
     * @return
     */
    MQMessage getAppClientSendMessageCurrent(@Param("table") String table,
                                             @Param("clientId") String clientId);

    /**
     * 获取历史
     * @param table
     * @param clientId
     * @param from
     * @param to
     * @param page
     * @param num
     * @return
     */
    List<MQMessage> getAppClientSendMessageByTimePage(@Param("table") String table,
                                                      @Param("clientId") String clientId,
                                                      @Param("from") String from,
                                                      @Param("to") String to,
                                                      @Param("page") Integer page,
                                                      @Param("num") Integer num);
}
