package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;
public class PrintService {

    public void print(Message<?>message){
        System.out.println("String printing "+message.getPayload());
    }

}
