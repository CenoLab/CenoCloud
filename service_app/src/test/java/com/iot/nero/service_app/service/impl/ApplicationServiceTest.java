package com.iot.nero.service_app.service.impl;

import com.iot.nero.parent_app.entity.DataPointInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_ANDROID;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   下午12:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service_app/dubbo/*.xml")
public class ApplicationServiceTest {
    @Autowired
    private  ApplicationService applicationService;

    @Test
    public void createApplication() throws Exception {
        System.out.println(applicationService.createApplication(1,
                "gDyRmD0hRPpAnXT8nLHIxg==",
                "demo",
                "smart",
                "Wi-Fi",
                1,
                "NodeX",
                800000,
                "desc a ", MOBILE_ANDROID));
    }

    @Test
    public void getApplications() throws Exception {
        System.out.println(applicationService.getApplications(1,"bLYsUB5hDvYSrKX_lG5mnQ==", BROWSER));
    }

    @Test
    public void getApplication() throws Exception {
        System.out.println(applicationService.getApplication(1,17,"asdasd","baby..520587", BROWSER));
    }

    @Test
    public void getApplicationInfo() throws Exception {
        System.out.println(applicationService.getApplicationInfo(1,17,"asdasd", BROWSER));
    }

    @Test
    public void getDataPoints() throws Exception {
        System.out.println(applicationService.getDataPoints(1,17,"asdasd", MOBILE_IPHONE));
    }

    @Test
    public void addDataPoints() throws Exception {
        System.out.println(applicationService.addDataPoints(1,17,new DataPointInfo(
               17,
        "temp",
        "int",
        1
        ),"asdasd", BROWSER));
    }

    @Test
    public void getAppCurrentConn() throws Exception {
        System.out.println(applicationService.getAppCurrentConn(17,1,"asdasd",0,10, BROWSER));
    }


    @Test
    public void getApplications1() {
//        System.out.println(applicationService.getApplications());
    }
}