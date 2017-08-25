package com.zhl.auth.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public final class PropsHandler {
	

	private static Properties props = null;
	private static Properties props4Util = null;
	private static Properties propsRASUtil = null;
	static {
		try {
			if(null == props){
				props = new Properties();
			}
			if(null == props4Util){
				props4Util = new Properties();
			}
			if(null == propsRASUtil){
			    propsRASUtil = new Properties();
			}
			InputStream in = PropsHandler.class.getResourceAsStream("/application.properties");
			InputStream in4Util = PropsHandler.class.getResourceAsStream("/pub-util.properties");
			InputStream inRASUtil = PropsHandler.class.getResourceAsStream("/RAS.properties");
			props.load(in);props4Util.load(in4Util);propsRASUtil.load(inRASUtil);
			
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

	public static void main(String[] args) {
//		String property = PropsHandler.getPropertyRASUtil("public_key");
//		System.out.println(property);
//	    updateProperties("public_key", "123");
	}
	public final static String getProperty(String key) {
		return props.getProperty(key);
	}
	public final static String getProperty4Util(String key) {
		return props4Util.getProperty(key);
	}
	public final static String getPropertyRASUtil(String key) {
	    return propsRASUtil.getProperty(key);
	}

	public final static String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}
	
	

    
}
