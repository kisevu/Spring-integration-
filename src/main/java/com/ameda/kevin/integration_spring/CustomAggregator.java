package com.ameda.kevin.integration_spring;
/*
*
@author ameda
@project integration-spring
*
*/

import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.aggregator.AbstractAggregatingMessageGroupProcessor;
import org.springframework.integration.store.MessageGroup;
import org.springframework.messaging.Message;

import java.util.Map;

public class CustomAggregator extends AbstractAggregatingMessageGroupProcessor {

      /*
      *  @author ameda
      * */

    @Override
    protected Object aggregatePayloads(MessageGroup group, Map<String, Object> defaultHeaders) {
        StringBuilder builder = new StringBuilder();

        for(Message<?> message: group.getMessages()){
            System.out.println(message.getHeaders().get(IntegrationMessageHeaderAccessor.CORRELATION_ID));
            builder.append(message.getPayload());
        }
        return builder.toString();
    }
}
