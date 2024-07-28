package com.ameda.kevin.integration_spring;

/*
*
@author ameda
@project integration-spring
*
*/

public interface EnhancedPrinterGateway {
        //accepting a pojo
    void print(Person person);
    String uppercase(Person person);
}
