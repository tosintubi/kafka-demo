package com.tommot.kafkademo.kafka;

import com.tommot.kafkademo.payload.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "tommot-topic-2", groupId = "tommot-kafka-group")
    public void consume (User user){
        log.info(String.format("Json message consumed: %s", user.toString()));
    }

}
