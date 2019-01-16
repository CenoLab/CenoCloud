package com.iot.nero.web_sso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 16-11-5.
 */
public class Consumer {

    public static ClassPathXmlApplicationContext context = null;
    public static ClassPathXmlApplicationContext singleton() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(new String[] {"web_sso/dubbo/sso.xml","web_sso/spring/spring-web.xml"});
            context.start();
        }
        return context;
    }
}
