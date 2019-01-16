package com.iot.nero.facade;

import com.iot.nero.parent_app.entity.ClientConn;
import com.iot.nero.parent_app.entity.ClientConnResult;
import com.iot.nero.parent_app.exception.ClientConnNotExistsException;
import com.iot.nero.parent_app.exception.MessageSaveException;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   上午10:48
 */
public interface IClientFacade {

    /**
     * 根据设备id查找连接
     * @param clientPoolTableName
     * @param clientID
     * @return
     */
    ClientConn findClientByClientID(String clientPoolTableName, String clientID);

    /**
     * 设备上限状态修改
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    Integer onLine(String clientPoolTableName, String clientId);

    /**
     * 设备第一次连接，登记
     * @param dId
     * @param id
     * @param clientId
     * @return
     */
    Integer checkIn(Integer dId, Integer id, String clientId);

    /**
     * 获取应用当前连接数
     * @param id
     * @return
     */
    Integer getCurrentConnCount(String clientPoolTableName,Integer id);

    /**
     * 修改在线状态为下线
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    Integer offLine(String clientPoolTableName, String clientId);

    /**
     * 获取应用当前连接信息
     * @param did
     * @param aid
     * @param page
     * @param num
     * @return
     */
    List<ClientConn> getAppConn(Integer did, Integer aid, Integer page, Integer num) throws ClientConnNotExistsException;

    /**
     * 获取当前应用在线连接数
     * @param clientPoolTableName
     * @param id
     * @return
     */
    Integer getCurrentOnlineCount(String clientPoolTableName, Integer id);
}
