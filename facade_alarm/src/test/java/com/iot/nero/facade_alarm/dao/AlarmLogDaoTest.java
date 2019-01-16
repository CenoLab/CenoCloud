package com.iot.nero.facade_alarm.dao;

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
 * Time   下午6:33
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_alarm/spring/*.xml")

public class AlarmLogDaoTest {

    @Autowired
    private AlarmLogDao alarmLogDao;

    @Test
    public void insertAlarmLog() throws Exception {
            for(int i = 0;i<10;i++){
                System.out.println(alarmLogDao.insertAlarmLog(
                        1,
                        1,
                        i,
                        1));
            }
    }

    @Test
    public void getAlarmLogByDataPointId() throws Exception {
//       / System.out.println(alarmLogDao.getAlarmLogByDataPointId());
    }

    @Test
    public void getAlarmLogByDataPointIdAndTimeStamp() throws Exception {

    }

}