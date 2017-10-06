package com.demo.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

@MessageEndpoint(value = "msgServiveEndPoint")
public class GatewayEndpointService {

	@ServiceActivator(inputChannel = "in-channel", autoStartup = "true", outputChannel = "out-channel")
	public void publish(Message<String> msg) {
		System.out.println(msg.getPayload());
	}
}
