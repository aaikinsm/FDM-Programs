package com.fdmgroup.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class Car extends Vehicle implements InitializingBean, DisposableBean{

	@Autowired
	private Gear gear;

	public Car(Gear gear) {
		super();
		this.gear = gear;
	}

	public Car() {
		super();
	}

	public Car(String type, String model, String color, int numOfWheels) {
		super(type, model, color, numOfWheels);
	}

	public Gear getGear() {
		return gear;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}
	
	@Override
	@Value("Blue")
	public void setColor(String color) {
		super.setColor(color);
	}
	
	@Override
	@Value("4")
	public void setNumOfWheels(int numOfWheels) {
		super.setNumOfWheels(numOfWheels);
	}

	@Override
	@Value("Car")
	public void setType(String type) {
		super.setType(type);
	}
	@Override
	public String toString() {
		return "Car [gear=" + gear + ", getType()=" + getType() + ", getModel()=" + getModel() + ", getColor()="
				+ getColor() + ", getNumOfWheels()=" + getNumOfWheels() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying car object");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("initializing car object");
	}

	
	
	
}
