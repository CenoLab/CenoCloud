package com.iot.nero.web_forum;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Author root
 * Email  nerosoft@outlook.com
 * Date   16-11-5
 * Time   下午2:17
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
