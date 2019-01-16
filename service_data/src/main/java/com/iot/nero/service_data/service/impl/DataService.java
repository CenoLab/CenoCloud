package com.iot.nero.service_data.service.impl;
import com.google.gson.Gson;
import com.iot.nero.Consumer;
import com.iot.nero.dto.Result;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.facade.IDataFacade;
import com.iot.nero.parent_app.constant.CONSTANT;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.Application;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_app.exception.AppAuthFailedException;
import com.iot.nero.parent_app.exception.AppNotExistsException;
import com.iot.nero.parent_data.dto.DataResult;
import com.iot.nero.parent_data.dto.MsgData;
import com.iot.nero.parent_data.entity.MQMessage;
import com.iot.nero.service.IDataService;
import com.iot.nero.utils.math.MathCompute;
import com.iot.nero.utils.math.exceptions.NoMathMethodException;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import static com.iot.nero.parent_data.constant.CONSTANT.DATAPOINT_INDEX_OUT_OF_RANGE;
import static com.iot.nero.parent_data.constant.CONSTANT.DATA_FACADE_EXCEPTION;
import static com.iot.nero.parent_data.constant.CONSTANT.DATA_POINT_NOT_FOUND;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/27
 * Time   下午5:07
 */
@Service
public class DataService implements IDataService {

    private IApplicationFacade applicationFacade;
    private IDataFacade dataFacade;

    public Result<DataResult> getDataByMath(KeySecret keySecret, Integer appId,String clientId, Integer dataPointId, Integer index, String type, String fromTime, String toTime) {
        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<DataResult>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.auth(appId,keySecret);

            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalArgumentException e) {
                return new Result<DataResult>(false, DATA_FACADE_EXCEPTION);
            }

            List<MQMessage> datas = dataFacade.getClientDataByTime(appId,clientId,fromTime,toTime);

            List<DataPoint> dataPoint = applicationFacade.getDataPoint(appId);

            String dataPointName = "";
            for(DataPoint dp:dataPoint){
                if(Objects.equals(dp.getId(), dataPointId)){
                    dataPointName = dp.getName();
                }
            }

