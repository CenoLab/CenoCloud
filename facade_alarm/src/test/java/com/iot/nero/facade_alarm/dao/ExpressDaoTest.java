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
 * Time   下午1:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_alarm/spring/*.xml")
public class ExpressDaoTest {

    @Autowired
    private ExpressDao expressDao;

    @Test
    public void getExpressById() throws Exception {
        System.out.println(expressDao.getExpressById(1));
    }

    @Test
    public void getAllExpress() throws Exception {
        System.out.println(expressDao.getAllExpress());
    }

}