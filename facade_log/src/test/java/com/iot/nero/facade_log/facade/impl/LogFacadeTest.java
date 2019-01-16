package com.iot.nero.facade_log.facade.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.rmi.runtime.Log;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/26
 * Time   下午1:39
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_log/*/*.xml")
public class LogFacadeTest {
    @Test
    public void sysLog() throws Exception {
        System.out.println(logFacade.SysLog(1l,"{type:001,content:\"api\"}"));
    }


    @Autowired private LogFacade logFacade;

    @Test
    public void clientLog() throws Exception {
        System.out.println(logFacade.clientLog("ZyQg4+dgiwDwGkG0GW2JCg==",3,2,""));
    }

    @Test
    public void getClientLog() throws Exception {
        System.out.println(logFacade.getClientLog("ZyQg4+dgiwDwGkG0GW2JCg==",3,0,0,10));
    }
}