package com.iot.nero.service;

import com.iot.nero.constant.ClientType;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.IAlarmFacade;
import com.iot.nero.parent_alarm.constant.CONSTANT;
import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Condition;
import com.iot.nero.parent_alarm.entity.Express;
import com.iot.nero.parent_alarm.exception.OperatorNotFoundException;

import java.util.List;

import static com.iot.nero.parent_alarm.constant.CONSTANT.CONDITION_ADD_FAILED;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/16
 * Time   下午6:54
 */
public interface IAlarmService {

    Result<Condition> addCondition(Integer uid, String token, Integer dataPoint, Integer index, String expressStr, Integer rightType, String rightValue, ClientType clientType);

    Result<List<ConditionFinal>> getDataPointConditions(Integer uid, String token, Integer dataPointId, ClientType clientType);

    Result<List<List<ConditionFinal>>> getAllDataPointConditions(Integer uid, String token, Integer aid, ClientType clientType);
}
