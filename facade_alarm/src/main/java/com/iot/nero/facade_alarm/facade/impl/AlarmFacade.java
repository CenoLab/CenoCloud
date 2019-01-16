package com.iot.nero.facade_alarm.facade.impl;

import com.iot.nero.facade.IAlarmFacade;
import com.iot.nero.facade_alarm.dao.AlarmLogDao;
import com.iot.nero.facade_alarm.dao.ConditionDao;
import com.iot.nero.facade_alarm.dao.ExpressDao;
import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Condition;
import com.iot.nero.parent_alarm.entity.Express;
import com.iot.nero.parent_alarm.entity.Log;
import com.iot.nero.parent_alarm.exception.AlarmLogCreateFailedException;
import com.iot.nero.parent_alarm.exception.OperatorNotFoundException;
import javassist.compiler.ast.Expr;
import org.junit.experimental.theories.DataPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.iot.nero.parent_alarm.constant.CONSTANT.ALARM_LOG_TABLE_CREATE_FAILED;
import static com.iot.nero.parent_alarm.constant.CONSTANT.EXPRESS_OPERATOR_NOT_FOUND;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/25
 * Time   下午2:28
 */

@Service
public class AlarmFacade implements IAlarmFacade {

    @Autowired
    private AlarmLogDao alarmLogDao;
    @Autowired
    private ConditionDao conditionDao;
    @Autowired
    private ExpressDao expressDao;

    public Integer addConditionForDataPoint(Integer dataPointID, Integer index, Integer expressId, Integer rightType, String right) {

        return conditionDao.insertCondition(dataPointID,index,expressId,rightType,right);

    }

    public List<Log> getDataPointAlarmLogs(Integer appId,Integer dataPointId, Integer from, Integer num) throws AlarmLogCreateFailedException {

        try {
            return alarmLogDao.getAlarmLogByDataPointId(appId, dataPointId, from, num);
        }catch (BadSqlGrammarException exception){
            if(alarmLogDao.createAlarmLogTable(appId)>0){
                return alarmLogDao.getAlarmLogByDataPointId(appId, dataPointId, from, num);
            }
            throw new AlarmLogCreateFailedException(ALARM_LOG_TABLE_CREATE_FAILED);
        }

    }

    public List<ConditionFinal> getDataPointAlarmConditions(Integer dataPointId) {

        List<Condition> conditions = conditionDao.getConditionsByDataPointId(dataPointId);
        List<ConditionFinal> conditionFinals = new ArrayList<ConditionFinal>();
        if((conditions != null) && (!conditions.isEmpty())){
            for(Condition condition:conditions){
                Express express = expressDao.getExpressById(condition.getExpressId());
                if(express!=null){
                    conditionFinals.add(new ConditionFinal(
                            condition.getId(),
                            condition.getDId(),
                            condition.getDIndex(),
                            "",
                            express.getOpeator(),
                            condition.getRightValueType(),
                            condition.getRightValue(),
                            condition.getCreateTime()
                    ));
                }
            }
            return conditionFinals;
        }
        return conditionFinals;
    }

    public List<Log> getAlarmLogByDataPointIdAndTimeStamp(Integer appId,Integer dataPointId, Integer fromPage, Integer num, Long from, Long to) {

        return alarmLogDao.getAlarmLogByDataPointIdAndTimeStamp(appId,dataPointId,fromPage,num,from,to);

    }

    public Integer addDataPointAlarmLog(Integer appId,Integer dataPointId,Integer messageId, Integer conditionId) {

        return alarmLogDao.insertAlarmLog(appId,dataPointId,messageId,conditionId);

    }

    public Express getExpressByStr(String expressStr) throws OperatorNotFoundException {
        Express express = expressDao.getExpressByStr(expressStr);
        if(express==null){
            throw new OperatorNotFoundException(EXPRESS_OPERATOR_NOT_FOUND);
        }
        return express;
    }
}
