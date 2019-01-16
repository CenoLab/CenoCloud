package com.iot.nero.facade_app.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/29
 * Time   上午10:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_app/spring/*.xml")
public class DataPointDaoTest {

    @Autowired
    private DataPointDao dataPointDao;


    @Test
    public void getDataPoint() throws Exception {
        System.out.println(dataPointDao.getDataPoint(13));
    }

    @Test
    public void addDataPoint() throws Exception {
        System.out.println(dataPointDao.addDataPoint(13,"light","Float",0));
    }

    @Test
    public void delDataPoint() throws Exception {

    }

}