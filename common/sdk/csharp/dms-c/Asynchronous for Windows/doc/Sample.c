#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <windows.h>
#include "DMSAsyncApi.h"

/* �������� */
#define ADDRESS     "tcp://mqtt.dms.aodianyun.com:1883"
#define CLIENTID    "Publisher"
#define PUB_KEY		"demo"
#define SUB_KEY		"demo"
#define TOPIC       "test"
#define PAYLOAD     "Hello World!C"

/* �������� */
void connectionLost(void *context, char *cause);
int messageArrived(void *context, char *topicName, int topicLen, DMSAsync_message *message);
void deliveryComplete(void* context, DMSAsync_token token);
void onConnect(void* context, DMSAsync_successData* response);
void onConnectFailure(void* context, DMSAsync_failureData* response);
void onDisconnect(void* context, DMSAsync_successData* response);
void onSubscribe(void* context, DMSAsync_successData* response);
void onSubscribeFailure(void* context, DMSAsync_failureData* response);
void onUnsubscribe(void* context, DMSAsync_successData* response);
void onUnsubscribeFailure(void* context, DMSAsync_failureData* response);
void onSend(void* context, DMSAsync_successData* response);

static int isConnected = 0;
static int isDisconnected = 0;
static int isSubscribed = 0;
static int isSendOK = 0;

/* ���첽ʾ�� */
int main(int argc, char* argv[])
{
	int result;
	DMSAsync client;
	//�����ͻ��˶���
	
	client = DMSAsync_create(ADDRESS, CLIENTID);
	DMSAsync_setCallbacks(client, client, connectionLost, messageArrived, deliveryComplete);
	//��������
	if ((result = DMSAsync_connect(client, PUB_KEY, SUB_KEY, onConnect, onConnectFailure, client)) != DMSASYNC_SUCCESS)
	{
		printf("Failed to connect, return code %d\n", result);
		exit(-1);
	}
	//�ȴ����ӳɹ�...
	while (isConnected == 0) Sleep(100);

	//��ע����
	DMSAsync_responseOptions subRespOpts = RespOptsInit(onSubscribe, onSubscribeFailure, client);
	DMSAsync_subscribe(client, TOPIC, &subRespOpts);
	//�ȴ���ע�ɹ�...
	//DMSAsync_waitForCompletion(client,subRespOpts.token,10000);
	while (isSubscribed == 0) Sleep(100);
	
	//������Ϣ
	DMSAsync_responseOptions sendOpts = RespOptsInit(onSend, NULL, client);
	DMSAsync_send(client, TOPIC, strlen(PAYLOAD), PAYLOAD, &sendOpts);
	//�ȴ����ͳɹ�...
	//DMSAsync_waitForCompletion(client, sendOpts.token, 10000);
	while (isSendOK == 0) Sleep(100);

	//��������Ͽ�����
	printf("���س����Ͽ����ӣ�\n"); getchar();

	//ȡ����ע
	DMSAsync_responseOptions unsubRespOpts = RespOptsInit(onUnsubscribe, onUnsubscribeFailure, client);
	DMSAsync_unsubscribe(client, TOPIC, &unsubRespOpts);
	DMSAsync_waitForCompletion(client, unsubRespOpts.token, 10000);

	//�Ͽ�����
	DMSAsync_disconnectOptions discOpts = DisconOptsInit(onDisconnect, NULL, client);
	DMSAsync_disconnect(client, &discOpts);
	//�ȴ��Ͽ��ɹ�...
	while (isDisconnected==0) Sleep(100);
	//�ͷ����Ӷ���
	DMSAsync_destroy(&client);
	system("pause");
	return 0;
}
/* �¼�֪ͨ */
int messageArrived(void *context, char *topicName, int topicLen, DMSAsync_message *message)
{
	printf("messageArrived-->%s:%.*s\n", topicName, message->payloadlen, (char*)message->payload);
	fflush(stdout);
	DMSAsync_freeMessage(&message);
	DMSAsync_free(topicName);
	return 1;
}
void connectionLost(void *context, char *cause)
{
	printf("connectionlost\n");
}
void deliveryComplete(void* context, DMSAsync_token token)
{
	printf("deliveryComplete\n");
}
void onConnect(void* context, DMSAsync_successData* response)
{
	printf("onConnect\n");
	isConnected = 1;
}
void onConnectFailure(void* context, DMSAsync_failureData* response)
{
	printf("onConnectFailure\n");
}
void onSubscribe(void* context, DMSAsync_successData* response)
{
	printf("onSubscribe\n");
	isSubscribed = 1;
}
void onSubscribeFailure(void* context, DMSAsync_failureData* response)
{
	printf("onSubscribeFailure\n");
}
void onUnsubscribe(void* context, DMSAsync_successData* response)
{
	printf("onUnsubscribe\n");
}
void onUnsubscribeFailure(void* context, DMSAsync_failureData* response)
{
	printf("onUnSubscribeFailure\n");
}
void onDisconnect(void* context, DMSAsync_successData* response)
{
	printf("onDisconnect\n");
	isDisconnected = 1;
}
void onSend(void* context, DMSAsync_successData* response)
{
	printf("onSend-->Message with token value %d delivery confirmed\n", response->token);
	isSendOK = 1;
}