package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.router.AbstractMessageRouter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CustomRouter extends AbstractMessageRouter {

    /**
     * Subclasses must implement this method to return a Collection of zero or more
     * MessageChannels to which the given Message should be routed.
     *
     * @param message The message.
     * @return The collection of message channels.
     * @ameda
     */
    @Autowired
    @Qualifier("intChannel")
    private MessageChannel intChannel;

    @Autowired
    @Qualifier("stringChannel")
    private MessageChannel stringChannel;

    @Override
    protected Collection<MessageChannel> determineTargetChannels(Message<?> message) {
        Collection<MessageChannel> targetChannels = new ArrayList<>();
        if(message.getPayload().getClass().equals(Integer.class)){
            targetChannels.add(intChannel);
        }else if(message.getPayload().getClass().equals(String.class)){
            targetChannels.add(stringChannel);
        }
        return targetChannels;
    }
}
