package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

public class CustomTransformer {


    public String transform(Message<String> message){
        String [] tokens = message.getPayload().split(" ");
        return tokens[1] + ", "+ tokens[0];
    }

}
