package com.tommot.kafkademo.kafka;


import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics="tommot-topic", groupId = "tommot-kafka-group")
    public void consumer(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
