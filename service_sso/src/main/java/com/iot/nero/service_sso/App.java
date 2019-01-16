package com.iot.nero.service_sso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"service_sso/dubbo/service.xml"});
        while (true) {
        }
    }
}
