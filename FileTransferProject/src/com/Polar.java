package com;

import java.io.File;
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
		        if (!isFileOnTime(file.getName())) {//!isFileValid(filename.getName())&&isFileDuplicate(filename.getName())
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
	
	public boolean isFileOnTime(String filename){
		if(isFileValid(filename)){
			Map<String, String> map=ApplicationContext.map;
			Iterator it = map.entrySet().iterator();
		  	   while (it.hasNext()) {
		  	    	Map.Entry pair = (Map.Entry)it.next();
		  	    	
		  	   }
			String time = "15:30:18";
			DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date date;
			try {
				date = sdf.parse(time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//System.out.println("Time: " + sdf.format(date));
		}
		return false;	
	}
}
