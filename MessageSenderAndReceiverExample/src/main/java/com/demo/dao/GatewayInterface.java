package com.demo.dao;

import org.springframework.messaging.Message;

public interface GatewayInterface {
	public void publish(Message<String> msg);
}
