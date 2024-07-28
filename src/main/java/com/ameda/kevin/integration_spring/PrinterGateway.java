package com.ameda.kevin.integration_spring;

import org.springframework.messaging.Message;
/*
*
@author ameda
@project integration-spring
*
*/

public interface PrinterGateway {
    void print(Message<?> message);
}
