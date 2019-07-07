package com.spring.boot.kafkaproduct.sender;

import com.spring.boot.kafkaproduct.pool.KafkaConsumerPool;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by hexinquan on 2019/01/20.
 */
@Component
public class KafkaSender {
    @Resource
    private KafkaConsumerPool kafkaConsumerPool;
}
