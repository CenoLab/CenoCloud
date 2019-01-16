package com.iot.nero.web_control.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.dto.Result;
import com.iot.nero.parent_control.dto.ControlData;
import com.iot.nero.parent_control.dto.ControlResult;
import com.iot.nero.parent_data.constant.CONSTANT;
import com.iot.nero.parent_data.dto.DataResult;
import com.iot.nero.service.IControlService;
import com.iot.nero.service.IDataService;
import com.iot.nero.web_control.Consumer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import static com.iot.nero.constant.CONSTANT.HEADER_NOT_FOUND_EXCEPTION;
import static com.iot.nero.constant.CONSTANT.PARAMS_NOT_FOUND_EXCEPTION;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午7:18
 */
@Controller
@RequestMapping("/api/v1/")
public class ApiControl {

    private IControlService controlService;

    @RequestMapping(value = "{appId}/{clientId}/control",
            method = RequestMethod.POST)
    @ResponseBody
    public Result<ControlResult> control(
            @PathVariable("appId") Integer appId,
            @PathVariable("clientId") String clientId,
            HttpServletRequest request) {

        try {
            controlService = (IControlService) Consumer.singleton().getBean("IControlService");
            if (request.getHeader("FromAgent").equals("third")) {
                String appKey = request.getHeader("appKey");
                String appSecret = request.getHeader("appSecret");

                KeySecret keySecret = new KeySecret(appKey, appSecret);
                String data = request.getParameter("data");
                Gson gson = new Gson();
                ControlData controlData = gson.fromJson(data, ControlData.class);
                if(controlData==null){
                    return new Result<ControlResult>(false, PARAMS_NOT_FOUND_EXCEPTION);
                }
                return controlService.control(keySecret,appId,clientId,controlData.getData());
            }else{
                return new Result<ControlResult>(false, HEADER_NOT_FOUND_EXCEPTION);
            }
        } catch (IllegalStateException e) {
            return new Result<ControlResult>(false, CONSTANT.DATA_SERVICE_EXCEPTION);
        }catch (JsonSyntaxException e){
            return new Result<ControlResult>(false, e.getMessage());
        }
    }
}
