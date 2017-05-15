package com.fdmgroup.fizzbuzz.task3;

public class PensionLogic {
	public static boolean isPensionable(Person person, String year){
		int birthYear = Integer.parseInt(person.getDateOfBirth().substring(6));
		int givenYear = Integer.parseInt(year);
		
		if (givenYear - birthYear == 65){
			return true;
		}else{
			return false;
		}
	}
}
