package com.iot.nero.facade_data;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"facade_data/dubbo/facade.xml","facade_data/spring/spring-dao.xml","facade_data/spring/spring-service.xml"});
        while (true) {
        }
    }
}

