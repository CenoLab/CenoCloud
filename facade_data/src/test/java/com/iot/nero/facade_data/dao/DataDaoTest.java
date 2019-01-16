package com.iot.nero.facade_data.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   下午1:46
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_data/spring/*.xml")
public class DataDaoTest {



    @Autowired
    private DataDao dataDao;

    @Test
    public void createTable() throws Exception {
        System.out.println(dataDao.createTable("ssss"));
    }

    @Test
    public void saveMessage() throws Exception {
        String table = "data_p_17";
        try {
            System.out.println(dataDao.saveMessage(table, 17, "asdasd", "asdas", "asd", "adsa"));
        }catch (BadSqlGrammarException e){
            System.out.println(dataDao.createTable(table));
            System.out.println(dataDao.saveMessage(table, 17, "asdasd", "asdas", "asd", "adsa"));
        }
    }

    @Test
    public void getMessageByPage() throws Exception {
        String table = "data_p_17";
        System.out.println(dataDao.getMessageByPage(table,17,0,10));
    }


    @Test
    public void getSendMessageByPage() throws Exception {
        String table = "data_p_17";
        System.out.println(dataDao.getSendMessageByPage(table,17,"Hiw9Bo",0,10));
    }

    @Test
    public void getReceivedMessageByPage() throws Exception {
        String table = "data_p_17";
        System.out.println(dataDao.getReceivedMessageByPage(table,17,"asdas",0,10));
    }

}