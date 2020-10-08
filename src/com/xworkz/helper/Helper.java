package com.xworkz.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Helper {
	
	Properties prop;
	
	public Helper() throws IOException {
		prop = new Properties();
		try {
			FileInputStream fileinput = new FileInputStream("src/Config.properties");
			prop.load(fileinput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public String getproperty(String value) {
		String propvalue = null;
		if(value!=null) {
			propvalue  = prop.getProperty(value);
		}				
		return propvalue;	
	}

}