package com.ameda.kevin.integration_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class IntegrationSpringApplication implements ApplicationRunner {

	@Autowired
	private EnhancedPrinterGateway gateway;



	public static void main(String[] args) {
		SpringApplication.run(IntegrationSpringApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
	 Person [] payloads = {new Person("kevin","ameda"),new Person("judith","mongare")};
	 for(int x =0; x<payloads.length; x++){
		 System.out.println("Invoking the gateway method");
		 ListenableFuture<String> future = this.gateway.uppercase(payloads[x]);
		 future.addCallback(new ListenableFutureCallback<String>() {
			 @Override
			 public void onFailure(Throwable throwable) {
			 }

			 @Override
			 public void onSuccess(String result) {
				 System.out.println("invoking the success callback");
				 System.out.println(result);
			 }
		 });
		 //the way it happens is that the judith person waits processing of the Kevin person
		 //if it were some business operation that can be lengthy, then it means  that the operation
		 // would block
		 //Spring integration provides us with the Asynchronous gateways which offer such a behavior.

	 }
	}
}
