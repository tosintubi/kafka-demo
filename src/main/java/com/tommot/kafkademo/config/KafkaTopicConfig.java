package com.tommot.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic tommotTopic(){
        return TopicBuilder.name("kafka-topic")
                .partitions(10)
                .build();
    }
}
