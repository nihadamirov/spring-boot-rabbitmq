package com.springbootrabbitmq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootrabbitmq.dto.SubscriberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {
    private final AmqpAdmin amqpAdmin;
    private final AmqpTemplate amqpTemplate;

    @Value("${rabbit.queue.name}")
    private String queueName;
    @Value("${rabbit.queue.exchange}")
    private String exchangeName;
    @Value("${rabbit.queue.route-key}")
    private String routingKey;

    public void publish(SubscriberDto subscriberDto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String payload = null;

        payload = mapper.writeValueAsString(subscriberDto);
        amqpTemplate.convertAndSend(exchangeName, routingKey, payload);
    }
}
