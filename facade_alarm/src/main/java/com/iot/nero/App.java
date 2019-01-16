package com.iot.nero;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{
                "facade_alarm/dubbo/facade.xml",
                "facade_alarm/spring/spring-dao.xml",
                "facade_alarm/spring/spring-service.xml"});
        while (true) {
        }
    }
}
