package com.fdmgroup.race;

public class Car extends Vehicle {

	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String type, String name, int numberOfGears, int numberOfWheels) {
		super(type, name, numberOfGears, numberOfWheels);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void drive() {
		System.out.println("Driving the car");
	}

	@Override
	public String getType() {
		return "Car";
	}
}
