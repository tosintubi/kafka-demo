package com.tommot.kafkademo.kafka;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    @Value("${topic.name}")
    private final String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);


    public void sendMessage(String message){
        LOGGER.info(String.format("About to send message %s", message));
        kafkaTemplate.send(topic, message);
        log.info(String.format("Message Sent :%s ", message));

    }
}
