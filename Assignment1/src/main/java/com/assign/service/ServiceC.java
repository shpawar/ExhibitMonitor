package com.assign.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="serviceC")
public class ServiceC {
	@ServiceActivator(inputChannel="secondChannel", autoStartup="true")
	public void receiveAndProcessMsg(Message<String> msg){
		System.out.println(msg.getPayload() + " - service C");
	}
}
