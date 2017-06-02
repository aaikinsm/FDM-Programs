package com.fdmgroup.service;

public class EmailService extends MessageProvider implements Messaging{
	
	@Override
	public void send(String Receipient, String message) {
		System.out.println(getPrefix());
		System.out.println(Receipient+" ---> "+message);
	}
	

}
