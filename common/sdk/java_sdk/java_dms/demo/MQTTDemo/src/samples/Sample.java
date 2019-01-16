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

	/* ���첽DMS������ */
	public static void main(String[] args) throws IOException {
		/* ���̺߳ͻص������̲߳���ͬһ���߳� */
		try {
			System.out.println(Thread.currentThread().getName() + "-->main");
			//��ʼ��DMS����
			DMS.init(broker, clientId, new Sample());
			//��ʼ����
			IMqttToken token = null;
			token = DMS.connect(pub_key,sub_key, null, new MyConnectListener());
			token.waitForCompletion();
			//��ע����
			token = DMS.subscribe(topic, "subscribe",new MySubscribeListener());
			token.waitForCompletion();
			//������Ϣ
			token = DMS.publish(topic, content,"publish", new MyPublishListener());
			token.waitForCompletion();
			//��ȡ������Ͽ�����
			System.in.read();
			//ȡ����ע
			token = DMS.unsubscribe(topic);
			token.waitForCompletion();
			//�Ͽ�����
			token = DMS.disconnect("disconnect", new MyDisconnectListener());
			token.waitForCompletion();
			//�ر��ͷ���Դ
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
