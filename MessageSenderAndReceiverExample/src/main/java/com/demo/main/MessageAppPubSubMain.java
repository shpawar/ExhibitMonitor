package com.demo.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.AbstractSubscribableChannel;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;

import com.demo.service.PubSubService;

public class MessageAppPubSubMain {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");		
		System.out.println("---------------Pub Sub Channel-----------------");
		PublishSubscribeChannel pubSubChannel = context.getBean("pubSubChannel",PublishSubscribeChannel.class);
		PubSubService handler = context.getBean("pubSubChannelService",PubSubService.class);
		pubSubChannel.subscribe(handler);
		Message<String> pubSubMsg = MessageBuilder.withPayload("Hello pubsub").build();
		pubSubChannel.send(pubSubMsg);
	}
}
