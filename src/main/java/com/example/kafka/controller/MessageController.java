package com.example.kafka.controller;

import com.example.kafka.producer.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final KafkaProducerService producerService;

    @PostMapping
    public String send(@RequestParam String msg) {
        log.info("Received POST request with msg: {}", msg);
        producerService.sendMessage(msg);
        return "Message sent: " + msg;
    }
}
