package com.fdmgroup.service;

public class GreetService {

	private String message;
	private int number;

	public GreetService(String message) {
		super();
		this.message = message;
	}

	public GreetService() {
		super();
	}

	public GreetService(int number) {
		super();
		this.number = number;
	}

	public GreetService(String message, int number) {
		super();
		this.message = message;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void say(){
		System.out.println(number +"---->"+ message);
	}
}
