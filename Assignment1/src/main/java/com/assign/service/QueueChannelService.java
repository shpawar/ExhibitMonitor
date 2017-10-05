package com.assign.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="queueChannelService")
public class QueueChannelService {
	@ServiceActivator(inputChannel="queueChannel", autoStartup="true")
	public void readDataFromQueue(Message<String> msg){
		System.out.println(msg.getPayload());
	}
	
}
