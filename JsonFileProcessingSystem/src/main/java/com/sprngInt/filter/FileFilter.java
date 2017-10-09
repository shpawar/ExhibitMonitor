package com.sprngInt.filter;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.springframework.messaging.Message;

public class FileFilter {
	public boolean isValid(Message<File> file){
		String extension = FilenameUtils.getExtension(file.getPayload().getName());
		if(extension.equals("json")){
			return true;
		}
		return false;
	}
}
