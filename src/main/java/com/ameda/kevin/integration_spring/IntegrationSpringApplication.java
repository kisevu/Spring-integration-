package com.ameda.kevin.integration_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Primary;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication implements ApplicationRunner {

	@Autowired
	private PrinterGateway gateway;



	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		String [] payloads = {"kevin ameda","judith mongare","Oscar kisala"};
		for(int x = 0; x<payloads.length; x++){
			Message<?> message = MessageBuilder
					.withPayload(payloads[x])
					.build();
			this.gateway.print(message);
		}
	}
}
