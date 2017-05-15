package com.fdmgroup.fizzbuzz.task3;

public class Client {
	public static void main(String[] args) {
		Person p1, p2, p3; 
		p1 = new Person();
		p1.setFirstname("John");		
		p1.setLastname("Smith");		
		p1.setDateOfBirth("28/06/1993");	
		p2 = new Person();
		p2.setFirstname("Jane");		
		p2.setLastname("Doe");		
		p2.setDateOfBirth("05/01/1950");	
		p3 = new Person();
		p3.setFirstname("Fred");	
		p3.setLastname("Bloggs");
		p3.setDateOfBirth("12/12/1949");
		
		Person[] people = {p1,p2,p3}; 
		
		PensionController pensionContrl = new PensionController();
		pensionContrl.handlePensions(people);
	}
}
