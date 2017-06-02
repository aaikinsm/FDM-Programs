package com.fdmgroup.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Required;

public class Person {

	private String name;
	private String address;
	private int age;
	private List<String> oldAddresses;
	private Set<String> creditCardNumbers;
	private Map<String, String> grades;

	public Person() {
		super();
	}

	public Person(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	
	

	public Person(String name, String address, int age, List<String> oldAddresses, Set<String> creditCardNumbers,
			Map<String, String> grades) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.oldAddresses = oldAddresses;
		this.creditCardNumbers = creditCardNumbers;
		this.grades = grades;
	}

	public Person(String name, String address, int age, List<String> oldAddresses) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.oldAddresses = oldAddresses;
	}

	
	public Person(String name, String address, int age, List<String> oldAddresses, Set<String> creditCardNumbers) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		this.oldAddresses = oldAddresses;
		this.creditCardNumbers = creditCardNumbers;
	}

	public List<String> getOldAddresses() {
		return oldAddresses;
	}

	public void setOldAddresses(List<String> oldAddresses) {
		this.oldAddresses = oldAddresses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	
	public Set<String> getCreditCardNumbers() {
		return creditCardNumbers;
	}

	public void setCreditCardNumbers(Set<String> creditCardNumbers) {
		this.creditCardNumbers = creditCardNumbers;
	}

	
	public Map<String, String> getGrades() {
		return grades;
	}

	public void setGrades(Map<String, String> grades) {
		this.grades = grades;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", age=" + age + ", oldAddresses=" + oldAddresses
				+ ", creditCardNumbers=" + creditCardNumbers + ", grades=" + grades + "]";
	}

}
