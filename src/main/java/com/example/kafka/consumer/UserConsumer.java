package com.example.kafka.consumer;

import com.example.kafka.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @KafkaListener(topics = "users", groupId = "test-group")
    public void listen(User user) {
        System.out.println("Consumed: " + user);
    }
}
