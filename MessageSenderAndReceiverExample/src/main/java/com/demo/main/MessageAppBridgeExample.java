package com.demo.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.demo.service.PubSubService;

public class MessageAppBridgeExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext context=new GenericXmlApplicationContext("bean.xml");
		PublishSubscribeChannel publishSubscribeChannel=context.getBean("pubSubChannel",PublishSubscribeChannel.class);
		Message<String> msg=MessageBuilder.withPayload("Bridge message").build();
		publishSubscribeChannel.send(msg);
	}
}
