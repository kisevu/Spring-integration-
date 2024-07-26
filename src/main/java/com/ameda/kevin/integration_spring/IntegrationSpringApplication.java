package com.ameda.kevin.integration_spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication implements ApplicationRunner {
	// MessagingTemplate reduce on the boilerplate code
	// it provides for the requests and replies
	//Also xml configuration, we do not need to provide the output channel same
	//way we did to the input channel
	//also we do not need to provide output channel to the service activator endpoint
	@Autowired
	@Qualifier("inputChannel")
	private DirectChannel inputChannel;


	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Message<String> message = MessageBuilder
				.withPayload("Hello kev from builder pattern")
				.setHeader("key","value")
				.build();
		MessagingTemplate template = new MessagingTemplate();
		Message<?> resultMessage = template.sendAndReceive(inputChannel, message);
		System.out.println(resultMessage.getPayload());
	}

}
