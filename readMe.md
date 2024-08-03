# Spring Integration JMS integration
## JMS Message Driven Channel Adapter


* Integration with JMS (Java Message Service) JMS Inbound Gateway
*******************************************************
* There are gateways provided in jms integrations.
* JMS Inbound Gateway is used to receive messages from a JMS server and provide a response to the received message.
* So in the gateway, we are going to receive our message from our jms server/activemq server. And works somewhat like a
  Message Driven channel Adapter. (The message is going to be pushed to us.)
* We'll be receiving the message via the push from the server using the Inbound Gateway. The gateway is going to put
  that message to a channel. Once the message is put in the channel, it is going to be delivered to an endpoint where some
  processing is to occur and a message can be sent back.
* A little change for the PrinterService to return a message

## Author

- [Kevin Ameda Kisevu](https://github.com/kisevu) - Initial work


![read messages off the queue with jms](https://github.com/kisevu/Spring-integration-/blob/jms-integrations/src/main/resources/static/reply-message-sent-to-reply-queue.JPG)
# Prerequisite
* The application is powered with docker which is used to run the activemq container
* use docker-compose.yml file provided
