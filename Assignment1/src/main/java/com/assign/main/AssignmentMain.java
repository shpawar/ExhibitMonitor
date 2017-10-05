package com.assign.main;

import java.util.PriorityQueue;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.integration.IntegrationMessageHeaderAccessor;
import org.springframework.integration.channel.PriorityChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.channel.RendezvousChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;

public class AssignmentMain {
	public static void main(String args[]){
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		
		System.out.println("------------------------\nExample 1 : A --channel1-- B --channel2--C");		 
		MessageChannel channel1 = context.getBean("firstChannel", MessageChannel.class);
		Message<String> msg1 = MessageBuilder.withPayload("Hi").build();
		channel1.send(msg1);
		
		System.out.println("------------------------\nExample 2 : Queue Channel");		 
		QueueChannel qChannel = context.getBean("queueChannel", QueueChannel.class);
		String names[] = {"BB", "DD", "FF","GG", "EE", "CC","AA"};
		for(String name : names){
			Message<String> qmsg = MessageBuilder.withPayload(name).build();
			qChannel.send(qmsg);
		}
		
		System.out.println("------------------------\nExample 3 : Priority Channel");		 
		PriorityChannel prChannel = context.getBean("priorityChannel", PriorityChannel.class);
		String cities[] = {"Kolhapur","Pune", "Mumbai","Akola"};
		for(int i=0; i<cities.length; i++){
			//Message<String> prmsg = MessageBuilder.withPayload(city).build();
			//TODO : comparator, check the order of  o/p
			Message<String> prmsg = MessageBuilder.withPayload(cities[i])
					.setHeader(IntegrationMessageHeaderAccessor.PRIORITY, i).build();
			prChannel.send(prmsg);
		}
		
		System.out.println("------------------------\nExample 4 : Rendezvous Channel");
		//replyChannel
		RendezvousChannel rndChannel = context.getBean("rendezvousChannel", RendezvousChannel.class);
		Message<String> rndmsg = MessageBuilder.withPayload("RND msg sent")
				.setHeader(MessageHeaders.REPLY_CHANNEL,"replyChannel").build();
		rndChannel.send(rndmsg);
	}
}
