package com.fdmgroup.race;

public class Suv extends Vehicle implements AllWheelDrive, Comparable<Suv>{

	public Suv() {
		super();
	}

	public Suv(String type, String name, int numberOfGears, int numberOfWheels) {
		super(type, name, numberOfGears, numberOfWheels);
	}

	@Override
	public void drive() {
		System.out.println("Driving the SUV");
	}
	
	@Override
	public String getType() {
		return "SUV";
	}

	@Override
	public void accelerate() {
		System.out.println("Accelerating...");
	}

	@Override
	public int compareTo(Suv o) {
		return this.getName().compareTo(o.getName());
	}

}
