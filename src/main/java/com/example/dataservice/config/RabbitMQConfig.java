package com.example.dataservice.config;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnExpression("!'${spring.rabbitmq.host}'.isEmpty()")
public class RabbitMQConfig {

    public static final String TOPIC_EXCHANGE_NAME = "matlab-exchange";
    public static final String QUEUE_NAME = "DataService";

    @Bean
    public Declarables rabbitMQDeclarables() {
        TopicExchange topicExchange = new TopicExchange(TOPIC_EXCHANGE_NAME);
        Queue queue = new Queue(QUEUE_NAME);

        return new Declarables(
                queue,
                topicExchange,
                BindingBuilder.bind(queue).to(topicExchange).with("matlab.*")
        );
    }
}
