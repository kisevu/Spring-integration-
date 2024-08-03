# Spring Integration JMS integration
## JMS Outbound Channel Adapter

In Main application, we are invoking the save method on the gateway passing in a Person.
In xml-config, I've set up a gateway to accept the person object by making it the payload of the message
and sending it to the inbound channel.Inbound channel is connected to "object-to_string transformer" which will
in turn invoke the toString on person object.This is then made to be the payload which is entirely sent to the outboundchannel.
My outbound channel is then connected to the Outbound channel Adapter.
The Outbound channel Adapter then sends the message to destination which is the queue. The connection to the queue is
seamless because we have a configuration in place which tells it how to connect.

## Author

- [Kevin Ameda Kisevu](https://github.com/kisevu) - Initial work


![messages on activemq queue](resource/static/messages.JPG)
# Prerequisite
* The application is powered with docker which is used to run the activemq container
* use docker-compose.yml file provided
