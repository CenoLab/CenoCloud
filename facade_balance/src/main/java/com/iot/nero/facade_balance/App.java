package com.iot.nero.facade_balance;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        new ClassPathXmlApplicationContext(new String[]{"facade_balance/dubbo/facade.xml","facade_balance/spring/spring-dao.xml","facade_balance/spring/spring-service.xml"});
        while (true) {
        }
    }
}
