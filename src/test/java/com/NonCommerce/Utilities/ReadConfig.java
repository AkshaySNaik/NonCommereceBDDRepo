package com.NonCommerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
    public Properties prop;
	String path = System.getProperty("user.dir")+"//Configration//Config.properties";
	
	public ReadConfig() {
		
		prop = new Properties();
		
		File file = new File(path);		
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}	
	}
	
	public String getBrowser() {
		
		String brow = prop.getProperty("Browser");
		if(brow!=null) 
			return brow;
		else 
			throw new RuntimeException("Browser Not Found In Properties File");
	}
	
	public String getUrl() {
		
		String urll = prop.getProperty("Url");
		if(urll!=null) 
			return urll;
		else
			throw new RuntimeException("Url  not found in Properties File");	
		
	}
	

}
