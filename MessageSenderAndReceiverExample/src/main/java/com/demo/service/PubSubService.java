package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@MessageEndpoint(value="pubSubChannelService")
public class PubSubService implements MessageHandler{

	public void handleMessage(Message<?> message) throws MessagingException {
		System.out.println("Handling Message:" + message.getPayload());
	}
}
