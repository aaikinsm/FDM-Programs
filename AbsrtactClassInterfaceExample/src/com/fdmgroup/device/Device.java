package com.fdmgroup.device;

public abstract class Device {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void turnOn();
	
	public abstract void turnOff();
}
