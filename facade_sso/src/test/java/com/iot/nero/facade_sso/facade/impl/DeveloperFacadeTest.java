package com.iot.nero.facade_sso.facade.impl;

import com.iot.nero.facade.IDeveloperFacade;
import com.iot.nero.parent_sso.exception.DeveloperAccountActiveException;
import com.iot.nero.parent_sso.exception.DeveloperNotExistsException;

import com.iot.nero.parent_sso.exception.VerifyCodeException;
import com.iot.nero.utils.md5.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/26
 * Time   下午6:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:facade_sso/spring/*.xml")

public class DeveloperFacadeTest {



    @Autowired
    private IDeveloperFacade developerFacade;


    @Test
    public void isDeveloperExists() throws Exception {
        try {
            System.out.println(developerFacade.isLoginDeveloperExists("ss"));
        }catch (DeveloperNotExistsException e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void isPwdCorrect() throws Exception {
        try {
            System.out.println(developerFacade.isPwdCorrect("ss", "pwd"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void addDeveloper() throws Exception {
        String email = "23849875@qq.com";
        String password = "abcd1234";
        System.out.println(MD5.EncoderByMd5(email+MD5.EncoderByMd5(password)));
    }

    @Test
    public void sendActiveEmail() {
        System.out.println(developerFacade.sendActiveEmail("Nero Yang","nerosoft@outlook.com","YH68G"));
    }

    @Test
    public void activeDeveloperByEmailCode() {
        try {
            System.out.println(developerFacade.activeDeveloperByEmailCode("nerosoft@outlook.com","2ldyii"));
        } catch (VerifyCodeException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (DeveloperAccountActiveException e) {
            e.printStackTrace();
        }
    }
}