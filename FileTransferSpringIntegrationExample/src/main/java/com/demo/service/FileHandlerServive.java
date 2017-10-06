package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="fileHandlerService")
public class FileHandlerServive {
	@ServiceActivator(inputChannel="channel1",autoStartup="true")
	public void readDataFromQueue(Message<String> msg){
		System.out.println(msg.getPayload());
	}
}
