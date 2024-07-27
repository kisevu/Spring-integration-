package com.ameda.kevin.integration_spring;

/*
*
@author ameda
@project integration-spring
*
*/


import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class PrintService {

    public Message<?> print(Message<String> message){
        System.out.println(message.getPayload());
        int messageNumber = (int) message.getHeaders().get("messageNumber");
        return MessageBuilder.withPayload("Sending a reply for message "+messageNumber).build();
    }
}
