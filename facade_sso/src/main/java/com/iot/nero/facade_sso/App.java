package com.iot.nero.facade_sso;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("facade_sso/dubbo/facade.xml", "facade_sso/spring/spring-dao.xml", "facade_sso/spring/spring-service.xml");
        while (!Thread.interrupted()) {
        }
    }
}
