package com.iot.nero.web_data.controller;

import com.iot.nero.dto.Result;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_app.entity.DataPoint;
import com.iot.nero.parent_data.constant.CONSTANT;
import com.iot.nero.parent_data.dto.DataResult;
import com.iot.nero.parent_data.dto.MsgData;
import com.iot.nero.parent_data.entity.MQMessage;
import com.iot.nero.service.IDataService;
import com.iot.nero.web_data.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.iot.nero.constant.CONSTANT.HEADER_NOT_FOUND_EXCEPTION;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/26
 * Time   下午9:42
 */
@Controller
@RequestMapping("/api/v1/")
public class ApiData {

    private IDataService dataService;

    @RequestMapping(value = "data/{appId}/{clientId}/{dataPointId}/{index}/{type}/{from}/{to}",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DataResult> getDataPointByTime(
            @PathVariable("appId") Integer appId,
            @PathVariable("clientId") String clientId,
            @PathVariable("dataPointId") Integer dataPointId,
            @PathVariable("index") Integer index,
            @PathVariable("type") String type,
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            HttpServletRequest request) {

        try {
            dataService = (IDataService) Consumer.singleton().getBean("IDataService");
            if (request.getHeader("FromAgent").equals("third")) {
                String appKey = request.getHeader("appKey");
                String appSecret = request.getHeader("appSecret");
                KeySecret keySecret = new KeySecret(appKey, appSecret);
                return dataService.getDataByMath(keySecret, appId,clientId, dataPointId, index, type, from, to);
            }else{
                return new Result<DataResult>(false, HEADER_NOT_FOUND_EXCEPTION);
            }
        } catch (IllegalStateException e) {
            return new Result<DataResult>(false, CONSTANT.DATA_SERVICE_EXCEPTION);
        }

    }


    @RequestMapping(value = "data/{appId}/{clientId}/{from}/{to}/{page}/{num}/history",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<List<MsgData>> getDataPointHistory(
            @PathVariable("appId") Integer appId,
            @PathVariable("clientId") String clientId,
            @PathVariable("from") String from,
            @PathVariable("to") String to,
            @PathVariable("page") Integer page,
            @PathVariable("num") Integer num,
            HttpServletRequest request) {

        try {
            dataService = (IDataService) Consumer.singleton().getBean("IDataService");
            if (request.getHeader("FromAgent").equals("third")) {
                String appKey = request.getHeader("appKey");
                String appSecret = request.getHeader("appSecret");
                KeySecret keySecret = new KeySecret(appKey, appSecret);
                return dataService.getDataByTimePage(keySecret, appId,clientId,from,to,page,num);
            }else{
                return new Result<List<MsgData>>(false, HEADER_NOT_FOUND_EXCEPTION);
            }
        } catch (IllegalStateException e) {
            return new Result<List<MsgData>>(false, CONSTANT.DATA_SERVICE_EXCEPTION);
        }

    }
    @RequestMapping(value = "data/{appId}/{clientId}/current",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<MsgData> getDataPointCurrent(
            @PathVariable("appId") Integer appId,
            @PathVariable("clientId") String clientId,
            HttpServletRequest request) {

        try {
            dataService = (IDataService) Consumer.singleton().getBean("IDataService");
            if (request.getHeader("FromAgent").equals("third")) {
                String appKey = request.getHeader("appKey");
                String appSecret = request.getHeader("appSecret");
                KeySecret keySecret = new KeySecret(appKey, appSecret);
                return dataService.getDataByCurrent(keySecret, appId,clientId);
            }else{
                return new Result<MsgData>(false, HEADER_NOT_FOUND_EXCEPTION);
            }
        } catch (IllegalStateException e) {
            return new Result<MsgData>(false, CONSTANT.DATA_SERVICE_EXCEPTION);
        }

    }


    @RequestMapping(value = "dataPoint/{appId}/list",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<List<DataPoint>> getDataPointList(
            @PathVariable("appId") Integer appId,
            HttpServletRequest request) {

        try {
            dataService = (IDataService) Consumer.singleton().getBean("IDataService");
            if (request.getHeader("FromAgent").equals("third")) {
                String appKey = request.getHeader("appKey");
                String appSecret = request.getHeader("appSecret");
                KeySecret keySecret = new KeySecret(appKey, appSecret);
                return dataService.getDataPointList(keySecret, appId);
            }else{
                return new Result<List<DataPoint>>(false, HEADER_NOT_FOUND_EXCEPTION);
            }
        } catch (IllegalStateException e) {
            return new Result<List<DataPoint>>(false, CONSTANT.DATA_SERVICE_EXCEPTION);
        }

    }

}



