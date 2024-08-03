# Spring Integration JMS integration
## JMS Outbound Channel Adapter


JMS Inbound Channel Adapter is used to retrieve messages from a JMS queue by polling the queue
for any new messages.The new message found is then sent to the JMS system for distribution.
So the destination is where we are reading the messages and the channel is where the messages read off of the queue will
be sent. We see the jmsChannel is pretty much bound to the PrinterService which does print the gotten messages. The printing
is done through the invocation of the toString() method.
N/B Any time we are receiving messages from a message source such as activemq or jms server, we need to be operating
in one or two manners:
- Tha resource is going to push us the message.
- We're reaching out and pull that resource.
  (That's the reason we're going to configure a poller property)

## Author

- [Kevin Ameda Kisevu](https://github.com/kisevu) - Initial work


![read messages off the queue with jms](https://github.com/kisevu/Spring-integration-/blob/jms-integrations/src/main/resources/static/read-message-from-queue.JPG)
# Prerequisite
* The application is powered with docker which is used to run the activemq container
* use docker-compose.yml file provided
