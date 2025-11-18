package com.example.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test-topic";

    public void sendMessage(String message) {
        log.info("Sending msg: {}", message);
        kafkaTemplate.send(TOPIC, message);
        log.info("Sent message: {}", message);
    }
}
