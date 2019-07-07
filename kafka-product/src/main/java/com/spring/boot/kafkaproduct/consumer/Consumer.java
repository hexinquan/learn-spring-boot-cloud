package com.spring.boot.kafkaproduct.consumer;

import com.spring.boot.kafkaproduct.ShutdownableThreed;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * Created by hexinquan on 2019/01/20.
 */
public class Consumer extends ShutdownableThreed {


    private KafkaConsumer kafkaConsumer;

    private String topic;

    private String groupId;

    public Consumer(KafkaConsumer kafkaConsumer, String topic, String groupId) {
        this.kafkaConsumer = kafkaConsumer;
        this.topic = topic;
        this.groupId = groupId;
    }

    @Override
    public void doWork() {

    }
}
