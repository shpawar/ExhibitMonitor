package com.sprngInt.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringIntegrationMain {

	public static void main(String[] args) throws Exception {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		try {
			Thread.sleep(2000);
			//Properties prop = new Properties();
			//FileInputStream is = new FileInputStream(new File("D:\\source\\File.json"));
			//prop.load(is);
/*			String line = null;
			 while ((line = is.readLine()) != null) {
			        
			        System.out.println(prop);
				 }*/

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----");
	}

}
