package com.iot.nero.facade_forum.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/5/21
 * Time   上午8:43
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_forum/spring/*.xml")

public class AuthorDaoTest {


    @Autowired
    private AuthorDao authorDao;

    @Test
    public void findAuthorById() throws Exception {
        System.out.println(authorDao.findAuthorById(1));
    }

    @Test
    public void findAuthorByCloudId() throws Exception {
        System.out.println(authorDao.findAuthorByCloudId(1));
    }

    @Test
    public void descAuthorByArticleCount() throws Exception {
        System.out.println(authorDao.descAuthorByArticleCount(0,100));
    }

    @Test
    public void initAuthor() throws Exception {
        System.out.println(authorDao.initAuthor("买代码的小火柴",1));
    }

    @Test
    public void findAuthorByName() throws Exception {
        System.out.println(authorDao.findAuthorByName("卖代码的小火柴"));
    }

}