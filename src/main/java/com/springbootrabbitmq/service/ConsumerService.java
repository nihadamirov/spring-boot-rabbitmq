package com.springbootrabbitmq.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootrabbitmq.dto.SubscriberDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @RabbitListener(queues = "${rabbit.queue.name}")
    public void processMessage(String payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        SubscriberDto dto = mapper.readValue(payload, SubscriberDto.class);
        System.out.printf("Consuming Queue Data: Id %s, Name: %s%n", dto.getId(), dto.getName());
    }
}
