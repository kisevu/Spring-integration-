package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

public class NumericPrintService {

    public void print(Message<?> message){
        System.out.println("Numeric printing: "+ message.getPayload());
    }
}
