package com.iot.nero.facade_alarm.facade.impl;

import com.iot.nero.facade.IAlarmFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/26
 * Time   下午6:56
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_alarm/spring/*.xml")
public class AlarmFacadeTest {





    @Autowired
    private IAlarmFacade alarmFacade;

    @Test
    public void addConditionForDataPoint() throws Exception {
        System.out.println(alarmFacade.addConditionForDataPoint(21,1,alarmFacade.getExpressByStr("=").getId(),1,"3"));
    }

    @Test
    public void getDataPointAlarmLogs() throws Exception {
        System.out.println(alarmFacade.getDataPointAlarmLogs(1,1,0,10));
    }

    @Test
    public void getDataPointAlarmConditions() throws Exception {
        System.out.println(alarmFacade.getDataPointAlarmConditions(21));
    }

    @Test
    public void getAlarmLogByDataPointId() throws Exception {
    }

    @Test
    public void getAlarmLogByDataPointIdAndTimeStamp() throws Exception {

    }

    @Test
    public void addDataPointAlarmLog() throws Exception {

    }

    @Test
    public void getExpressByStr() {

    }

}