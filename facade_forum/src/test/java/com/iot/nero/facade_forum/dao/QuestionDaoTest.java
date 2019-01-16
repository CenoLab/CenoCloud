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
 * Time   上午10:02
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_forum/spring/*.xml")

public class QuestionDaoTest {

    @Autowired
    private QuestionDao questionDao;

    @Test
    public void findQuestionByID() throws Exception {
        System.out.println(questionDao.findQuestionByID(1));
    }

    @Test
    public void listQuestionByAuthorID() throws Exception {
        System.out.println(questionDao.listQuestionByAuthorID(1,0,100));
    }

    @Test
    public void addQuestion() throws Exception {
        System.out.println(questionDao.addQuestion(
                1,
                "问个啥呢？",
                "你吃饭了么?",
                "瞎扯;吹水;",
                1
        ));
    }

    @Test
    public void updateQuestionById() throws Exception {
        System.out.println(questionDao.updateQuestionById(1,
                "问个问题哈？",
                "你次饭了么？吃了啥？",
                "瞎扯;吹水;",
                1));
    }

    @Test
    public void acceptQuestionById() throws Exception {
        //System.out.println(questionDao.acceptQuestionById(1));
    }

}