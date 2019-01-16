package com.iot.nero;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * neroyang
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext("service_forum/dubbo/service.xml");
        while (!Thread.interrupted()) {
        }
    }
}
