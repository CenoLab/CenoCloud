package com.iot.nero.facade_app.facade.impl;

import com.iot.nero.dto.KeySecret;
import com.iot.nero.facade.IApplicationFacade;
import com.iot.nero.parent_app.dto.ApplicationInfo;
import com.iot.nero.parent_app.entity.DataPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/28
 * Time   下午4:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_app/spring/*.xml")
public class ApplicationFacadeTest {



    @Autowired
    private IApplicationFacade applicationFacade;

    @Test
    public void createApplication() throws Exception {
        System.out.println(applicationFacade.createApplication(new ApplicationInfo(2,
                "demo",
                "smart light",
                "Wi-Fi",
                1,
                "NodeX",
                8000,
                "this is desc ")));
    }

    @Test
    public void getDataPoint() throws Exception {
        List<DataPoint> dataPointList = applicationFacade.getDataPoint(51);
        for(DataPoint point:dataPointList){
            System.out.println(point.getId());
        }
    }

    @Test
    public void auth() throws Exception {
        System.out.println(applicationFacade.auth(17, new KeySecret("ZyQg4+dgiwDwGkG0GW2JCg==",
                "T39ifrtfusXaAXTNEEYkzQ==")));
    }

}