package com.iot.nero.service;

import com.iot.nero.dto.KeySecret;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_data.dto.DataResult;
import com.iot.nero.parent_data.dto.MsgData;
import com.iot.nero.parent_data.entity.MQMessage;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/27
 * Time   下午4:49
 */
public interface IDataService {

    Result<DataResult> getDataByMath(KeySecret keySecret, Integer appId,String clientId, Integer dataPointId, Integer index, String type, String fromTime, String toTime);

    Result<List<DataPoint>> getDataPointList(KeySecret keySecret, Integer appId);

    Result<MsgData> getDataByCurrent(KeySecret keySecret, Integer appId, String clientId);

    Result<List<MsgData>> getDataByTimePage(KeySecret keySecret, Integer appId, String clientId,String from, String to, Integer page, Integer num);
}
