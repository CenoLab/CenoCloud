package com.iot.nero.service_app.service.impl;

import com.iot.nero.service.IClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.iot.nero.constant.ClientType.BROWSER;
import static com.iot.nero.constant.ClientType.MOBILE_IPHONE;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/11
 * Time   下午2:16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service_app/dubbo/*.xml")
public class ClientServiceTest {


    @Autowired
    private IClientService clientService;



    @Test
    public void clientAuth() throws Exception {
        System.out.println(clientService.clientAuth("android_test","QS_mRUniMohUJVAUqB1VUw==","_Qq_AWhEGaTKu_8Bqi6hPQ=="));
    }
    @Test
    public void clientOffLine() throws Exception {
        System.out.println(clientService.clientOffLine("ZyQg4+dgiwDwGkG0GW2JCg==","virtual"));
    }

    @Test
    public void sendMessage() throws Exception {
            System.out.println(clientService.sendMessage(
                    "tsu5AS_iXFLgs7o93jTMlQ==",
                    "CenoBoxClientPub",
                    "test",
                    "1",
                    "{\n" +
                    "  \"d\":{\n" +
                    "    \"Temperature\":[23.0,28.1,23.67],\n" +
                    "    \"SO2\":[11,23,14,35],\n" +
                    "    \"light\":[false,true,false,false,false]\n" +
                    "  },\n" +
                    "  \"ts\":\"2017-07-08 09:04:05\"\n" +
                    "}"));
    }


    @Test
    public void getClientSendMessageCount() throws Exception {
        System.out.println(clientService.getClientSendMessageCount(1,"asdasd",17,"Hiw9Bo", MOBILE_IPHONE));
    }

    @Test
    public void getClientSendMessage() throws Exception {
        System.out.println(clientService.getClientSendMessage(1,"asdasd",17,"Hiw9Bo",0,10, BROWSER));
    }

    @Test
    public void getClientReceivedMessage() throws Exception {

        Object a = false;
        System.out.println(a.getClass());

        //System.out.println(clientService.getClientReceivedMessage(1,"asdasd",17,"virtual",0,10, MOBILE_IPHONE));
    }


}