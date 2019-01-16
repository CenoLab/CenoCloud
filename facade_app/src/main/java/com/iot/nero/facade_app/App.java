package com.iot.nero.facade_app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"facade_app/dubbo/facade.xml","facade_app/spring/spring-dao.xml","facade_app/spring/spring-service.xml"});
        while (true) {
        }
    }
}
