package com.fdmgroup.util;

public class StopWatch {

	private long elapsedTime;
	
	public void start(){
		elapsedTime = System.nanoTime();
	}
	
	public void stop(){
		elapsedTime = System.nanoTime()-elapsedTime;
	}
	
	public long getElapsedTime(){
		return elapsedTime;
	}
}
