package com.iot.nero.utils.mq;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by neroyang on 2018/3/19.
 */

public class MqttService {


    private static MqttClient connect(Integer qos,String broker,String clientId, String userName,
                                      String password) throws MqttException {
        MemoryPersistence persistence = new MemoryPersistence();
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(userName);
        connOpts.setPassword(password.toCharArray());
        connOpts.setConnectionTimeout(10);
        connOpts.setKeepAliveInterval(20);
        //String[] uris = {"tcp://10.100.124.206:1883"};
        //connOpts.setServerURIs(uris);  //起到负载均衡和高可用的作用
        MqttClient mqttClient = new MqttClient(broker, clientId, persistence);
        mqttClient.connect(connOpts);
        return mqttClient;
    }

    private static void pub(Integer qos,MqttClient sampleClient, String msg,String topic)
            throws MqttPersistenceException, MqttException {
        MqttMessage message = new MqttMessage(msg.getBytes());
        message.setQos(qos);
        message.setRetained(false);
        sampleClient.publish(topic, message);
    }

    public static void publish(String userName,String passWord,Integer qos,String broker,String clientId,String topic,String str) throws MqttException{
        MqttClient mqttClient = connect(qos,broker,clientId,userName,passWord);

        if (mqttClient != null) {
            pub(qos,mqttClient, str, topic);
        }

        if (mqttClient != null) {
            mqttClient.disconnect();
        }
    }
}
