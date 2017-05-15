package com.fdmgroup.model;

import javax.persistence.Embeddable;

@Embeddable
public class UserProfile {

	private String address;
	private int age;
	private String sin;

	public UserProfile(String address, int age, String sin) {
		super();
		this.address = address;
		this.age = age;
		this.sin = sin;
	}

	public UserProfile() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSin() {
		return sin;
	}

	public void setSin(String sin) {
		this.sin = sin;
	}

	@Override
	public String toString() {
		return "UserProfile [address=" + address + ", age=" + age + ", sin=" + sin + "]";
	}

}
