package com.tommot.kafkademo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic tommotTopic(){
        return TopicBuilder.name("tommot-topic-2")
                .build();
    }


    @Bean
    public String getString(){
        return new String();
    }
}
