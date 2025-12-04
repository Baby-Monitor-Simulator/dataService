package com.example.dataservice;

import com.example.dataservice.service.RabbitTest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataServiceApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DataServiceApplication.class, args);
    }
}
