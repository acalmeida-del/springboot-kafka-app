package com.example.kafka.controller;

import com.example.kafka.User;
import com.example.kafka.producer.UserProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserProducer producer;

    public UserController(UserProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendUser(@RequestBody User user) {
        producer.send("users", user);
        return "User sent: " + user.getName();
    }
}
