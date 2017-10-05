package com.demo.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class MessageAppRendezvousMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		RendezvousChannel rendezvousChannel = context.getBean("rendezvousChannel",RendezvousChannel.class);
		Message<String> reMessage = MessageBuilder.withPayload("Hello").build();
		rendezvousChannel.send(reMessage,1000);
	}
}
