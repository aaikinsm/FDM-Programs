package com.fdmgroup.device;

public class Printer extends Device implements Usb{

	@Override
	public void turnOn() {
		System.out.println("Printer is on...");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Printer is off...");	
	}

	@Override
	public void charge() {
		System.out.println("Charging printer..");		
	}

	@Override
	public void send() {
		System.out.println("Sending data to the printer...");		
	}

	@Override
	public void receive() {
		System.out.println("receiving data from the printer...");			
	}

}
