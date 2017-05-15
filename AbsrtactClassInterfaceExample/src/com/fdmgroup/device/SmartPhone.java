package com.fdmgroup.device;

public class SmartPhone extends Device implements Usb {

	@Override
	public void turnOn() {
		System.out.println("SmartPhone is on...");
		
	}

	@Override
	public void turnOff() {
		System.out.println("SmartPhone is off...");	
	}

	@Override
	public void charge() {
		System.out.println("Charging smartphone..");	
		
	}

	@Override
	public void send() {
		System.out.println("Sending data to the smartphone...");	
		
	}

	@Override
	public void receive() {
		System.out.println("receiving data from th smartphone...");	
		
	}

}
