package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="msgService1")
public class MessageService1 {
	@ServiceActivator(inputChannel="msgChannel1", autoStartup="true")
	public void processMsg(Message<String> msg){
		System.out.println(msg.getPayload());
	}
}
