package com.sprngInt.splitter;

import java.io.IOException;

import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

public class FileRecordSplitter extends AbstractMessageSplitter {

	@Override
	protected Object splitMessage(Message<?> message) {
		try {

			/*Object payload = message.getPayload();*/
			System.out.println("Hello");

		} catch (Exception e) {
			String msg = "Unable to transform file: " + e.getMessage();

		}
		return null;
	}
}
