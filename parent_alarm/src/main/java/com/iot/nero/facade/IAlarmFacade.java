package com.iot.nero.facade;

import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Express;
import com.iot.nero.parent_alarm.entity.Log;
import com.iot.nero.parent_alarm.exception.AlarmLogCreateFailedException;
import com.iot.nero.parent_alarm.exception.OperatorNotFoundException;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/16
 * Time   下午6:54
 */
public interface IAlarmFacade {

    Integer addConditionForDataPoint(Integer dataPointID,Integer Index,Integer expressId,Integer rightType,String right);

    List<Log> getDataPointAlarmLogs(Integer appId,Integer dataPointId,Integer from,Integer num) throws AlarmLogCreateFailedException;

    List<ConditionFinal> getDataPointAlarmConditions(Integer dataPointId);

    List<Log> getAlarmLogByDataPointIdAndTimeStamp(Integer appId,Integer dataPointId,Integer fromPage,Integer num,Long from,Long to);

    Integer addDataPointAlarmLog(Integer appId,Integer dataPointId,Integer messageId, Integer conditionId);

    Express getExpressByStr(String expressStr) throws OperatorNotFoundException;
}
