package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UpperCaseService {

    public String execute(Person person){
        try{
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
        return (person.getFirstName()+ " "+person.getLastName()).toUpperCase();
    }
}
