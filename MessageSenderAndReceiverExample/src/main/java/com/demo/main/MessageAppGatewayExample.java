package com.demo.main;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import com.demo.dao.GatewayInterface;
import com.demo.service.GatewayEndpointService;

public class MessageAppGatewayExample {

	public static void main(String[] args) {
		GenericXmlApplicationContext context=new GenericXmlApplicationContext("beans.xml");
		//GatewayEndpointService gatewayEndpointService=new GatewayEndpointService();
		GatewayInterface gatewayInterface = context.getBean("in-channel",GatewayInterface.class);
		Message<String> msg=MessageBuilder.withPayload("Hello").build();
		gatewayInterface.publish(msg);
	}

}
