package com.ameda.kevin.integration_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


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
	public void run(ApplicationArguments args) throws InterruptedException,ExecutionException {
		List<Future<Message<String>>> futures = new ArrayList<>();

		for(int x=0; x<10;x++){
			Message<String> message = MessageBuilder
					.withPayload("Printing message: "+ x)
					.setHeader("messageNumber",x)
					.build();
			System.out.println("sending message: "+ x);
			futures.add(this.gateway.print(message));
		}

		for(Future<Message<String>> future: futures){
			System.out.println(future.get().getPayload());
		}
	}










	// Channels are used to pass messages between endpoints.
	// Different channel implementations and components
	// Some messages might need to be sent to multiple endpoints or a single endpoint
	//Having different implementations of channels helps us control how messages are received by our
	//endpoints.
	//In spring integration, there are PollableChannel and SubscribableChannel
	/*
	* Base channel interface, MessageChannel which is implemented by all channels within spring integration
	* PollableChannel extends MessageChannel - Allows our endpoints to request messages from a buffer,
	* by invoking its receive() method.
	* The Channel stores messages in a buffer that it receives from a producer until they are pulled by a
	* consumer that is pulling the channel. We need having endpoints that are constantly pulling messages
	* from the buffer.
	* Buffer - place to store something temporarily in order to mitigate differences between input speed and
	* output speed.
	* a PollableChannel is an interface but a QueueChannel and PriorityQueueChannel are implementations of such
	* a channel.
	* SubscribableChannel: allow endpoints or consumers to request to be notified when a message is received.
	*  (similar to the observer pattern).
	* DirectChannel- most basis channel type within spring integration, also implements the SubsribableChannel
	* interface. Allows direct communication between one producer endpoint and one consumer endpoint. Default
	*  channel type.
	* PublicSubscribeChannel also  implements the SubscribableChannel interface.
	* Allows for multiple consumers of a message. Once a message is sent to the channel it is send with a one to many
	* fashion. Useful for sending event type notifications out through the messaging system.
	* */
}
