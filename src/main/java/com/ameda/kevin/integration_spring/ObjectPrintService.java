package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

public class ObjectPrintService {

    public void print(Message<?> message){
        System.out.println("object: "+ message.getPayload());
    }
}
