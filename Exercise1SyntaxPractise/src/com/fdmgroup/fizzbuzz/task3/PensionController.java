package com.fdmgroup.fizzbuzz.task3;

public class PensionController {
	public void handlePensions(Person[] people){
		for (Person person : people) {
			if(PensionLogic.isPensionable(person,"2014")){
				View.printEligible(person);
			}else{
				View.printIneligible(person);
			}
		}
	}
}
