#DMS C Asynchronous API
#头文件
    #include "DMSAsyncApi.h"

#创建客户端对象
    #define ADDRESS     "tcp://mqtt.dms.aodianyun.com:1883"
    #define CLIENTID    "Publisher0"
    DMSAsync client;
    //创建客户端对象,失败返回 NULL
    client = DMSAsync_create(ADDRESS, CLIENTID);
    
#设置回调函数
    //成功返回 DMSASYNC_SUCCESS，失败返回 DMSASYNC_FAILURE
    //第二个参数为传递给回调函数的context
    DMSAsync_setCallbacks(client, client, connectionLost, messageArrived, deliveryComplete);
    
#回调函数定义
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
#连接服务器
    #define PUB_KEY     "demo"
    #define SUB_KEY     "demo"
    int result;
    //成功返回 DMSASYNC_SUCCESS，否则onFailure回调函数中返回错误代码
    if ((result = DMSAsync_connect(client, PUB_KEY, SUB_KEY, onConnect, onConnectFailure, client)) != DMSASYNC_SUCCESS)
    {
        printf("Failed to connect, return code %d\n", result);
        exit(-1);
    }
    ...
    void onConnect(void* context, DMSAsync_successData* response)
    {
        printf("onConnect\n");
    }
    void onConnectFailure(void* context, DMSAsync_failureData* response)
    {
        printf("onConnectFailure\n");
    }
#关注话题
    #define TOPIC       "test"
    DMSAsync_responseOptions subRespOpts = RespOptsInit(onSubscribe, onSubscribeFailure, client);
    //成功返回 DMSASYNC_SUCCESS，否则返回错误代码
    DMSAsync_subscribe(client, TOPIC, &subRespOpts);
    //等待关注成功
    DMSAsync_waitForCompletion(client,subRespOpts.token,10000);
    ...
    void onSubscribe(void* context, DMSAsync_successData* response)
    {
        printf("onSubscribe\n");
    }
    void onSubscribeFailure(void* context, DMSAsync_failureData* response)
    {
        printf("onSubscribeFailure\n");
    }
#推送消息
    #define TOPIC       "test"
    #define PAYLOAD     "Hello World!C"
    DMSAsync_responseOptions sendOpts = RespOptsInit(onSend, NULL, client);
    //成功返回 DMSASYNC_SUCCESS，否则返回错误代码
    DMSAsync_send(client, TOPIC, strlen(PAYLOAD), PAYLOAD, &sendOpts);
    DMSAsync_waitForCompletion(client, sendOpts.token, 10000);
    ...
    void onSend(void* context, DMSAsync_successData* response)
    {
        printf("onSend-->Message with token value %d delivery confirmed\n", response->token);
    }
#取消关注
    #define TOPIC       "test"
    DMSAsync_responseOptions unsubRespOpts = RespOptsInit(onUnsubscribe, onUnsubscribeFailure, client);
    //成功返回 DMSASYNC_SUCCESS，否则返回错误代码
    DMSAsync_unsubscribe(client, TOPIC, &unsubRespOpts);
    //等待取消关注成功
    DMSAsync_waitForCompletion(client, unsubRespOpts.token, 10000);
    ...
    void onUnsubscribe(void* context, DMSAsync_successData* response)
    {
        printf("onUnsubscribe\n");
    }
    void onUnsubscribeFailure(void* context, DMSAsync_failureData* response)
    {
        printf("onUnSubscribeFailure\n");
    }
#断开连接
    static int isDisconnected = 0;
    DMSAsync_disconnectOptions discOpts = DisconOptsInit(onDisconnect, NULL, client);
    //成功返回 DMSASYNC_SUCCESS，否则返回错误代码
    DMSAsync_disconnect(client, &discOpts);
    //等待断开成功...
    while (isDisconnected==0) Sleep(100);
    ...
    void onDisconnect(void* context, DMSAsync_successData* response)
    {
        printf("onDisconnect\n");
        isDisconnected = 1;
    }
#释放对象
    DMSAsync_destroy(&client);
    
    