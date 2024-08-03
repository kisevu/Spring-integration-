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
        return "From inbound Gateway: 1 message worked";
    }

    public void printConsole(Message<?>message){
        System.out.println("Message was passed to printConsole from the Outbound Gateway");
        System.out.println(message);
    }
}
