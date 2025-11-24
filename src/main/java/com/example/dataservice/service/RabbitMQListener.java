package com.example.dataservice.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression("!'${spring.rabbitmq.host}'.isEmpty()")
public class RabbitMQListener {

    public RabbitMQListener() {

    }

}
