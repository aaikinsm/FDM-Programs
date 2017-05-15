package com.fdmgroup.fizzbuzz.task3;

public class View {
	public static void printEligible(Person person){
		System.out.println(person.getFirstname()+" "+person.getLastname()+" may qualify for a pension this year.");
	}
	public static void printIneligible(Person person){
		System.out.println(person.getFirstname()+" "+person.getLastname()+" is not old enough yet");
	}
}
