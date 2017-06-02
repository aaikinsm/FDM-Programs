package com.fdmgroup.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("scooter")
@Scope("prototype")
public class Scooter extends Vehicle{
	
	@Override
	@Value("2")
	public void setNumOfWheels(int numOfWheels) {
		super.setNumOfWheels(numOfWheels);
	}
	
	@Override
	@Value("Red")
	public void setColor(String color) {
		super.setColor(color);
	}
	
	@Override
	@Value("Scooter")
	public void setType(String type) {
		super.setType(type);
	}

	@Override
	public String toString() {
		return "Scooter [getType()=" + getType() + ", getModel()=" + getModel() + ", getColor()=" + getColor()
				+ ", getNumOfWheels()=" + getNumOfWheels() + "]";
	}
	
	@PostConstruct
	public void init(){
		System.out.println("Further initialization of scooter");
	}

	@PreDestroy
	public void destroy(){
		System.out.println("destroying scooter");
	}

}
