package com.example.dataservice.service;

import com.example.dataservice.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RabbitTest implements CommandLineRunner {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public RabbitTest (RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        String testMessage = "Hello, RabbitMQ!";
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, testMessage);
        System.out.println("Test message sent");
    }
}
