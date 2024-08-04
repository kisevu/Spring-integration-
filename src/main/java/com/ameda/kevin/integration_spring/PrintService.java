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
        String s  = "From inbound Gateway: 1 message worked";
        return s;
    }

    public void printConsole(Message<?>message){
        System.out.println("Message was passed to printConsole.");
        System.out.println(message);
    }
}
