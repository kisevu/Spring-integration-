package com.ameda.kevin.integration_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication{


	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}



}
