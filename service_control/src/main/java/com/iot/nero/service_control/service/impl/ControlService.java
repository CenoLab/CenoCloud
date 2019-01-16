package com.iot.nero.service_control.service.impl;

import com.google.gson.Gson;
import com.iot.nero.Consumer;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.facade.IDataFacade;
import com.iot.nero.parent_app.constant.CONSTANT;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_app.exception.AppAuthFailedException;
import com.iot.nero.parent_app.exception.AppNotExistsException;
import com.iot.nero.parent_control.dto.ControlResult;
import com.iot.nero.service.IControlService;
import com.iot.nero.utils.mq.MqttService;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.iot.nero.parent_data.constant.CONSTANT.DATA_POINT_NOT_FOUND;
import static com.iot.nero.parent_data.constant.CONSTANT.DATA_POINT_TYPE_ERROR;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午4:51
 */
@Service
public class ControlService implements IControlService {

    private IApplicationFacade applicationFacade;
    private IDataFacade dataFacade;

    /**
     * 控制
     * @param keySecret
     * @param appId
     * @param clientId
     * @param controlData
     * @return
     */
    public Result<ControlResult> control(KeySecret keySecret, Integer appId, String clientId, Map<String, List<Object>> controlData) {

        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<ControlResult>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.auth(appId, keySecret);

            List<DataPoint> dataPoint = applicationFacade.getDataPoint(appId);

            if(dataPoint.isEmpty()){
                return new Result<ControlResult>(false, DATA_POINT_NOT_FOUND);
            }

            Map<String,String> dataPointMap = new HashMap<String, String>();

            for(DataPoint dp:dataPoint){
                if(dp.getAccess()==1){
                    dataPointMap.put(dp.getName(),dp.getType());
                }
            }

            if(dataPointMap.isEmpty()){
                return new Result<ControlResult>(false, DATA_POINT_NOT_FOUND);
            }

            for(String s : controlData.keySet()){
                if(!dataPointMap.containsKey(s)){
                    return new Result<ControlResult>(false, DATA_POINT_NOT_FOUND+":"+s);
                }else{
                    String type = dataPointMap.get(s);
                    List<Object> objectList = controlData.get(s);
                    if(objectList==null){
                        return new Result<ControlResult>(false, DATA_POINT_NOT_FOUND);
                    }
                    Class cls = Class.forName("java.lang."+type);
                    for(Object ob:objectList){
                        if(!ob.getClass().equals(cls)){
                            return new Result<ControlResult>(false, DATA_POINT_TYPE_ERROR+":"+s);
                        }
                    }
                }
            }


            try {
                MqttService.publish("MD8i4XR9rCOWW69ynR+X8Q==",
                        "ZGYmTXZrGKf9tHg8T_MhvQ==",
                        1,
                        "tcp://www.cenocloud.com:1883",
                        "system.iot.push",
                        "/"+application.getDId()+"/"+keySecret.getSecretKey()+"/"+clientId,
                        new Gson().toJson(controlData));
            } catch (MqttException e) {
                return new Result<ControlResult>(false, e.getMessage());
            }

            return new Result<ControlResult>(true,new ControlResult(controlData));

        } catch (AppNotExistsException e) {
            return new Result<ControlResult>(false, e.getMessage());
        } catch (AppAuthFailedException e) {
            return new Result<ControlResult>(false, e.getMessage());
        } catch (ClassNotFoundException e) {
            return new Result<ControlResult>(false, e.getMessage());
        }
    }
}
