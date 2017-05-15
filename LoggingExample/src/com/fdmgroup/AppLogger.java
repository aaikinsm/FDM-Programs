package com.fdmgroup;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AppLogger {

	private static Logger userLogger = null;
	private static Logger sysLogger = null;

	private AppLogger(){
		init();
	}
	
	
	private static void init() {
		userLogger = Logger.getLogger("UserLogger");
		sysLogger = Logger.getLogger("SysLogger");
		
		PropertyConfigurator.configure("log4j.properties");
	}


	public static Logger getUserLogger(){
		if(userLogger == null)
			init();
		return userLogger;
	}

	public static Logger getSystemLogger(){
		if(sysLogger == null)
			init();
		return sysLogger;		
	}
}
