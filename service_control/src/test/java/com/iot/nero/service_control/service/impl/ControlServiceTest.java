package com.iot.nero.service_control.service.impl;


import com.google.gson.Gson;
import com.iot.nero.dto.KeySecret;
import com.iot.nero.parent_control.dto.ControlData;
import com.iot.nero.service.IControlService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2018/4/1
 * Time   下午11:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service_control/dubbo/*.xml")
public class ControlServiceTest {

    @Autowired
    private IControlService controlService;

    @Test
    public void control() {
        KeySecret keySecret = new KeySecret(
                "tsu5AS_iXFLgs7o93jTMlQ==",
                "qoOXXOBIHLUmEH9Ns5OnqA=="
        );
        Map<String,List<Object>> listMap = new HashMap<String,List<Object>>();
        List<Object> list  = new ArrayList<Object>();
        List<Object> listd  = new ArrayList<Object>();
        list.add(new Double(1.167));
        list.add(new Double(7.1656));
        listd.add(new Boolean(false));
        listd.add(new Boolean(false));
        listMap.put("double_test",list);
        listMap.put("light_test",listd);
        System.out.println(controlService.control(keySecret,
                44,
                "KcU3Q8",
                listMap
                ));
    }

    @Test
    public void tsts(){
        Map<String,List<Object>> listMap = new HashMap<String,List<Object>>();
        List<Object> list  = new ArrayList<Object>();
        list.add(new Double(1.167));
        list.add(new Double(7.1656));
        listMap.put("double_test",list);
        ControlData data = new ControlData(listMap);

        Gson gson = new Gson();
        System.out.println(gson.toJson(data));
    }

}