package com.iot.nero.service;

import com.iot.nero.dto.KeySecret;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_control.dto.ControlResult;

import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午3:49
 */
public interface IControlService {
    /**
     * 控制
     * @param keySecret
     * @param appId
     * @param clientId
     * @param controlData
     * @return
     */
    Result<ControlResult> control(KeySecret keySecret, Integer appId, String clientId, Map<String,List<Object>> controlData);
}
