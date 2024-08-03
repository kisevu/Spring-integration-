# Spring Integration JMS integration
* Integration with JMS (Java Message Service) JMS Outbound Gateway
*******************************************************
* There are gateways provided in jms integrations.
* JMS Outbound Gateway is used to send a message from the spring jms application to a JMS queue.
* Once the message is placed upon a queue, another entity works the message and places a response on a replyQueue
  from which the outbound gateway receives the message.
  Once the Outbound Gateway receives the message it passes it to spring integration messaging system for further processing.
  Process
*********************************************
* In main class the save method is invoked by the gateway.Person object is passed to inboundChannel as payload.
* It goes to the "object-to-string" transformer
* That message from transformer is passed to the Outbound Gateway
* The message is passed to the queue (sample.queue) on activeMQ server.
* Upon receiving the message,activeMQ server notifies the Inbound Gateway which receives the message and passes it to the
  jmsChannel. JmsChannel drops the message with PrinterService bean which then invokes the print() message to replyQueue of the
  Outbound Gateway(monitors the replyQueue). The message is delivered to the replyChannel which connected to another service
  activator that invokes the printConsole() Which prints the message.


## Author

- [Kevin Ameda Kisevu](https://github.com/kisevu) - Initial work



![HTTP Inbound Gateway](https://github.com/kisevu/Spring-integration-/blob/jms-integrations/src/main/resources/static/http_inbound_gateway.JPG)
# Prerequisite
* The application is powered with docker which is used to run the activemq container
* use docker-compose.yml file provided
