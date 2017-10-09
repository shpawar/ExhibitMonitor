package com.sprngInt.service;

import java.io.File;

public class FileHandler {
	public void processFile(File inFile){
		System.out.println("file received : " + inFile.getName());
	}
}
