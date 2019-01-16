package com.iot.nero.service_alarm.service.impl;

import com.iot.nero.constant.ClientType;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.IAlarmFacade;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.facade.IDeveloperFacade;
import com.iot.nero.parent_alarm.constant.CONSTANT;
import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Condition;
import com.iot.nero.parent_alarm.entity.Express;
import com.iot.nero.parent_alarm.exception.OperatorNotFoundException;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_app.exception.AppNotExistsException;
import com.iot.nero.parent_app.exception.DataPointNotExistsException;
import com.iot.nero.parent_sso.exception.DeveloperNotExistsException;
import com.iot.nero.parent_sso.exception.TokenExpiredException;
import com.iot.nero.service.IAlarmService;
import com.iot.nero.service.impl.BaseAuthService;
import com.iot.nero.service_alarm.Consumer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.iot.nero.parent_alarm.constant.CONSTANT.CONDITION_ADD_FAILED;
import static com.iot.nero.parent_app.constant.CONSTANT.ACCESS_WITHOUT_PRODUCT_KEY;
import static com.iot.nero.parent_app.constant.CONSTANT.DATAPOINT_NOT_EXISTS;
import static com.iot.nero.parent_sso.constant.CONSTANT.SSO_FACADE_EXCEPTION;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/4
 * Time   下午7:21
 */
@Service
public class AlarmService extends BaseAuthService implements IAlarmService {


    private IAlarmFacade alarmFacade;
    private IApplicationFacade applicationFacade;
    private IDeveloperFacade developerFacade;


    public Result<Condition> addCondition(Integer uid, String token, Integer dataPoint, Integer index, String expressStr, Integer rightType, String rightValue, ClientType clientType) {
        try {
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                isTokenAccess(developerFacade, uid, token, clientType);
            } catch (IllegalArgumentException e) {
                return new Result<Condition>(false, SSO_FACADE_EXCEPTION);
            } catch (DeveloperNotExistsException e) {
                return new Result<Condition>(false, e.getMessage());
            } catch (TokenExpiredException e) {
                return new Result<Condition>(false, e.getMessage());
            }

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<Condition>(false, DATAPOINT_NOT_EXISTS);
            }

            DataPoint dataPointResult = applicationFacade.getDataPointById(dataPoint);
            Application application = applicationFacade.getApplication(dataPointResult.getAppId());
            if (!application.getDId().equals(uid)) {
                return new Result<Condition>(false, ACCESS_WITHOUT_PRODUCT_KEY);
            }

            try {
                alarmFacade = (IAlarmFacade) Consumer.singleton().getBean("IAlarmFacade");
            } catch (IllegalArgumentException e) {
                return new Result<Condition>(false, CONSTANT.ALARM_FACADE_EXCEPTION);
            }

            Express express = alarmFacade.getExpressByStr(expressStr);

            Integer addConditionResult = alarmFacade.addConditionForDataPoint(dataPoint, index, express.getId(), rightType, rightValue);
            if (addConditionResult < 1) {
                return new Result<Condition>(false, CONDITION_ADD_FAILED);
            }
            return new Result<Condition>(true, new Condition());
        } catch (OperatorNotFoundException e) {
            return new Result<Condition>(false, e.getMessage());
        } catch (DataPointNotExistsException e) {
            return new Result<Condition>(false, e.getMessage());
        } catch (AppNotExistsException e) {
            return new Result<Condition>(false, e.getMessage());
        }
    }


    public Result<List<ConditionFinal>> getDataPointConditions(Integer uid, String token, Integer dataPointId, ClientType clientType) {
        try {
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                isTokenAccess(developerFacade, uid, token, clientType);
            } catch (IllegalArgumentException e) {
                return new Result<List<ConditionFinal>>(false, SSO_FACADE_EXCEPTION);
            } catch (DeveloperNotExistsException e) {
                return new Result<List<ConditionFinal>>(false, e.getMessage());
            } catch (TokenExpiredException e) {
                return new Result<List<ConditionFinal>>(false, e.getMessage());
            }

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<ConditionFinal>>(false, DATAPOINT_NOT_EXISTS);
            }

            DataPoint dataPointResult = applicationFacade.getDataPointById(dataPointId);
            Application application = applicationFacade.getApplication(dataPointResult.getAppId());
            if (!application.getDId().equals(uid)) {
                return new Result<List<ConditionFinal>>(false, ACCESS_WITHOUT_PRODUCT_KEY);
            }

            try {
                alarmFacade = (IAlarmFacade) Consumer.singleton().getBean("IAlarmFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<ConditionFinal>>(false, CONSTANT.ALARM_FACADE_EXCEPTION);
            }

            return new Result<List<ConditionFinal>>(true, alarmFacade.getDataPointAlarmConditions(dataPointId));


        } catch (AppNotExistsException e) {
            return new Result<List<ConditionFinal>>(false, e.getMessage());
        } catch (DataPointNotExistsException e) {
            return new Result<List<ConditionFinal>>(false, e.getMessage());
        }
    }

    public Result<List<List<ConditionFinal>>> getAllDataPointConditions(Integer uid, String token, Integer aid, ClientType clientType) {
        try {
            try {
                developerFacade = (IDeveloperFacade) Consumer.singleton().getBean("IDeveloperFacade");
                isTokenAccess(developerFacade, uid, token, clientType);
            } catch (IllegalArgumentException e) {
                return new Result<List<List<ConditionFinal>>>(false, SSO_FACADE_EXCEPTION);
            } catch (DeveloperNotExistsException e) {
                return new Result<List<List<ConditionFinal>>>(false, e.getMessage());
            } catch (TokenExpiredException e) {
                return new Result<List<List<ConditionFinal>>>(false, e.getMessage());
            }

            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<List<ConditionFinal>>>(false, DATAPOINT_NOT_EXISTS);
            }
            Application application = applicationFacade.getApplication(aid);
            if(application.getDId()!=uid){
                return new Result<List<List<ConditionFinal>>>(false, ACCESS_WITHOUT_PRODUCT_KEY);
            }
            List<DataPoint> dataPointResult = applicationFacade.getDataPoint(aid);

            List<List<ConditionFinal>> resultConditionalList = new ArrayList<List<ConditionFinal>>();

            try {
                alarmFacade = (IAlarmFacade) Consumer.singleton().getBean("IAlarmFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<List<ConditionFinal>>>(false, CONSTANT.ALARM_FACADE_EXCEPTION);
            }
            if (dataPointResult != null) {
                for (DataPoint dataPoint : dataPointResult) {
                    List<ConditionFinal> conditionFinals = alarmFacade.getDataPointAlarmConditions(dataPoint.getId());
                    for(ConditionFinal conditionFinal:conditionFinals){
                        conditionFinal.setDname(applicationFacade.getDataPointById(conditionFinal.getDId()).getName());
                    }
                    if (conditionFinals != null && !conditionFinals.isEmpty()) {
                        resultConditionalList.add(conditionFinals);
                    }
                }
            }
            return new Result<List<List<ConditionFinal>>>(true, resultConditionalList);


        } catch (AppNotExistsException e) {
            return new Result<List<List<ConditionFinal>>>(false, e.getMessage());
        } catch (DataPointNotExistsException e) {
            return new Result<List<List<ConditionFinal>>>(false, e.getMessage());
        }
    }
}
