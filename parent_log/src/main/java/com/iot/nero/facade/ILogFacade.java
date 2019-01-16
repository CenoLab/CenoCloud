package com.iot.nero.facade;


import com.iot.nero.parent_log.dto.LList;
import com.iot.nero.parent_log.entity.ClientLog;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   上午9:26
 */
public interface ILogFacade {
    /**
     * 设备日志记录
     * @param type
     * @param level
     * @param message
     * @return
     */
    Boolean clientLog(String secretKey,Integer type, Integer level, String message);


    /**
     * 获取设备日志
     * @param productKey
     * @param type
     * @param level
     * @param page
     * @param num
     * @return
     */
    LList<List<ClientLog>> getClientLog(String productKey, Integer type, Integer level, Integer page, Integer num);


    /**
     * 插入系统日志
     * @param type
     * @param log
     * @return
     */
    Integer SysLog(Long type,String log);
}
