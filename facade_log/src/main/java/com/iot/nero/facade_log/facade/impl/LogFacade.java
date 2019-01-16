package com.iot.nero.facade_log.facade.impl;

import com.google.gson.Gson;
import com.iot.nero.facade.ILogFacade;
import com.iot.nero.facade_log.dao.LogDao;
import com.iot.nero.parent_log.constant.CONSTANT;
import com.iot.nero.parent_log.dto.LList;
import com.iot.nero.parent_log.entity.ClientLog;
import com.iot.nero.parent_log.entity.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   上午10:15
 */
@Service
public class LogFacade implements ILogFacade {

    @Autowired
    private LogDao logDao;

    public String formatKey(String key){


        key = key.replace('!','_');
        key = key.replace('%','_');
        key = key.replace('@','_');
        key = key.replace('#','_');
        key = key.replace('$','_');
        key = key.replace('^','_');
        key = key.replace('~','_');
        key = key.replace('&','_');
        key = key.replace('*','_');
        key = key.replace('+','_');
        key = key.replace('(','_');
        key = key.replace('=','_');
        key =  key.replace(')','_');
        System.out.println(key);
        return key;
    }
    /**
     * 设备日志记录
     * @param type
     * @param level
     * @param message
     * @return
     */
    public Boolean clientLog(String productKey,Integer type, Integer level, String message) {

        try {
            if (logDao.insertClientLog(formatKey(productKey),type, level, message) < 1) {
                return false;
            }
            return true;
        }catch(BadSqlGrammarException e){
            if(logDao.createClientLogTable(formatKey(productKey))<1){
                return false;
            }
            if (logDao.insertClientLog(formatKey(productKey),type, level, message) < 1) {
                return false;
            }
            return true;
        }
    }

    /**
     * 分页，分类型，分日志等级获取设备日志
     * @param productKey
     * @param type
     * @param level
     * @param page
     * @param num
     * @return
     */
    public LList<List<ClientLog>> getClientLog(String productKey, Integer type, Integer level, Integer page, Integer num){
        try {
            List<ClientLog> clientLogList = logDao.getClientLog(formatKey(productKey),type,level,page*num,num);
            Integer count = logDao.getCount(formatKey(productKey),type,level);
            return new LList<List<ClientLog>>(count,clientLogList);
        }catch(BadSqlGrammarException e){
            if(logDao.createClientLogTable(formatKey(productKey))<1){
                return null;
            }
            return null;
        }
    }

    /**
     *系统日志
     * @param type
     * @param log
     */
    public Integer SysLog(Long type,String log){
        Gson gson = new Gson();
        SystemLog systemLog = gson.fromJson(log, SystemLog.class);
        System.out.println(systemLog.toString());
        return logDao.insertSysLog(systemLog.getType(),systemLog.getContent());
    }
}
