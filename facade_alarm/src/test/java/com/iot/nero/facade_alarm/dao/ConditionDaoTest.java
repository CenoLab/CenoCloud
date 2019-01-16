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
 * Time   下午2:46
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_alarm/spring/*.xml")
public class ConditionDaoTest {

    @Autowired
    private ConditionDao conditionDao;

    @Test
    public void getConditionsByDataPointId() throws Exception {
        System.out.println(conditionDao.getConditionsByDataPointId(21));
    }

    @Test
    public void insertCondition() throws Exception {
            System.out.println(conditionDao.insertCondition(20, 2, 2, 1, String.valueOf(5)));
    }

}