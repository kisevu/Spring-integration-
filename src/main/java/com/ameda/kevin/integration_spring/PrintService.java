package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

public class PrintService {

    public String print(Message<?>message){
        System.out.println("Printing the message:");
        System.out.println(message);
        return "1 message worked";
    }
}
