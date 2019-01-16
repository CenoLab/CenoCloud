package com.iot.nero.facade_app.facade.impl;

import com.iot.nero.facade.IClientFacade;
import com.iot.nero.facade_app.dao.ClientDao;
import com.iot.nero.parent_app.constant.CONSTANT;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.ClientConn;
import com.iot.nero.parent_app.entity.ClientConnResult;
import com.iot.nero.parent_app.exception.ClientConnNotExistsException;
import com.iot.nero.parent_app.exception.MessageSaveException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/30
 * Time   上午10:53
 */
@Service
public class ClientFacade implements IClientFacade {

    @Autowired
    private ClientDao clientDao;

    /**
     * 查找客户端连接信息
     * @param clientPoolTableName
     * @param clientID
     * @return
     */
    public ClientConn findClientByClientID(String clientPoolTableName, String clientID) {
        try {
            return clientDao.findClientById(clientPoolTableName, clientID);
        }catch (BadSqlGrammarException e){
            clientDao.createTable(clientPoolTableName);
            return clientDao.findClientById(clientPoolTableName, clientID);
        }
    }

    /**
     * 客户端上线
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    public Integer onLine(String clientPoolTableName, String clientId) {
       return clientDao.onLine(clientPoolTableName,clientId);
    }

    /**
     * 客户端初次上线，登记
     * @param dId
     * @param id
     * @param clientId
     * @return
     */
    public Integer checkIn(Integer dId, Integer id, String clientId) {
        return clientDao.checkIn(dId,id,clientId);
    }

    /**
     * 获取应用当前连接数
     * @param id
     * @return
     */
    public Integer getCurrentConnCount(String clientPoolTableName,Integer id) {
        try {
            return clientDao.getCurrentConnCount(clientPoolTableName, id);
        }catch (BadSqlGrammarException e){
            //数据表不存在
            clientDao.createTable(clientPoolTableName);
            return clientDao.getCurrentConnCount(clientPoolTableName, id);
        }
    }

    /**
     * 获取当前应用在线连接数
     * @param clientPoolTableName
     * @param id
     * @return
     */
    public Integer getCurrentOnlineCount(String clientPoolTableName, Integer id) {
        return clientDao.getCurrentOnlineCount(clientPoolTableName,id);
    }

    /**
     * 应用离线登记
     * @param clientPoolTableName
     * @param clientId
     * @return
     */
    public Integer offLine(String clientPoolTableName, String clientId) {
        return clientDao.offLine(clientPoolTableName,clientId);
    }

    /**
     * 获取当前连接信息
     * @param did
     * @param aid
     * @param page
     * @param num
     * @return
     * @throws ClientConnNotExistsException
     */
    public List<ClientConn> getAppConn(Integer did, Integer aid, Integer page, Integer num) throws ClientConnNotExistsException {

        List<ClientConn> clientConns = clientDao.getConns(did,aid,page*num,num);
        if(clientConns==null){
            throw  new ClientConnNotExistsException(CONSTANT.CONN_NOT_EXISTS);
        }
        return clientConns;
    }


}
