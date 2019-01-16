package com.iot.nero.web_forum;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author root
 * Email  nerosoft@outlook.com
 * Date   16-11-5
 * Time   下午2:17
 */
public class Consumer {

    public static ClassPathXmlApplicationContext context = null;
    public static ClassPathXmlApplicationContext singleton() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext("web_forum/dubbo/forum.xml",
                    "web_forum/spring/spring-web.xml");
            context.start();
        }
        return context;
    }
}
