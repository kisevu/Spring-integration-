package com.ameda.kevin.integration_spring;/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomSplitter extends AbstractMessageSplitter {
    /**
     * Subclasses must override this method to split the received Message. The return value may be a Collection or
     * Array. The individual elements may be Messages, but it is not necessary. If the elements are not Messages, each
     * will be provided as the payload of a Message. It is also acceptable to return a single Object or Message. In that
     * case, a single reply Message will be produced.
     *
     * @param message The message.
     * @return The result of splitting the message.
     * @author ameda
     *
     */
    @Override
    protected Object splitMessage(Message<?> message) {
        return new ArrayList<String>
                (Arrays.asList(message.getPayload().toString().split(" ")));
    }
}
