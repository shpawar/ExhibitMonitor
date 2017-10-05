package com.assign.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@MessageEndpoint(value="serviceB")
public class ServiceB {
	@ServiceActivator(inputChannel="firstChannel", outputChannel="secondChannel", autoStartup="true")
	public Message<String> receiveAndProcessMsg(Message<String> inmsg){
		String strMsg = inmsg.getPayload() + " world!";
		Message<String> msg = MessageBuilder.withPayload(strMsg).build();
		return msg;
	}
}
