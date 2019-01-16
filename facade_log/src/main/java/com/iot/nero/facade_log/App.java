package com.iot.nero.facade_log;

import com.iot.nero.facade_log.facade.impl.LogFacade;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"facade_log/dubbo/facade.xml","facade_log/spring/spring-dao.xml","facade_log/spring/spring-service.xml"});

        LogFacade logFacade  = (LogFacade)context.getBean("ILogFacade");
        LogConsumer logConsumer  = new LogConsumer(logFacade);
        logConsumer.listen();
        while (true) {
        }
    }
}
