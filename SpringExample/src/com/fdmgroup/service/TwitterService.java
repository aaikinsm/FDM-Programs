package com.fdmgroup.service;

public class TwitterService extends MessageProvider implements Messaging{
	
	@Override
	public void send(String receipient, String message) {
		System.out.println(getPrefix());
		System.out.println("@"+receipient+" --> "+message);
	}
	

}
