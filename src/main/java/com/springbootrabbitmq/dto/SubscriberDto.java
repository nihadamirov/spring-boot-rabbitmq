package com.springbootrabbitmq.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubscriberDto {
    private Long id;
    private String name;
    private String channel;
}
