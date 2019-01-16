package com.iot.nero.web_data;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by root on 16-11-5.
 */
public class Main extends HttpServlet{

    public void init() throws ServletException {
        try {
            System.out.println("初始化dubbo客户端");
            Consumer.singleton();
        } catch (Exception e) {
            System.out.println("初始化dubbo客户端失败");
        }
    }


}
