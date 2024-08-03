# Spring Integration JMS integration
## JMS Message Driven Channel Adapter


This includes another way in which we can receive messages off of our JMS queue.
* We saw JMS Inbound channel Adapter was used,but by polling, it used 7000ms to check whether there's a message in the queue.
  Typically, my application initiating a request to check if a message exists in the server.
  Another approach is the server notifying us when a message is available.
* When using a Message-Driven Channel Adapter, we get to see the use of notifications to whether a message is on the queue.

## Author

- [Kevin Ameda Kisevu](https://github.com/kisevu) - Initial work


![read messages off the queue with jms](https://github.com/kisevu/Spring-integration-/blob/jms-integrations/src/main/resources/static/read-message-from-queue.JPG)
# Prerequisite
* The application is powered with docker which is used to run the activemq container
* use docker-compose.yml file provided
