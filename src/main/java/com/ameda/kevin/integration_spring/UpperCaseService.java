package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

public class UpperCaseService {

    public String execute(Person person){
        return (person.getFirstName()+ " "+person.getLastName()).toUpperCase();
    }
}
