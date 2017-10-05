package com.assign.utils;

import java.util.Comparator;

import org.springframework.messaging.Message;

public class CityComparator implements Comparator<Message<String>>{

	public int compare(Message<String> msg1, Message<String> msg2) {
		String str1 = msg1.getPayload();
		String str2 = msg2.getPayload();
		
		return str1.compareTo(str2);
	}

}
