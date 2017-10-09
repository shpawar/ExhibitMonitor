package com.demo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App 
{
	    public static void main(String... args) {

	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("beans.xml");
	    	
	    	/*GenericXmlApplicationContext context = new GenericXmlApplicationContext("beans.xml");*/

	       /*context.registerShutdownHook();

	        SpringIntegrationUtils.displayDirectories(context);

	        final Scanner scanner = new Scanner(System.in);

	        while (!scanner.hasNext("q")) {
	            //Do nothing unless user presses 'q' to quit.
	        }

	        System.exit(0);*/
	    }
}
