package com.iot.nero.facade_forum;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("facade_forum/dubbo/facade.xml","facade_forum/spring/spring-dao.xml","facade_forum/spring/spring-service.xml");
        while (!Thread.interrupted()) {
        }
    }
}
