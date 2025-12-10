package com.example.dataservice.service;

import com.example.dataservice.component.DataController;
import com.example.dataservice.config.RabbitMQConfig;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.DependsOn;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@DependsOn("websocketservice") 
@ConditionalOnExpression("!'${spring.rabbitmq.host}'.isEmpty()")
public class RabbitMQListener {

    private final DataController dataController;

    public RabbitMQListener(DataController dataController) {
        this.dataController = dataController;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void MatlabListener(Object message, @Header("amqp_receivedRoutingKey") String routingkey){
        //handle request
        System.out.println(message.toString());
        dataController.SendData(message);
    }
}
