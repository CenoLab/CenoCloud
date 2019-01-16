package com.iot.nero.service_sso.service.impl;


import com.iot.nero.dto.Result;
import com.iot.nero.parent_sso.dto.DeveloperInfo;
import com.iot.nero.service.IAuthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;
import static com.iot.nero.constant.UserTokenType.ANDROID_TOKEN;
import static com.iot.nero.constant.UserTokenType.BROWSER_TOKEN;
import static com.iot.nero.constant.UserTokenType.IPHONE_TOKEN;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/27
 * Time   下午5:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service_sso/dubbo/*.xml")
public class AuthServiceTest {


    @Autowired
    private IAuthService iAuthService;

    @Test
    public void login() throws Exception {
        System.out.println(iAuthService.login("nerosoft@outlook.com","10086", MOBILE_IPHONE));
    }
    @Test
    public void auth() throws Exception {
        Result<DeveloperInfo> as = iAuthService.login("nerosoft@outlook.com","10086", MOBILE_IPHONE);
        System.out.println(as);

        Result<DeveloperInfo> at = iAuthService.auth(1,as.getData().getToken(), MOBILE_IPHONE);
        System.out.println(at);
    }

    @Test
    public void registerByEmail() {
        System.out.println(iAuthService.registerByEmail("neroyang","nerosoft@outlook.com","baby..520587"));
    }
}