            if(dataPointName.equals("")){
                return new Result<DataResult>(false, DATA_POINT_NOT_FOUND);
            }
            return getDataByTimeMath(datas,clientId, dataPointName, index, application, type, fromTime, toTime);
        } catch (AppNotExistsException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (AppAuthFailedException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (InvocationTargetException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (NoSuchMethodException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (IllegalAccessException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (NoMathMethodException e) {
            return new Result<DataResult>(false, e.getMessage());
        } catch (ClassNotFoundException e) {
            return new Result<DataResult>(false, e.getMessage());
        }

    }

    @Override
    public Result<List<DataPoint>> getDataPointList(KeySecret keySecret, Integer appId) {
        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<DataPoint>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.auth(appId,keySecret);

            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<DataPoint>>(false, DATA_FACADE_EXCEPTION);
            }

            List<DataPoint> dataPoint = applicationFacade.getDataPoint(appId);
            return new Result<List<DataPoint>>(true,dataPoint);
        } catch (AppNotExistsException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        } catch (AppAuthFailedException e) {
            return new Result<List<DataPoint>>(false, e.getMessage());
        }
    }

    @Override
    public Result<MsgData> getDataByCurrent(KeySecret keySecret, Integer appId, String clientId) {
        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<MsgData>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }

            Application application = applicationFacade.auth(appId,keySecret);
            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalArgumentException e) {
                return new Result<MsgData>(false, DATA_FACADE_EXCEPTION);
            }

            MQMessage datas = dataFacade.getClientDataByCurrent(appId,clientId);

            //JSON序列化
            Gson gson = new Gson();
            MsgData dataResult = gson.fromJson(datas.getMMessage(),MsgData.class);

            return new Result<MsgData>(true,dataResult);

        } catch (AppNotExistsException e) {
            return new Result<MsgData>(false, e.getMessage());
        } catch (AppAuthFailedException e) {
            return new Result<MsgData>(false, e.getMessage());
        }
    }

    @Override
    public Result<List<MsgData>> getDataByTimePage(KeySecret keySecret, Integer appId, String clientId, String from, String to, Integer page, Integer num) {
        try {
            try {
                applicationFacade = (IApplicationFacade) Consumer.singleton().getBean("IApplicationFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<MsgData>>(false, CONSTANT.APP_FACADE_EXCEPTION);
            }
            Application application = applicationFacade.auth(appId,keySecret);

            try {
                dataFacade = (IDataFacade) Consumer.singleton().getBean("IDataFacade");
            } catch (IllegalArgumentException e) {
                return new Result<List<MsgData>>(false, DATA_FACADE_EXCEPTION);
            }

            List<MQMessage> datas = dataFacade.getClientDataByTimePage(appId,clientId,from,to,page,num);

            List<MsgData> msgDatas = new ArrayList<>();
            Gson gson = new Gson();
            for(MQMessage mqMessage:datas){
                MsgData dataResult = gson.fromJson(mqMessage.getMMessage(),MsgData.class);
                msgDatas.add(dataResult);
            }

            return new Result<List<MsgData>>(true,msgDatas);
        } catch (AppNotExistsException e) {
            return new Result<List<MsgData>>(false, e.getMessage());
        } catch (AppAuthFailedException e) {
            return new Result<List<MsgData>>(false, e.getMessage());
        }
    }

    private Result<DataResult> getDataByTime(List<MQMessage> datas,String clientId,String dataPointName,Integer index,Application application,String type,String fromTime,String toTime){
        Map<Object,String> objectStringMap = new HashMap<Object,String>();
        Gson gson = new Gson();
        for(MQMessage mqMessage:datas){
            String message = mqMessage.getMMessage();
            //JSON序列化
            MsgData dataResult = gson.fromJson(message,MsgData.class);
            List<Object> objectList = dataResult.getD().get(dataPointName);
            if(objectList.size()<=index){
                return new Result<DataResult>(false, DATAPOINT_INDEX_OUT_OF_RANGE);
            }
            Object object = objectList.get(index);
            if(object instanceof Double){
                objectStringMap.put((Double) object,dataResult.getTs());
            }
            if(object instanceof Float){
                objectStringMap.put(((Float) object).doubleValue(),dataResult.getTs());
            }
            if(object instanceof Integer){
                objectStringMap.put(((Integer) object).doubleValue(),dataResult.getTs());
            }
            if(object instanceof Boolean){
                objectStringMap.put((Boolean) object,dataResult.getTs());
            }
        }


        return new Result<DataResult>(true, new DataResult(application.getName(),
                clientId,
                dataPointName,
                index,
                type,
                fromTime,
                toTime,
                objectStringMap));
    }


    private Result<DataResult> getDataByTimeMath(List<MQMessage> datas, String clientId, String dataPointName, Integer index, Application application, String type, String fromTime, String toTime) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, NoMathMethodException, IllegalAccessException {
        List<Double> dataPointList = new ArrayList<>();
        Gson gson = new Gson();
        for(MQMessage mqMessage:datas){
            String message = mqMessage.getMMessage();
            //JSON序列化
            MsgData dataResult = gson.fromJson(message,MsgData.class);
            List<Object> objectList = dataResult.getD().get(dataPointName);
            if(objectList.size()<=index){
                return new Result<DataResult>(false, DATAPOINT_INDEX_OUT_OF_RANGE);
            }
            Object object = objectList.get(index);
            if(object instanceof Double){
                dataPointList.add(((Double) object).doubleValue());
            }
            if(object instanceof Float){
                dataPointList.add(((Float) object).doubleValue());
            }
            if(object instanceof Integer){
                dataPointList.add(((Integer) object).doubleValue());
            }
        }

        MathCompute mathCompute = new MathCompute();

        return new Result<DataResult>(true, new DataResult(application.getName(),
                clientId,
                dataPointName,
                index,
                type,
                fromTime,
                toTime,
                mathCompute.executeMathCompute(type,dataPointList)));
    }
}
