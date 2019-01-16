package com.iot.nero.web_sso.controller;

import com.iot.nero.dto.Result;
import com.iot.nero.parent_sso.constant.CONSTANT;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.parent_sso.entity.DeveloperAdds;
import com.iot.nero.service.IAuthService;
import com.iot.nero.web_sso.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/24
 * Time   下午3:38
 */
@Controller
@RequestMapping("/developer")
public class ApiDeveloper {


    private static final String AGENT = "FromAgent";
    private static final String ANDROID = "android";
    private static final String IOS=         "ios";

    private IAuthService authService;

    /**
     * 获取用户附加信息
     * @param id
     * @param token
     * @return
     */
    @RequestMapping(value = "/{id}/{token}/auth/adds/get",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperAdds> getDeveloperAdds(@PathVariable("id") Integer id,
                                                  @PathVariable("token") String token,
                                                  HttpServletRequest request){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");

            if (request.getHeader(AGENT).equals(ANDROID)) {
                return authService.getDeveloperAdds(id, token,MOBILE_ANDROID);
            } else if (request.getHeader(AGENT).equals(IOS)) {
                return authService.getDeveloperAdds(id, token,MOBILE_IPHONE);
            } else {
                return authService.getDeveloperAdds(id, token,BROWSER);
            }

        }catch(IllegalStateException e){
            return new Result<DeveloperAdds>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }


    /**
     * 添加附加开发者信息
     * @param id
     * @param token
     * @param DProfession
     * @param DBussiness
     * @param DWebsite
     * @param DCountry
     * @param DAddress
     * @param DStreet
     * @param DTel
     * @param DFax
     * @return
     */
    @RequestMapping(value = "/{id}/{token}/auth/{DProfession}/{DBussiness}/{DWebsite}/{DCountry}/{DAddress}/{DStreet}/{DTel}/{DFax}/adds/set",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperAdds> setDeveloperAdds(@PathVariable("id") Integer id,
                                                  @PathVariable("token") String token,
                                                  @PathVariable("DProfession") String DProfession,
                                                  @PathVariable("DBussiness") String DBussiness,
                                                  @PathVariable("DWebsite") String DWebsite,
                                                  @PathVariable("DCountry") String DCountry,
                                                  @PathVariable("DAddress") String DAddress,
                                                  @PathVariable("DStreet") String DStreet,
                                                  @PathVariable("DTel") String DTel,
                                                  @PathVariable("DFax") String DFax,
                                                  HttpServletRequest request){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");

            if (request.getHeader(AGENT).equals(ANDROID)) {
                return authService.setDeveloperAdds(id, token,DProfession, DBussiness, DWebsite, DCountry, DAddress, DStreet, DTel, DFax,MOBILE_ANDROID);
            } else if (request.getHeader(AGENT).equals(IOS)) {
                return authService.setDeveloperAdds(id, token,DProfession, DBussiness, DWebsite, DCountry, DAddress, DStreet, DTel, DFax,MOBILE_IPHONE);
            } else {
                return authService.setDeveloperAdds(id, token,DProfession, DBussiness, DWebsite, DCountry, DAddress, DStreet, DTel, DFax,BROWSER);
            }
        }catch(IllegalStateException e){
            return new Result<DeveloperAdds>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }

    /**
     * 修改资料
     * @param id
     * @param token
     * @param name
     * @param company
     * @return
     */
    @RequestMapping(value = "/{id}/{token}/auth/{name}/{company}/change",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> changeName(@PathVariable("id") Integer id,
                                            @PathVariable("token") String token,
                                            @PathVariable("name") String name,
                                            @PathVariable("company") String company,
                                            HttpServletRequest request){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (request.getHeader(AGENT).equals(ANDROID)) {
                return authService.changeName(id, token,  name, company,MOBILE_ANDROID);
            } else if (request.getHeader(AGENT).equals(IOS)) {
                return authService.changeName(id, token,  name, company,MOBILE_IPHONE);
            } else {
                return authService.changeName(id, token,  name, company,BROWSER);
            }

        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }


    /**
     * 修改头像
     * @param id
     * @param token
     * @param filename
     * @param avatar
     * @return
     */
    @RequestMapping(value = "/{id}/{token}/auth/{filename}/avatar",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> changeAvatar(@PathVariable("id") Integer id,
                                              @PathVariable("token") String token,
                                              @PathVariable("filename") String filename,
                                              @RequestParam("avatar") MultipartFile avatar,
                                              HttpServletRequest request){
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");

            if (request.getHeader(AGENT).equals(ANDROID)) {
                return authService.changeAvatar(id, token,  filename, avatar,MOBILE_ANDROID);
            } else if (request.getHeader(AGENT).equals(IOS)) {
                return authService.changeAvatar(id, token,  filename, avatar,MOBILE_IPHONE);
            } else {
                return authService.changeAvatar(id, token,  filename, avatar,BROWSER);
            }
        }catch(IllegalStateException e){
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }


    /**
     * 修改密码
     * @param id
     * @param token
     * @param oldPwd
     * @param newPwd
     * @return
     */
    @RequestMapping(value = "/{id}/{token}/auth/{oldpwd}/{newpwd}/changepwd",
            method = RequestMethod.GET)
    @ResponseBody
    public Result<DeveloperInfo> changePwd(@PathVariable("id") Integer id,
                                           @PathVariable("token") String token,
                                           @PathVariable("oldpwd")String oldPwd,
                                           @PathVariable("newPwd") String newPwd,
                                           HttpServletRequest request) {
        try {
            authService = (IAuthService) Consumer.singleton().getBean("IAuthService");
            if (request.getHeader(AGENT).equals(ANDROID)) {
                return authService.changePwd(id, token, oldPwd, newPwd,MOBILE_ANDROID);
            } else if (request.getHeader(AGENT).equals(IOS)) {
                return authService.changePwd(id, token, oldPwd, newPwd,MOBILE_IPHONE);
            } else {
                return authService.changePwd(id, token, oldPwd, newPwd,BROWSER);
            }
        } catch (IllegalStateException e) {
            return new Result<DeveloperInfo>(false, CONSTANT.SSO_SERVICE_EXCEPTION);
        }
    }
}
