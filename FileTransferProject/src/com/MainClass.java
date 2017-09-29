package com;

public class MainClass {
	public static void main(String[] arg){
		ApplicationContext.xmlParser();
		Polar polar = new Polar();
		Thread t1 =new Thread(polar);  
		t1.start();  
	}
}
