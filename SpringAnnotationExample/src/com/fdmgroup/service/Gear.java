package com.fdmgroup.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Gear {

	public enum Transmission {
		AUTOMATIC, MANUAL
	}
	
	@Value("6")
	private int num;
	
	@Value("AUTOMATIC")
	private Transmission transmission;

	public Gear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gear(int num, Transmission transmission) {
		super();
		this.num = num;
		this.transmission = transmission;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Transmission getTransmission() {
		return transmission;
	}

	public void setTransmission(Transmission transmission) {
		this.transmission = transmission;
	}

	@Override
	public String toString() {
		return "Gear [num=" + num + ", transmission=" + transmission + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
