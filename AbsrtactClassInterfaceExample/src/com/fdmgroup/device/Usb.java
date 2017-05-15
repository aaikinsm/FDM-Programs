package com.fdmgroup.device;

public interface Usb {
	
	public static final float VERSION = 3.1f;
	
	public abstract void charge();
	void send();
	void receive();

}
