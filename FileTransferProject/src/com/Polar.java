package com;

import java.io.File;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Polar implements Runnable{
	public void run(){  
		File source = new File("D:/source");
		File[] listOfFiles = source.listFiles();
		
		for (File file : listOfFiles) {
		    if (file.isFile()) {
		        if (!isFileValid(file.getName()) || isFileDuplicate(file.getName()) || !isFileOnTime(file)) {
		        	file.delete();
				}
		        else{
		    	    try {
		    	    	File movedfile=new File("D:/destination/"+file.getName());
		    	    	file.renameTo(movedfile);
		    	    }catch(Exception ex) {
		    	    	System.out.println("Unable to copy file:"+ex.getMessage());
		    	    }
		        }
	     }
	}
}	
	public boolean isFileValid(String filename){
		Map<String, String> map=ApplicationContext.map;
		  Iterator it = map.entrySet().iterator();
		  	   while (it.hasNext()) {
		  	    	Map.Entry pair = (Map.Entry)it.next();
		  	    	if(filename.equals(pair.getKey())){
		  	    		return true;
		  			}
		  	   }
		return false;	
	}
	
	public boolean isFileDuplicate(String filename){
		File destination = new File("D:/destination");
		File[] listOfFiles = destination.listFiles();
		Map<String,String> processedFilesMap = new HashMap<String,String>();
		for (File file1 : listOfFiles) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			processedFilesMap.put(file1.getName(), sdf.format(file1.lastModified()));
		}
		
		if(processedFilesMap.containsKey(filename)){
			String processedFileDate=processedFilesMap.get(filename);
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			String strDate= sdf.format(date);
			if(processedFileDate.equals(strDate)){
				return true;
			}
		}
		return false;	
	}
	
	public boolean isFileOnTime(File file){
		if(isFileValid(file.getName())){
			Map<String, String> map=ApplicationContext.map;
			String expectedtime=map.get(file.getName());
			Long receivedTime = file.lastModified();
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date date;
			try {
				date = sdf.parse(expectedtime);
				System.out.println("Time: " + sdf.format(date));
				String source = sdf.format(date);
				String[] tokens = source.split(":");
				int secondsToMs = Integer.parseInt(tokens[2]) * 1000;
				int minutesToMs = Integer.parseInt(tokens[1]) * 60000;
				int hoursToMs = Integer.parseInt(tokens[0]) * 3600000;
				long total = secondsToMs + minutesToMs + hoursToMs;
/*				System.out.println(total);
				
				long second = (total / 1000) % 60;
				long minute = (total / (1000 * 60)) % 60;
				long hour = (total / (1000 * 60 * 60)) % 24;

				String time = String.format("%02d:%02d:%02d:%d", hour, minute, second, total);
				System.out.println(time);*/
				
				return true;
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return false;	
	}
}
