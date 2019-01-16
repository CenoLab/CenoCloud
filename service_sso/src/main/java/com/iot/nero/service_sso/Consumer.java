package com.iot.nero.service_sso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by root on 16-11-5.
 */
public class Consumer {

    public static ClassPathXmlApplicationContext context = null;
    public static ClassPathXmlApplicationContext singleton() {
        if (context == null) {
            context = new ClassPathXmlApplicationContext(new String[] {"service_sso/dubbo/service.xml"});
            context.start();
        }
        return context;
    }
}