package com.demo.main;


import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class MessageAppMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		MessageChannel channel = context.getBean("msgChannel",MessageChannel.class);
		Message<String> msg = MessageBuilder.withPayload("Hello").build();
		channel.send(msg);
		
		System.out.println("---------------Queue Channel-----------------");
		QueueChannel queueChannel = context.getBean("queueChannel",QueueChannel.class);
		for(int i=0;i<10;i++){
		Message<String> queueMsg = MessageBuilder.withPayload("Hello").build();
		queueChannel.send(queueMsg);
		}
	}

}
