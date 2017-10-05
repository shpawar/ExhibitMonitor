package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="msgService")
public class MessageService {
	@ServiceActivator(inputChannel="msgChannel", autoStartup="true", outputChannel="msgChannel1")
	public String processMsg(Message<String> msg){
		String s=msg.getPayload();
		System.out.println(s);
				String str=s.concat("World");
		return str;
	}
}
