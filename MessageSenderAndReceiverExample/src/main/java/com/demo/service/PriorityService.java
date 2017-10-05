package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="priorityChannelService")
public class PriorityService {
	@ServiceActivator(inputChannel="priorityChannel", autoStartup="true")
	public void readDataFromPriority(Message<String> msg){
		System.out.println(msg.getPayload());
	}
}
