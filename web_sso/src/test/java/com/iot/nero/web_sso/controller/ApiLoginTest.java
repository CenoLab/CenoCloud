package com.iot.nero.web_sso.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/6/27
 * Time   下午5:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:*/*.xml")
public class ApiLoginTest {

    ApiLogin apiLogin = new ApiLogin();

    @Test
    public void login() throws Exception {
        //System.out.println(apiLogin.login("nerosoft@outlook.com","sd","code"));
    }

}