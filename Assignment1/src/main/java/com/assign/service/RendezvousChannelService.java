package com.assign.service;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

@MessageEndpoint(value="rendezvousChannelService")
public class RendezvousChannelService {
	@ServiceActivator(inputChannel="rendezvousChannel", autoStartup="true")
	public void processRndMessage(Message<String> msg){
		/*MessageChannel replyChannel = (MessageChannel) msg.getHeaders()
				.get(MessageHeaders.REPLY_CHANNEL);
		Message msg1 = MessageBuilder.withPayload("RND Message received.").build();
		replyChannel.send(msg1);*/
		System.out.println("RND message received");
	}
}
