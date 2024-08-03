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
        System.out.println("Message printer is working the message.");
        return "From inbound Gateway: 1 message worked";
    }

    public void printConsole(Message<?>message){
        System.out.println("Message was passed to printConsole.");
        System.out.println(message);
    }
}
