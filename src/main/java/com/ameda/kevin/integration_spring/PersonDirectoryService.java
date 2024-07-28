package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

public class PersonDirectoryService {

    public Person findNewPeople(){
        System.out.println("Inbound adapter pulled this service...");
     return new Person("kevin","ameda");
    }

}
