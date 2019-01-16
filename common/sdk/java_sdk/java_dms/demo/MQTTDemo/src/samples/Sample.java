package samples;

import java.io.IOException;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import com.aodianyun.dms.DMS;

public class Sample implements MqttCallback {

	private static final String topic = "test";
	private static final String content = "Message from JavaClient1";
	private static final String broker = "tcp://mqtt.dms.aodianyun.com:1883";
	private static final String clientId = "JavaSample1";
	private static final String pub_key = "demo";
	private static final String sub_key = "demo";

	/* 简单异步DMS的例子 */
	public static void main(String[] args) throws IOException {
		/* 主线程和回调函数线程不是同一个线程 */
		try {
			System.out.println(Thread.currentThread().getName() + "-->main");
			//初始化DMS对象
			DMS.init(broker, clientId, new Sample());
			//开始连接
			IMqttToken token = null;
			token = DMS.connect(pub_key,sub_key, null, new MyConnectListener());
			token.waitForCompletion();
			//关注话题
			token = DMS.subscribe(topic, "subscribe",new MySubscribeListener());
			token.waitForCompletion();
			//发布消息
			token = DMS.publish(topic, content,"publish", new MyPublishListener());
			token.waitForCompletion();
			//读取任意键断开连接
			System.in.read();
			//取消关注
			token = DMS.unsubscribe(topic);
			token.waitForCompletion();
			//断开连接
			token = DMS.disconnect("disconnect", new MyDisconnectListener());
			token.waitForCompletion();
			//关闭释放资源
			DMS.close();
		} catch (MqttException me) {
			me.printStackTrace();
		}
	}

	@Override
	public void connectionLost(Throwable cause) {
		System.out.println(Thread.currentThread().getName() + "-->connectionLost");
	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		System.out.println(Thread.currentThread().getName() + "-->messageArrived: " + message);
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
		System.out.println(Thread.currentThread().getName() + "-->deliveryComplete");
	}

	static class MyConnectListener implements IMqttActionListener {
		@Override
		public void onSuccess(IMqttToken asyncActionToken) {
			System.out.println(Thread.currentThread().getName() + "-->MyConnectListener.onSuccess");
		}
		@Override
		public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
			System.out.println(Thread.currentThread().getName() + "-->MyConnectListener.onFailure");
		}
	}

	static class MySubscribeListener implements IMqttActionListener {
		@Override
		public void onSuccess(IMqttToken asyncActionToken) {
			System.out.println(Thread.currentThread().getName() + "-->MySubscribeListener.onSuccess");
		}
		@Override
		public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
			System.out.println(Thread.currentThread().getName() + "-->MySubscribeListener.onFailure");
		}
	}

	static class MyPublishListener implements IMqttActionListener {
		@Override
		public void onSuccess(IMqttToken asyncActionToken) {
			System.out.println(Thread.currentThread().getName() + "-->MyPublishListener.onSuccess");
		}
		@Override
		public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
			System.out.println(Thread.currentThread().getName() + "-->MyPublishListener.onFailure");
		}
	}

	static class MyDisconnectListener implements IMqttActionListener {
		@Override
		public void onSuccess(IMqttToken asyncActionToken) {
			System.out.println(Thread.currentThread().getName() + "-->MyDisconnectListener.onSuccess");
		}
		@Override
		public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
			System.out.println(Thread.currentThread().getName() + "-->MyDisconnectListener.onFailure");
		}
	}
}
