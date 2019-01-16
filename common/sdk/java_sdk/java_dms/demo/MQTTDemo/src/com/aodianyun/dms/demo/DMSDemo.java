/*
 * DMSDemo.java
 *
 * Created on __DATE__, __TIME__
 */

package com.aodianyun.dms.demo;

import java.util.UUID;
import javax.swing.SwingUtilities;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import com.aodianyun.dms.DMS;

/**
 *
 * @author  __USER__
 */
public class DMSDemo extends javax.swing.JFrame implements MqttCallback {
	private static final long serialVersionUID = 1L;

	/** Creates new form DMSDemo */
	public DMSDemo() {
		initComponents();
		initDMS();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		pnlSettings = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		txtAddress = new javax.swing.JTextField();
		jLabel2 = new javax.swing.JLabel();
		txtPubKey = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtSubKey = new javax.swing.JTextField();
		txtClientId = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		btnConnect = new javax.swing.JButton();
		btnDisconnect = new javax.swing.JButton();
		pnlMessage = new javax.swing.JPanel();
		btnClear = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jScrollPane2 = new javax.swing.JScrollPane();
		txtMessage = new javax.swing.JTextArea();
		cbSubTopic = new javax.swing.JComboBox();
		btnSend = new javax.swing.JButton();
		cbSendTopic = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		txtPayload = new javax.swing.JTextArea();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		btnSubscribe = new javax.swing.JButton();
		btnUnsubscribe = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("DMS\u4ea7\u54c1\u6f14\u793a");
		setLocationByPlatform(true);
		setMinimumSize(new java.awt.Dimension(614, 600));
		setResizable(false);
		getContentPane().setLayout(null);

		pnlSettings.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlSettings.setLayout(null);

		jLabel1.setText("address\uff1a");
		pnlSettings.add(jLabel1);
		jLabel1.setBounds(10, 10, 70, 17);

		txtAddress.setText("tcp://mqtt.dms.aodianyun.com:1883");
		pnlSettings.add(txtAddress);
		txtAddress.setBounds(90, 10, 470, 23);

		jLabel2.setText("pubkey\uff1a");
		pnlSettings.add(jLabel2);
		jLabel2.setBounds(10, 50, 70, 17);

		txtPubKey.setText("demo");
		pnlSettings.add(txtPubKey);
		txtPubKey.setBounds(90, 50, 190, 23);

		jLabel3.setText("subkey\uff1a");
		pnlSettings.add(jLabel3);
		jLabel3.setBounds(300, 50, 70, 17);

		txtSubKey.setText("demo");
		pnlSettings.add(txtSubKey);
		txtSubKey.setBounds(370, 50, 190, 23);
		pnlSettings.add(txtClientId);
		txtClientId.setBounds(90, 90, 240, 23);

		jLabel4.setText("clientId\uff1a");
		pnlSettings.add(jLabel4);
		jLabel4.setBounds(10, 90, 70, 17);

		btnConnect.setText("Connect");
		btnConnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnConnectActionPerformed(evt);
			}
		});
		pnlSettings.add(btnConnect);
		btnConnect.setBounds(340, 90, 110, 25);

		btnDisconnect.setText("Disconnect");
		btnDisconnect.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDisconnectActionPerformed(evt);
			}
		});
		pnlSettings.add(btnDisconnect);
		btnDisconnect.setBounds(450, 90, 110, 25);

		getContentPane().add(pnlSettings);
		pnlSettings.setBounds(20, 20, 570, 130);

		pnlMessage.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 0)));
		pnlMessage.setEnabled(false);
		pnlMessage.setLayout(null);

		btnClear.setText("Clear");
		btnClear.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnClearActionPerformed(evt);
			}
		});
		pnlMessage.add(btnClear);
		btnClear.setBounds(80, 180, 80, 25);

		jLabel5.setText("topic\uff1a");
		pnlMessage.add(jLabel5);
		jLabel5.setBounds(10, 20, 70, 17);

		txtMessage.setColumns(20);
		txtMessage.setEditable(false);
		txtMessage.setRows(5);
		jScrollPane2.setViewportView(txtMessage);

		pnlMessage.add(jScrollPane2);
		jScrollPane2.setBounds(10, 210, 550, 160);

		cbSubTopic.setEditable(true);
		cbSubTopic.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "test" }));
		pnlMessage.add(cbSubTopic);
		cbSubTopic.setBounds(90, 20, 240, 23);

		btnSend.setText("Send");
		btnSend.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSendActionPerformed(evt);
			}
		});
		pnlMessage.add(btnSend);
		btnSend.setBounds(340, 60, 110, 25);

		cbSendTopic.setEditable(true);
		cbSendTopic.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "test" }));
		pnlMessage.add(cbSendTopic);
		cbSendTopic.setBounds(90, 60, 240, 23);

		txtPayload.setColumns(20);
		txtPayload.setRows(5);
		jScrollPane1.setViewportView(txtPayload);

		pnlMessage.add(jScrollPane1);
		jScrollPane1.setBounds(10, 100, 550, 70);

		jLabel6.setText("message\uff1a");
		pnlMessage.add(jLabel6);
		jLabel6.setBounds(10, 185, 70, 17);

		jLabel7.setText("topic\uff1a");
		pnlMessage.add(jLabel7);
		jLabel7.setBounds(10, 60, 70, 17);

		btnSubscribe.setText("Subscribe");
		btnSubscribe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSubscribeActionPerformed(evt);
			}
		});
		pnlMessage.add(btnSubscribe);
		btnSubscribe.setBounds(340, 20, 110, 25);

		btnUnsubscribe.setText("Unsubscribe");
		btnUnsubscribe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUnsubscribeActionPerformed(evt);
			}
		});
		pnlMessage.add(btnUnsubscribe);
		btnUnsubscribe.setBounds(450, 20, 110, 25);

		getContentPane().add(pnlMessage);
		pnlMessage.setBounds(20, 160, 570, 380);

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {
		txtMessage.setText("");
	}

	private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {
		if(DMS.getClient()!=null &&
			cbSendTopic.getSelectedItem()!=null &&
			!"".equals(cbSendTopic.getSelectedItem().toString().trim()) &&
			!"".equals(txtPayload.getText().trim())) {
			try {
				btnSend.setEnabled(false);
				final String topic = cbSendTopic.getSelectedItem().toString().trim();
				final String payload = txtPayload.getText().trim();
				DMS.publish(topic, payload,null,new IMqttActionListener() {
					@Override
					public void onSuccess(IMqttToken arg0) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								btnSend.setEnabled(true);
								addMessage("Send : " + payload);
								txtPayload.setText("");
								cbmSendTopic.removeElement(topic);
								cbmSendTopic.insertElementAt(topic, 0);
								cbSendTopic.setSelectedIndex(0);
							}
						});
					}
					@Override
					public void onFailure(IMqttToken arg0, Throwable arg1) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								btnSend.setEnabled(true);
								addMessage("Fail to send.");
							}
						});
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
				btnSend.setEnabled(true);
			}
		}
	}

	private void btnUnsubscribeActionPerformed(java.awt.event.ActionEvent evt) {
		if(DMS.getClient()!=null && 
			cbSubTopic.getSelectedItem()!=null && 
			!"".equals(cbSubTopic.getSelectedItem().toString().trim())) {
			try {
				String topic = cbSubTopic.getSelectedItem().toString().trim();
				IMqttToken token =  DMS.unsubscribe(topic);
				token.waitForCompletion(10000);
				addMessage("Unsubscribe : " + topic);
				cbmSubTopic.removeElement(topic);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void btnSubscribeActionPerformed(java.awt.event.ActionEvent evt) {
		if(DMS.getClient()!=null && 
			cbSubTopic.getSelectedItem()!=null && 
			!"".equals(cbSubTopic.getSelectedItem().toString().trim())) {
			try {
				String topic = cbSubTopic.getSelectedItem().toString().trim();
				IMqttToken token = DMS.subscribe(topic);
				token.waitForCompletion(10000);
				addMessage("Subscribe : " + topic);
				cbmSubTopic.removeElement(topic);
				cbmSubTopic.insertElementAt(topic, 0);
				cbSubTopic.setSelectedIndex(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void btnDisconnectActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			IMqttToken token = DMS.disconnect();
			token.waitForCompletion(10000);
		} catch (Exception e) {
			addMessage("Failure of disconnection.");
		} finally {
			DMS.close();
			reset();
		}
	}

	private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {
		if (DMS.getClient() == null && txtAddress.getText().trim().length() > 0
				&& txtPubKey.getText().trim().length() > 0
				&& txtSubKey.getText().trim().length() > 0
				&& txtClientId.getText().trim().length() > 0) {
			try {
				addMessage("Connecting...");
				btnConnect.setEnabled(false);
				DMS.init(txtAddress.getText().trim(), txtClientId.getText().trim(), this);
				DMS.connect(txtPubKey.getText().trim(), txtSubKey.getText().trim(), null, new IMqttActionListener() {
					@Override
					public void onSuccess(IMqttToken asyncActionToken) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								addMessage("Connected.");
								txtAddress.setEnabled(false);
								txtPubKey.setEnabled(false);
								txtSubKey.setEnabled(false);
								txtClientId.setEnabled(false);
								btnConnect.setEnabled(false);
								btnDisconnect.setEnabled(true);
								cbSubTopic.setEnabled(true);
								btnSubscribe.setEnabled(true);
								btnUnsubscribe.setEnabled(true);
								cbSendTopic.setEnabled(true);
								txtPayload.setEnabled(true);
								btnSend.setEnabled(true);
							}
						});
					}
					@Override
					public void onFailure(IMqttToken asyncActionToken,
							Throwable exception) {
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								DMS.close();
								reset();
								addMessage("Failure of connection.");
							}
						});
					}
				});
			} catch (Exception e) {
				addMessage("Failure of connection.");
				DMS.close();
				reset();
			}
		}
	}

	private void initDMS() {
		txtClientId.setText(UUID.randomUUID().toString().replace("-", ""));
		cbmSubTopic = new javax.swing.DefaultComboBoxModel();
		cbmSendTopic = new javax.swing.DefaultComboBoxModel();
		cbSubTopic.setModel(cbmSubTopic);
		cbSendTopic.setModel(cbmSendTopic);
		reset();
	}

	private void addMessage(String msg) {
		if(txtMessage.getText().length()!=0) {
			txtMessage.append("\n");
		}
		txtMessage.append(msg);
	}

	private void reset() {
		txtAddress.setEnabled(true);
		txtPubKey.setEnabled(true);
		txtSubKey.setEnabled(true);
		txtClientId.setEnabled(true);
		btnConnect.setEnabled(true);
		btnDisconnect.setEnabled(false);
		cbSubTopic.setEnabled(false);
		btnSubscribe.setEnabled(false);
		btnUnsubscribe.setEnabled(false);
		cbSendTopic.setEnabled(false);
		txtPayload.setEnabled(false);
		btnSend.setEnabled(false);
		cbmSubTopic.removeAllElements();
	}

	@Override
	public void connectionLost(Throwable cause) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DMS.close();
				reset();
				addMessage("Connection lost.");
			}
		});
	}

	@Override
	public void messageArrived(String topic, MqttMessage message)
			throws Exception {
		final String payload = message + "";
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				addMessage("Recv : " + payload);
			}
		});
	}

	@Override
	public void deliveryComplete(IMqttDeliveryToken token) {
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new DMSDemo().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton btnClear;
	private javax.swing.JButton btnConnect;
	private javax.swing.JButton btnDisconnect;
	private javax.swing.JButton btnSend;
	private javax.swing.JButton btnSubscribe;
	private javax.swing.JButton btnUnsubscribe;
	private javax.swing.JComboBox cbSendTopic;
	private javax.swing.JComboBox cbSubTopic;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JPanel pnlMessage;
	private javax.swing.JPanel pnlSettings;
	private javax.swing.JTextField txtAddress;
	private javax.swing.JTextField txtClientId;
	private javax.swing.JTextArea txtMessage;
	private javax.swing.JTextArea txtPayload;
	private javax.swing.JTextField txtPubKey;
	private javax.swing.JTextField txtSubKey;
	// End of variables declaration//GEN-END:variables
	private javax.swing.DefaultComboBoxModel cbmSubTopic;
	private javax.swing.DefaultComboBoxModel cbmSendTopic;
}