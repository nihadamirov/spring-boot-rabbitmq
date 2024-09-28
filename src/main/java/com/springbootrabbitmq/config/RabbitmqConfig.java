package com.springbootrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitmqConfig {

    @Value("${rabbit.queue.name}")
    private String queueName;
    @Value("${rabbit.queue.exchange}")
    private String exchangeName;
    @Value("${rabbit.queue.route-key}")
    private String routingKey;


    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "tech-subscribe-queue-dlx");
        return new Queue(queueName, true, false, false, args);
    }


    @Bean
    public TopicExchange myExchange() {
        return new TopicExchange(exchangeName, true, true);
    }



    @Bean
    public Declarables bindings(TopicExchange exchange, Queue queue) {
        return new Declarables(BindingBuilder
                .bind(queue)
                .to(exchange)
                .with(routingKey));
    }


//    @Bean
//    public FanoutExchange myExchange() {
//        return ExchangeBuilder.fanoutExchange(exchangeName)
//                .durable(true)
//                .autoDelete()
//                .build();
//    }
//
//    @Bean
//    public Declarables bindings(FanoutExchange exchange, Queue queue) {
//        return new Declarables(BindingBuilder
//                .bind(queue)
//                .to(exchange));
//    }
}
