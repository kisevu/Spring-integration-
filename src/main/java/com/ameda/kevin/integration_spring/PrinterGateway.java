package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.messaging.Message;

import java.util.concurrent.Future;

public interface PrinterGateway {
    //will accept a message and return a message
    // a message will be passed to this gateway and this gateway is
    //going to pass the message to a channel
    //configured in the context classpath
    Future<Message<String>> print(Message<?> message);
}