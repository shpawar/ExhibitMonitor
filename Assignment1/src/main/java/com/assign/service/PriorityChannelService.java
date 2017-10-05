package com.assign.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="priorityChannelService")
public class PriorityChannelService {
	@ServiceActivator(inputChannel="priorityChannel", autoStartup="true")
	public void processPriorityChannel(Message<String> msg){
		System.out.println(msg.getPayload());
	}
}
