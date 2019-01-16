#DMS Java API
#导入Jar包
    org.eclipse.paho.client.mqttv3_1.0.2_dms.jar
    
#初始化
    String clientId = "JavaSample1";
    //默认地址是 "tcp://mqtt.dms.aodianyun.com:1883"
    DMS.init(clientId, new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {
            System.out.println("connectionLost");
        }
        @Override
        public void messageArrived(String topic, MqttMessage message)
                throws Exception {
            System.out.println("messageArrived: " + message);
        }
        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
            System.out.println("deliveryComplete");
        }
    });
#连接服务器
    String pub_key = "demo";
    String sub_key = "demo";
    IMqttToken token = null;
    token = DMS.connect(pub_key,sub_key, null, new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            System.out.println("connect-->onSuccess");
        }
        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            System.out.println("connect-->onFailure");
        }
    });
    //等待连接成功
    token.waitForCompletion();      
#关注话题
    String topic = "test";
    token = DMS.subscribe(topic, null,new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            System.out.println("subscribe-->onSuccess");
        }
        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            System.out.println("subscribe-->onFailure");
        }
    });
    //等待关注动作完成
    token.waitForCompletion();
#推送消息
    String topic = "test";
    String content = "Message from JavaClient1";
    token = DMS.publish(topic, content, null, new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            System.out.println("publish-->onSuccess");
        }
        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            System.out.println("publish-->onFailure");
        }
    });
    //等待推送消息完毕
    token.waitForCompletion();             
#取消关注
    String topic = "test";
    //也可以注册监听器
    token = DMS.unsubscribe(topic);
    //等待取消完成
    token.waitForCompletion();
#断开连接
    token = DMS.disconnect(null, new IMqttActionListener() {
        @Override
        public void onSuccess(IMqttToken asyncActionToken) {
            System.out.println("disconnect-->onSuccess");
        }
        @Override
        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
            System.out.println("disconnect-->onFailure");
        }
    });
    token.waitForCompletion();
#释放资源
    DMS.close();
    