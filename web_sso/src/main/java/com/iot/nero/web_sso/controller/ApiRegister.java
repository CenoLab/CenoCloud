package com.iot.nero.web_sso.controller;

import com.iot.nero.dto.Result;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.Developer;
import com.iot.nero.service.IAuthService;
import com.iot.nero.utils.verifycode.RedisimgVerify;
import com.iot.nero.utils.verifycode.Verify;
import com.iot.nero.utils.verifycode.exception.VerifyFailedException;
import com.iot.nero.web_sso.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午12:21
 */
@Controller
@RequestMapping("/register")
public class ApiRegister {

    private static final String AGENT = "FromAgent";
    private static final String ANDROID = "android";
    private static final String IOS=         "ios";

    private IAuthService authService;

    @RequestMapping(value = "/{name}/{email}/{password}/{jSessionId}/{code}/registerByEmail",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> registerByEmail(@PathVariable("name") String name,
                                            @PathVariable("email") String email,
                                          @PathVariable("password") String password,
                                                 @PathVariable("jSessionId")String jSessionId,
                                          @PathVariable("code") String code,
                                          HttpServletRequest request){

        try {
            new RedisimgVerify().verify(jSessionId,code);
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            return authService.registerByEmail(name,email, password);
        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }catch (VerifyFailedException e){
            return new Result<DeveloperInfo>(false, CONSTANT.VERIFY_CODE_INCORRECT);
        }
    }
    @RequestMapping(value = "/{name}/{phone}/{password}/{code}/registerByPhone",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> registerByPhone(@PathVariable("name") String name,
                                                 @PathVariable("phone") String phone,
                                                 @PathVariable("password") String password,
                                                 @PathVariable("code") String code,
                                                 HttpServletRequest request,
                                                 HttpServletResponse response){

        response.setHeader("Pragma","No-cache");
        response.setHeader("Cache-Control","no-cache");
        response.setDateHeader("Expires", 0);

        Verify verify = new Verify(request);

        try {
            verify.checkVerify(code);
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            return authService.registerByPhone(name,phone, password);
        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }catch (VerifyFailedException e){
            return new Result<DeveloperInfo>(false, CONSTANT.VERIFY_CODE_INCORRECT);
        }
    }


    @RequestMapping(value = "/{email}/{code}/activeByEmailCode",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> activeByEmailCode(
                                            @PathVariable("email") String email,
                                            @PathVariable("code") String code){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            return authService.activeByEmailCode(email, code);
        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }

    @RequestMapping(value = "/{phone}/{code}/activeByPhoneCode",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> activeByPhoneCode(@PathVariable("phone") String phone,
                                                   @PathVariable("code") String code){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            return authService.activeByPhoneCode(phone, code);
        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }

}
