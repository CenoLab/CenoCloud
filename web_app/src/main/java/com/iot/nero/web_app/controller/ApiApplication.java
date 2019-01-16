package com.iot.nero.web_app.controller;

import com.iot.nero.dto.Result;
import com.iot.nero.parent_alarm.dto.ConditionFinal;
import com.iot.nero.parent_alarm.entity.Condition;
import com.iot.nero.parent_app.constant.CONSTANT;
import com.iot.nero.parent_app.dto.ApplicationResult;
import com.iot.nero.parent_app.entity.*;
import com.iot.nero.parent_data.entity.MQMessage;
import com.iot.nero.parent_log.dto.LList;
import com.iot.nero.parent_log.entity.ClientLog;
import com.iot.nero.service.IAlarmService;
import com.iot.nero.service.IApplicationService;
import com.iot.nero.service.IClientService;
import com.iot.nero.web_app.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   下午1:43
 */
@Controller
@RequestMapping("/app")
public class ApiApplication {

    private IApplicationService applicationService;
    private IClientService clientService;
    private IAlarmService alarmService;

    @RequestMapping(value = "/{uid}/{token}/auth/{name}/{type}/{tech}/{trans}/{company}/{maxConn}/{desc}/create",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<Application> createApplication(@PathVariable("uid") Integer DId,
                                                 @PathVariable("token") String token,
                                                 @PathVariable("name") String name,
                                                 @PathVariable("type") String type,
                                                 @PathVariable("tech") String tech,
                                                 @PathVariable("trans") Integer trans,
                                                 @PathVariable("company") String company,
                                                 @PathVariable("maxConn") Integer maxConnect,
                                                 @PathVariable("desc") String desc,
                                                 HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");

            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.createApplication(DId,token,name,type,tech,trans,company,maxConnect,desc,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.createApplication(DId,token,name,type,tech,trans,company,maxConnect,desc,MOBILE_IPHONE);
            } else {
                return applicationService.createApplication(DId,token,name,type,tech,trans,company,maxConnect,desc,BROWSER);
            }

        }catch (IllegalStateException e) {
            return new Result<Application>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }




    @RequestMapping(value = "/{uid}/{token}/auth/apps",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<ApplicationResult>> getApplications(@PathVariable("uid") Integer Uid,
                                                           @PathVariable("token") String token,
                                                           HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getApplications(Uid,token,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getApplications(Uid,token,MOBILE_IPHONE);
            } else {
                return applicationService.getApplications(Uid,token,BROWSER);
            }

        }catch (IllegalStateException e)
        {
            return new Result<List<ApplicationResult>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }




    @RequestMapping(value = "/{uid}/{token}/auth/{pwd}/verify/{aid}/app",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<Application> getApplication(@PathVariable("uid") Integer uid,
                                              @PathVariable("aid") Integer aid,
                                              @PathVariable("token") String token,
                                              @PathVariable("pwd") String pwd,
                                              HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getApplication(uid,aid,token, pwd,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getApplication(uid,aid,token, pwd,MOBILE_IPHONE);
            } else {
                return applicationService.getApplication(uid,aid,token, pwd,BROWSER);
            }

        }catch (IllegalStateException e)
        {
            return new Result<Application>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }




    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/appinfo",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<ApplicationResult> getApplicationInfo(@PathVariable("uid") Integer uid,
                                              @PathVariable("aid") Integer aid,
                                              @PathVariable("token") String token,
                                                        HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getApplicationInfo(uid,aid,token,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getApplicationInfo(uid,aid,token,MOBILE_IPHONE);
            } else {
                return applicationService.getApplicationInfo(uid,aid,token,BROWSER);
            }

        }catch (IllegalStateException e)
        {
            return new Result<ApplicationResult>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }




    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/dataPoint/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<DataPoint>> getDataPoints(@PathVariable("uid") Integer uid,
                                                 @PathVariable("aid") Integer aid,
                                                 @PathVariable("token") String token,
                                                 HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getDataPoints(uid, aid, token,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getDataPoints(uid, aid, token,MOBILE_IPHONE);
            } else {
                return applicationService.getDataPoints(uid, aid, token,BROWSER);
            }

        }catch (IllegalStateException e)
        {
            return new Result<List<DataPoint>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }

    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{name}/{type}/{access}/dataPoint/add",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<DataPoint> addDataPoints(@PathVariable("uid") Integer uid,
                                           @PathVariable("aid") Integer aid,
                                           @PathVariable("name") String name,
                                           @PathVariable("type") String type,
                                           @PathVariable("access") Integer access,
                                           @PathVariable("token") String token,
                                           HttpServletRequest request){
        try{
            applicationService = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.addDataPoints(uid, aid, new DataPointInfo(aid,name,type,access), token,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.addDataPoints(uid, aid, new DataPointInfo(aid,name,type,access), token,MOBILE_IPHONE);
            } else {
                return applicationService.addDataPoints(uid, aid, new DataPointInfo(aid,name,type,access), token,BROWSER);
            }

        }catch (IllegalStateException e)
        {
            return new Result<DataPoint>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{page}/{num}/connections",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<ClientConnResult>> getCurrentConns(@PathVariable("uid") Integer uid,
                                                  @PathVariable("aid") Integer aid,
                                                  @PathVariable("page") Integer page,
                                                  @PathVariable("num") Integer num,
                                                  @PathVariable("token") String token,
                                                          HttpServletRequest request){
        try{
            applicationService  = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getAppCurrentConn(aid,uid,token,page,num,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getAppCurrentConn(aid,uid,token,page,num,MOBILE_IPHONE);
            } else {
                return applicationService.getAppCurrentConn(aid,uid,token,page,num,BROWSER);
            }

        }catch (IllegalStateException e) {
            return new Result<List<ClientConnResult>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{pid}/dataPoint/delete",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<DataPoint> deleteDataPoint(@PathVariable("uid") Integer uid,
                                             @PathVariable("token") String token,
                                             @PathVariable("aid") Integer aid,
                                             @PathVariable("pid") Integer pid,
                                             HttpServletRequest request){
        try{
            applicationService  = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.deleteDataPoint(uid,token,aid,pid,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.deleteDataPoint(uid,token,aid,pid,MOBILE_IPHONE);
            } else {
                return applicationService.deleteDataPoint(uid,token,aid,pid,BROWSER);
            }

        }catch (IllegalStateException e) {
            return new Result<DataPoint>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{page}/{num}/message/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<MQMessage>> getMessage(@PathVariable("uid") Integer uid,
                                              @PathVariable("token")String token,
                                              @PathVariable("aid") Integer aid,
                                              @PathVariable("page") Integer page,
                                              @PathVariable("num") Integer num,
                                              HttpServletRequest request){
        try{
            applicationService  = (IApplicationService)Consumer.singleton().getBean("IApplicationService");
            if (request.getHeader("FromAgent").equals("android")) {
                return applicationService.getMessage(uid,token,aid,page,num,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return applicationService.getMessage(uid,token,aid,page,num,MOBILE_IPHONE);
            } else {
                return applicationService.getMessage(uid,token,aid,page,num,BROWSER);
            }

        }catch (IllegalStateException e) {
            return new Result<List<MQMessage>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{clientId}/{page}/{num}/message/send",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<MQMessage>> getClientSendMessage(@PathVariable("uid") Integer uid,
                                                        @PathVariable("token")String token,
                                                        @PathVariable("aid") Integer aid,
                                                        @PathVariable("clientId") String clientId,
                                                        @PathVariable("page") Integer page,
                                                        @PathVariable("num") Integer num,
                                                        HttpServletRequest request){
        try{
            clientService  = (IClientService) Consumer.singleton().getBean("IClientService");
            if (request.getHeader("FromAgent").equals("android")) {
                return clientService.getClientSendMessage(uid,token,aid,clientId,page,num,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return clientService.getClientSendMessage(uid,token,aid,clientId,page,num,MOBILE_IPHONE);
            } else {
                return clientService.getClientSendMessage(uid,token,aid,clientId,page,num,BROWSER);
            }

        }catch (IllegalStateException e) {
            return new Result<List<MQMessage>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{clientId}/{page}/{num}/message/received",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<MQMessage>> getClientReceivedMessage(@PathVariable("uid") Integer uid,
                                                            @PathVariable("token")String token,
                                                            @PathVariable("aid") Integer aid,
                                                            @PathVariable("clientId") String clientId,
                                                            @PathVariable("page") Integer page,
                                                            @PathVariable("num") Integer num,
                                                            HttpServletRequest request){
        try{
            clientService  = (IClientService)Consumer.singleton().getBean("IClientService");
            if (request.getHeader("FromAgent").equals("android")) {
                return clientService.getClientReceivedMessage(uid,token,aid,clientId,page,num,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return clientService.getClientReceivedMessage(uid,token,aid,clientId,page,num,MOBILE_IPHONE);
            } else {
                return clientService.getClientReceivedMessage(uid,token,aid,clientId,page,num,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<List<MQMessage>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }



    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/{clientId}/message/send/count",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<Integer> getClientSendMessageCount(@PathVariable("uid") Integer uid,
                                                        @PathVariable("token")String token,
                                                        @PathVariable("aid") Integer aid,
                                                        @PathVariable("clientId") String clientId,
                                                     HttpServletRequest request){
        try{
            clientService  = (IClientService) Consumer.singleton().getBean("IClientService");
            if (request.getHeader("FromAgent").equals("android")) {
                return clientService.getClientSendMessageCount(uid,token,aid,clientId,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return clientService.getClientSendMessageCount(uid,token,aid,clientId,MOBILE_IPHONE);
            } else {
                return clientService.getClientSendMessageCount(uid,token,aid,clientId,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<Integer>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }


    /**
     * 设备日志列表
     * @param uid
     * @param token
     * @param aid
     * @param type 设备日志类型
     * @param level 设备日志级别
     * @param page
     * @param num
     * @return
     */
    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/app/{type}/{level}/log/{page}/{num}/get",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<LList<List<ClientLog>>> getLogList(@PathVariable("uid")Integer uid,
                                                     @PathVariable("token") String token,
                                                     @PathVariable("aid") Integer aid,
                                                     @PathVariable("type") Integer type,
                                                     @PathVariable("level") Integer level,
                                                     @PathVariable("page") Integer page,
                                                     @PathVariable("num") Integer num,
                                                     HttpServletRequest request){
        try{
            clientService  = (IClientService) Consumer.singleton().getBean("IClientService");
            if (request.getHeader("FromAgent").equals("android")) {
                return clientService.getClientLog(uid,token,aid,type,level,page,num,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return clientService.getClientLog(uid,token,aid,type,level,page,num,MOBILE_IPHONE);
            } else {
                return clientService.getClientLog(uid,token,aid,type,level,page,num,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<LList<List<ClientLog>>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }

    @RequestMapping(value = "/{uid}/{token}/auth/{aid}/app/getAppConditions",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<List<ConditionFinal>>> getAppConditions(
            @PathVariable("uid")Integer uid,
            @PathVariable("token") String token,
            @PathVariable("aid") Integer aid,
            HttpServletRequest request){
        try{
            alarmService  = (IAlarmService) Consumer.singleton().getBean("IAlarmService");
            if (request.getHeader("FromAgent").equals("android")) {
                return alarmService.getAllDataPointConditions(uid,token,aid,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return alarmService.getAllDataPointConditions(uid,token,aid,MOBILE_IPHONE);
            } else {
                return alarmService.getAllDataPointConditions(uid,token,aid,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<List<List<ConditionFinal>>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }

    @RequestMapping(value = "/{uid}/{token}/auth/{did}/dataPoint/getDataPointConditions",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<List<ConditionFinal>> getDataPointConditions(
            @PathVariable("uid")Integer uid,
            @PathVariable("token") String token,
            @PathVariable("did") Integer did,
            HttpServletRequest request){
        try{
            alarmService  = (IAlarmService) Consumer.singleton().getBean("IAlarmService");
            if (request.getHeader("FromAgent").equals("android")) {
                return alarmService.getDataPointConditions(uid,token,did,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return alarmService.getDataPointConditions(uid,token,did,MOBILE_IPHONE);
            } else {
                return alarmService.getDataPointConditions(uid,token,did,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<List<ConditionFinal>>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }


    @RequestMapping(value = "/{uid}/{token}/auth/{did}/dataPoint/{index}/{express}/{rightType}/{rightValue}/addDataPointCondition",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"}
    )
    @ResponseBody
    public Result<Condition> addDataPointCondition(
            @PathVariable("uid")Integer uid,
            @PathVariable("token") String token,
            @PathVariable("did") Integer did,
            @PathVariable("index") Integer index,
            @PathVariable("express") String expressStr,
            @PathVariable("rightType") Integer rightType,
            @PathVariable("rightValue") String rightValue,
            HttpServletRequest request){
        try{
            alarmService  = (IAlarmService) Consumer.singleton().getBean("IAlarmService");
            if (request.getHeader("FromAgent").equals("android")) {
                return alarmService.addCondition(uid,token,did,index,expressStr,rightType,rightValue,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return alarmService.addCondition(uid,token,did,index,expressStr,rightType,rightValue,MOBILE_IPHONE);
            } else {
                return alarmService.addCondition(uid,token,did,index,expressStr,rightType,rightValue,BROWSER);
            }
        }catch (IllegalStateException e) {
            return new Result<Condition>(false,CONSTANT.APP_SERVICE_OFFLINE);
        }
    }
}
