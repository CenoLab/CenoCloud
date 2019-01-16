package com.iot.nero.facade_data.facade.impl;

import com.iot.nero.facade.IDataFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   下午2:09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_data/spring/*.xml")
public class DataFacadeTest {


    @Autowired
    private IDataFacade dataFacade;

    @Test
    public void getDataByTime() throws Exception {
        System.out.println(dataFacade.getDataByTime(17,"2016-08-31 12:00:00","2017-08-31 12:00:00"));
    }

    @Test
    public void getClientDataByTime() throws Exception {
        System.out.println(dataFacade.getClientDataByTime(17,"KcU3Q8","2016-08-31 12:00:00","2019-08-31 12:00:00"));
    }
    @Test
    public void saveMessage() throws Exception {
        System.out.println(dataFacade.saveMessage(17,"aaa","bbb","1","adasdads"));
    }

    @Test
    public void  test() throws Exception{
        System.out.println(dataFacade.getClientDataByCurrent(17,"KcU3Q8"));
    }
    @Test
    public void  test1() throws Exception{
        System.out.println(dataFacade.getClientDataByTimePage(17,"KcU3Q8","2016-08-31 12:00:00","2019-08-31 12:00:00",0,2));
    }

}