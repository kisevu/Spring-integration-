package com.ameda.kevin.integration_spring;

/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.util.concurrent.ListenableFuture;


public interface EnhancedPrinterGateway {
    public void print(Person person);
    public ListenableFuture<String> uppercase(Person person); //allows working with callbacks
}
