package com.rest.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
//import com.typesafe.config.Config;
//import com.typesafe.config.ConfigFactory;
import java.util.Scanner;

public class Utils {
	public  String getProperty(String propertyFileName,String key) throws IOException{
		Properties property = new Properties();
		String propertyFile="D:/Automation Community/Restful/workspace/restdemo/src/main/resources/"+propertyFileName;//D:\\Automation Community\\Restful\\projectpool\\ALM\\java\\com\\hp\\rest\\project\\alm.properties";
		InputStream is = getClass().getClassLoader().getResourceAsStream(propertyFile);
		if (is!=null){
		property.load(is);}
		else{System.out.println("Property file not found");}
		return property.getProperty(key);
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
