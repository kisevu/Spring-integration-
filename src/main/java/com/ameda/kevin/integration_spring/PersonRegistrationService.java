package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

public class PersonRegistrationService {


    public void registerEmail(Person person){
        System.out.println("email created for: "+person.getFirstName());
    }

}
