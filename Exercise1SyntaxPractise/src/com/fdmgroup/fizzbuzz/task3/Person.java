package com.fdmgroup.fizzbuzz.task3;

public class Person {
	
	private String firstname;
	private String lastname;
	private String dateOfBirth;
	
	public String getFirstname(){
		return firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public String getDateOfBirth(){
		return dateOfBirth;
	}
	
	public void setFirstname(String name){
		firstname = name;
	}
	public void setLastname(String name){
		lastname = name;
	}
	public void setDateOfBirth(String birthDate){
		dateOfBirth = birthDate;
	}
}
