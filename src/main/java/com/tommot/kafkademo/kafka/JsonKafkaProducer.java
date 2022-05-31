package com.tommot.kafkademo.kafka;


import com.tommot.kafkademo.payload.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class JsonKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private final KafkaTemplate<String, User> kafkaTemplate;

    public User sendMessage(User data){
        LOGGER.info(String.format("Message sent: %s",data.toString()));

        data.setId(UUID.randomUUID());
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "tommot-topic-2")
                .build();

        kafkaTemplate.send(message);
        return data;
    }

}

