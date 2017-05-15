package com.fdmgroup.race;

public class Driver {

	private String name;
	private String licenceNumber;
	private int age;
	
	
	public Driver(String name, String licenceNumber, int age) {
		super();
		this.name = name;
		this.licenceNumber = licenceNumber;
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLicenceNumber() {
		return licenceNumber;
	}


	public void setLicenceNumber(String licenceNumber) {
		this.licenceNumber = licenceNumber;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Driver [name=" + name + ", licenceNumber=" + licenceNumber + ", age=" + age + "]";
	}
	
	
}
