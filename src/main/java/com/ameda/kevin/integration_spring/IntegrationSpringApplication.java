package com.ameda.kevin.integration_spring;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//a modern way of working with the builder...
		Message<String> message = MessageBuilder
				.withPayload("Hello kev from builder pattern")
				.setHeader("header1","header1")
				.build();
		PrintService printService = new PrintService();
		printService.print(message);
	}
}
