package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value="queueService")
public class QueueService {
		@ServiceActivator(inputChannel="queueChannel", autoStartup="true")
		public void processMsg(Message<String> msg){
			System.out.println(msg.getPayload());
		}
}

