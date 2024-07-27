package com.ameda.kevin.integration_spring;

/*
*
@author ameda
@project integration-spring
*
*/


import org.springframework.messaging.Message;

public class UpperCasePrintService {

    public void print(Message<String> message){
        System.out.println(message.getPayload().toUpperCase());
    }
}
