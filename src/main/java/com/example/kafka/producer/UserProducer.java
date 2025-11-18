package com.example.kafka.producer;

import com.example.kafka.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

    private final KafkaTemplate<String, User> kafkaTemplate;

    public UserProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, User user) {
        kafkaTemplate.send("users", user);
        System.out.println("Produced: " + user);
    }
}
