package com.iot.nero.facade_log;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.google.common.collect.ImmutableMap;
import com.iot.nero.facade_log.facade.impl.LogFacade;
import com.iot.nero.parent_log.constant.CONSTANT;
import com.iot.nero.utils.spring.PropertyPlaceholder;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;
import kafka.consumer.Consumer;

/**
 * Author neroyang
 * Email  nerosoft@outlook.com
 * Date   2017/7/15
 * Time   下午6:09
 */
class LogConsumer {

    //groupName可以随意给，因为对于kafka里的每条消息，每个group都会完整的处理一遍
    private static final String GROUP_NAME = "log_group";
    private static final String TOPIC_NAME = "log";
    private static final int CONSUMER_NUM = 4;
    private static final int PARTITION_NUM = 4;

    private LogFacade logFacade;

    public LogConsumer(LogFacade logFacade) {
        this.logFacade = logFacade;
    }

    public void listen(){


        // specify some consumer properties
        Properties props = new Properties();
        props.put("zookeeper.connect", "47.94.251.146:2181");//PropertyPlaceholder.getProperty("zookeeper.connect").toString());
        props.put("zookeeper.connectiontimeout.ms", "100000");//PropertyPlaceholder.getProperty("zookeeper.connectiontimeout.ms").toString());
        props.put("group.id", GROUP_NAME);

        // Create the connection to the cluster
        ConsumerConfig consumerConfig = new ConsumerConfig(props);
        final ConsumerConnector consumerConnector =
                Consumer.createJavaConsumerConnector(consumerConfig);

        // create 4 partitions of the stream for topic “test”, to allow 4
        // threads to consume
        Map<String, List<KafkaStream<byte[], byte[]>>> topicMessageStreams =
                consumerConnector.createMessageStreams(
                        ImmutableMap.of(TOPIC_NAME, PARTITION_NUM));
        List<KafkaStream<byte[], byte[]>> streams = topicMessageStreams.get(TOPIC_NAME);

        // create list of 4 threads to consume from each of the partitions
        ExecutorService executor = Executors.newFixedThreadPool(CONSUMER_NUM);

        // consume the messages in the threads
        for (final KafkaStream<byte[], byte[]> stream : streams) {
            executor.submit(new Runnable() {
                public void run() {
                    for (MessageAndMetadata<byte[], byte[]> msgAndMetadata : stream) {
                        // process message (msgAndMetadata.message())
                        System.out.println(new String(msgAndMetadata.message()));

                        //System.out.println(logFacade.SysLog(1l,"{type:001,content:\"api\"}"));
                        if(logFacade.SysLog(1L,new String(msgAndMetadata.message()))>=1) {
                            consumerConnector.commitOffsets();
                        }else{
                            System.out.println(CONSTANT.SYSTEM_LOG_INSERT_TO_DB_FAILED);
                        }
                    }
                }
            });
        }
    }
}
