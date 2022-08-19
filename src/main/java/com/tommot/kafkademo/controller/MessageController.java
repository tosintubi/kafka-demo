package com.tommot.kafkademo.controller;


import com.tommot.kafkademo.kafka.JsonKafkaProducer;
import com.tommot.kafkademo.kafka.KafkaProducer;
import com.tommot.kafkademo.payload.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {


    private final KafkaProducer kafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return  ResponseEntity.ok("message send to the topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<User> publish(@RequestBody  User user){
        User usr = jsonKafkaProducer.sendMessage(user);
        return new ResponseEntity<User>(usr,HttpStatus.OK);
    }
}
