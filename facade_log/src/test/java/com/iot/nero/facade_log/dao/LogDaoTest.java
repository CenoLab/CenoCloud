package com.iot.nero.facade_log.dao;

import com.iot.nero.facade.ILogFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   下午1:24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_log/*/*.xml")
public class LogDaoTest {

    @Autowired
    private LogDao logDao;

    @Test
    public void insertClientLog() throws Exception {

    }

    @Test
    public void createClientLogTable() throws Exception {
        System.out.println(logDao.createClientLogTable("ZyQg4+dgiwDwGkG0GW2JCg=="));
    }

}