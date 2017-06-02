package com.fdmgroup.service;

import org.springframework.beans.factory.annotation.Value;

public abstract class Vehicle {

	@Value("Vehicle")
	private String type;
	private String model;
	private String color;
	private int numOfWheels;

	public Vehicle() {
		super();
	}

	public Vehicle(String type, String model, String color) {
		super();
		this.type = type;
		this.model = model;
		this.color = color;
	}

	public Vehicle(String type, String model, String color, int numOfWheels) {
		super();
		this.type = type;
		this.model = model;
		this.color = color;
		this.numOfWheels = numOfWheels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumOfWheels() {
		return numOfWheels;
	}

	public void setNumOfWheels(int numOfWheels) {
		this.numOfWheels = numOfWheels;
	}

	@Override
	public String toString() {
		return "Vehicle [type=" + type + ", model=" + model + ", color=" + color + ", numOfWheels=" + numOfWheels + "]";
	}

}
