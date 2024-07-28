package com.ameda.kevin.integration_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;


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
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee(1,"kevin",1500.00));
		employees.add(new Employee(2,"oscar",2000.00));
		employees.add(new Employee(1,"judith",1000.00));


		for(int x = 0; x< employees.size();++x){
			Employee employee = employees.get(x);
			Message<?> message = MessageBuilder
					.withPayload(employee)
					.build();
			this.gateway.print(message);
		}
		for(int x = 0; x<employees.size(); x++){
			Message<?> message = MessageBuilder
					.withPayload(x)
					.build();
			this.gateway.print(message);
		}
	}
}
