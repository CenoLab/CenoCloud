package com.iot.nero.facade_sso.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_sso/spring/*.xml")
public class VerifyDaoTest {

    @Autowired
    private VerifyDao verifyDao;

    @Test
    public void getVerifyCodeByDeveloperIdAndEmail() {
        System.out.println(verifyDao.getVerifyCodeByDeveloperIdAndEmail(1,"nerosoft@outlook.com"));
    }

    @Test
    public void updateEmailCodeByDeveloperIdAndEmail() {
        System.out.println(verifyDao.updateEmailCodeByDeveloperIdAndEmail(1,"nerosoft@outlook.com","10086"));
    }

    @Test
    public void insertIntoEmailVerifyCode() {

        System.out.println(verifyDao.insertIntoEmailVerifyCode(1,"nerosoft@outlook.com","LOOKJH"));
    }
}