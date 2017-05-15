package com.fdmgroup.race;

public abstract class Vehicle {
	private String type;
	private String name;
	private int numberOfGears;
	private int numberOfWheels;

	public Vehicle() {
		this(null, null, 6, 4);
	}

	public Vehicle(String type, String name, int numberOfGears, int numberOfWheels) {
		super();
		this.type = type;
		this.name = name;
		this.numberOfGears = numberOfGears;
		this.numberOfWheels = numberOfWheels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfGears() {
		return numberOfGears;
	}

	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public void setNumberOfWheels(int numberOfWheels) {
		this.numberOfWheels = numberOfWheels;
	}
	
	public abstract void drive();

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", name=" + name + ", numberOfGears=" + numberOfGears + ", numberOfWheels="
				+ numberOfWheels + "]";
	}
	
	

}
