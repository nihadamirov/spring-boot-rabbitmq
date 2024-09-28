package com.springbootrabbitmq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springbootrabbitmq.dto.SubscriberDto;
import com.springbootrabbitmq.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/subscribe")
@RequiredArgsConstructor
public class SubscribeController {

    private final PublisherService publisherService;

    @PostMapping
    public ResponseEntity<?> home(@RequestBody SubscriberDto subscriberDto) throws JsonProcessingException {
        System.out.println("Publish Data: " + subscriberDto.getName());
        publisherService.publish(subscriberDto);
        return ResponseEntity.ok().build();
    }
}
