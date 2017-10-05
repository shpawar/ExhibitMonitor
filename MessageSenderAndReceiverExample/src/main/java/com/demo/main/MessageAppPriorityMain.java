package com.demo.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

public class MessageAppPriorityMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");		
		System.out.println("---------------Priority Channel-----------------");
		PriorityChannel priorityChannel = context.getBean("priorityChannel",PriorityChannel.class);
		for(int i=0;i<10;i++){
			Message<String> priorityMsg = null;
			if(i==5){
				priorityMsg = MessageBuilder.withPayload("Hello :: "+i).setHeader(IntegrationMessageHeaderAccessor.PRIORITY, 25).build();
			}else{
				priorityMsg = MessageBuilder.withPayload("Hello :: "+i).setHeader(IntegrationMessageHeaderAccessor.PRIORITY, i).build();
			}
			priorityChannel.send(priorityMsg,1000);
		}

	}

}
