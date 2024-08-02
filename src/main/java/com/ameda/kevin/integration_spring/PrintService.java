package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

import java.util.Map;

public class PrintService {

    public void print(Message<?>message){

        for(Map.Entry<String,Object> entry: message.getHeaders().entrySet()){
            System.out.println("GenericMessage: "+message.getPayload()+", headers={"+entry+"}");
        }
    }

}
