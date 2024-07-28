package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/
import org.springframework.messaging.Message;
public class DefaultService {

    public void print(Message<?>message){
        System.out.println("Default service printing: "+message.getPayload());
    }

}
