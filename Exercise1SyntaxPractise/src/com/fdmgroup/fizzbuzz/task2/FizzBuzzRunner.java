package com.fdmgroup.fizzbuzz.task2;

public class FizzBuzzRunner {
	
	public void fizzBuzz(int number){
		for (int i = 1; i <= number; i++){
			if (fizz(i))
				System.out.println("FizzBuzz");
			else if (buzz(i))
				System.out.println("Fizz");
			else if (fizzbuzz(i))
				System.out.println("Buzz");
			else
				System.out.println(i);
		}
	}
	
	private boolean fizz(int num){
		boolean isValid = (num%3 == 0 && num%5 == 0);
		return isValid;
	}
	
	private boolean buzz(int num){
		boolean isValid = (num%3 == 0);
		return isValid;
	}
	
	private boolean fizzbuzz(int num){
		boolean isValid = (num%5 == 0);
		return isValid;		
	}
}
