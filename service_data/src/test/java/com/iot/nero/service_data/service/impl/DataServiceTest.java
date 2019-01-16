package com.iot.nero.service_data.service.impl;

import com.iot.nero.dto.KeySecret;
import com.iot.nero.service.IDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/3/30
 * Time   下午7:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service_data/dubbo/*.xml")
public class DataServiceTest {

    @Autowired
    private IDataService dataService;

    @Test
    public void  getDataByMath() {
        KeySecret keySecret = new KeySecret(
                "tsu5AS_iXFLgs7o93jTMlQ==",
                "qoOXXOBIHLUmEH9Ns5OnqA=="
        );
        System.out.println(dataService.getDataByMath(keySecret,
                44,
                "KcU3Q8",
                17,
                1,
                "min",
                "2016-08-09 12:00:00",
                "2019-08-09 12:00:00"));
    }

    @Test
    public void typetest(){
        String type = "Integer";
        Object a = false;
        try {
            Class<?> aa = Class.forName("java.lang."+type);
            System.out.println(aa);
            if(a.getClass().equals(aa)){
                System.out.println("ok");
            }else{
                System.out.println("gg");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}