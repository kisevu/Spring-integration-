package com.ameda.kevin.integration_spring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication implements ApplicationRunner {
	//channels are important because they decouple endpoints that exchange
	// messages
	@Autowired
	private DirectChannel channel;


	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
//		channel.subscribe(new MessageHandler() {
//
//			@Override
//			public void handleMessage(Message<?> message) throws MessagingException {
//				new PrintService().print((Message<String>) message);
//			}
//		});

		Message<String> message = MessageBuilder
				.withPayload("Hello kev from builder pattern")
				.setHeader("key","value")
				.build();
		channel.send(message);
	}

	//included a single endpoint as (service-activator) to complete the
	// entire flow

}
