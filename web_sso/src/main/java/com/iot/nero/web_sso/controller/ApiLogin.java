package com.iot.nero.web_sso.controller;


import com.iot.nero.dto.Result;
import com.iot.nero.parent_balance.entity.Balance;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.utils.redis.JedisUtil;
import com.iot.nero.utils.verifycode.RedisimgVerify;
import com.iot.nero.utils.verifycode.Verify;
import com.iot.nero.utils.verifycode.exception.VerifyFailedException;
import com.iot.nero.web_sso.Consumer;
import com.iot.nero.service.IAuthService;
import com.iot.nero.utils.verifycode.entity.ImgVerify;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;


import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午10:18
 */

@Controller
@RequestMapping("/login")
public class ApiLogin {
    private static final String AGENT = "FromAgent";
    private static final String ANDROID = "android";
    private static final String IOS=         "ios";

    private IAuthService authService;


    /**
     * 获取验证码
     */
    @RequestMapping(value = "/{random}/create",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<ImgVerify> getVerifyV2(@PathVariable("random") String random){

        try {
            return new Result<ImgVerify>(true,new RedisimgVerify().getVerify());
        } catch (IOException e) {
            return new Result<ImgVerify>(false,e.getMessage());
        }
    }

    @RequestMapping(value = "/{jSessionId}/{code}/check",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Boolean> authCodeV2(@PathVariable("jSessionId") String jSessionId,
                                      @PathVariable("code") String code){

        try {
           return new Result<Boolean>(true,new RedisimgVerify().verify(jSessionId,code));
        } catch (VerifyFailedException e) {
            return new Result<Boolean>(false,e.getMessage());
        }
    }






    @RequestMapping(value = "/{name}/{pwd}/auth/{jSessionId}/{code}/login",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<DeveloperInfo> login(@PathVariable("name") String phoneOrEmail,
                                       @PathVariable("pwd") String pwd,
                                       @PathVariable("jSessionId") String jSessionId,
                                       @PathVariable("code") String code,
                                       HttpServletRequest request) {

        try {
            new RedisimgVerify().verify(jSessionId,code);
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (request.getHeader("FromAgent").equals("android")) {
                return authService.login(phoneOrEmail, pwd, MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return authService.login(phoneOrEmail, pwd, MOBILE_IPHONE);
            } else {
                return authService.login(phoneOrEmail, pwd, BROWSER);
            }
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        } catch (VerifyFailedException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.VERIFY_CODE_INCORRECT);
        }
    }


    @RequestMapping(value = "/{id}/{token}/auth",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<DeveloperInfo> auth(@PathVariable("id") Integer id,
                                      @PathVariable("token") String token,
                                      HttpServletRequest request) {

        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (request.getHeader("FromAgent").equals("android")) {
                return authService.auth(id, token, MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return authService.auth(id, token, MOBILE_IPHONE);
            } else {
                return authService.auth(id, token, BROWSER);
            }

        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }


    @RequestMapping(value = "/{id}/{token}/balance",
            method = RequestMethod.GET,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result<Balance> getBalance(@PathVariable("id") Integer id,
                                      @PathVariable("token") String token,
                                      HttpServletRequest request) {
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (request.getHeader("FromAgent").equals("android")) {
                return authService.getBalance(id, token,MOBILE_ANDROID);
            } else if (request.getHeader("FromAgent").equals("ios")) {
                return authService.getBalance(id, token,MOBILE_IPHONE);
            } else {
                return authService.getBalance(id, token,BROWSER);
            }
        } catch (IllegalStateException e) {
            return new Result<Balance>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }


}
