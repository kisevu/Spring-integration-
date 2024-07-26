package com.ameda.kevin.integration_spring;

/*
*
@author ameda
@project integration-spring
*
*/


import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import java.util.Map.Entry;

public class PrintService {

    public Message<?> print(Message<String> message){
        MessageHeaders headers = message.getHeaders();
        for(Entry<String,Object> entry: headers.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println(message.getPayload());
        return MessageBuilder.withPayload("returned message").build();
    }
}
