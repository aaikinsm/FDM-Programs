package com.fdmgroup.aspect;

public class LoggingAspect {

	public void logBefore(){
		System.out.println("Logging before...");
	}
	
	public void logAfter(){
		System.out.println("Logging after...");
	}
	
	public void logAfterThrow(){
		System.out.println("Logging after throwing exception...");
	}
}
