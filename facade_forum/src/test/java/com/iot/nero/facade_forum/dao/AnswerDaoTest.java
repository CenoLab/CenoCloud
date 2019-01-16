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
 * Time   上午10:20
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_forum/spring/*.xml")

public class AnswerDaoTest {

    @Autowired
    private AnswerDao answerDao;

    @Test
    public void listAnswerByQuestionId() throws Exception {
        System.out.println(answerDao.listAnswerByQuestionId(1,0,100));
    }

    @Test
    public void addAnswerForQuestion() throws Exception {
        System.out.println(answerDao.addAnswerForQuestion(
                1, 1,"吃了，老胜香"
        ));
    }

    @Test
    public void acceptAnswer() throws Exception {
        System.out.println(answerDao.acceptAnswer(1));
    }

}