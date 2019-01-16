package com.iot.nero.service_app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"service_app/dubbo/service.xml"});
        while (true) {
        }
    }
}
