package com.fdmgroup.math;

public class MathApp {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		int[] array = {12,-5,36,-7,11,25};
		double average = cal.calculateAverage(array);
		System.out.println("The average is: " + average);
		
		System.out.println("__________________________");
		
		System.out.println("The random number is: " + cal.getRandomNumber(1, 10));
		System.out.println("__________________________");
		System.out.println("Is 123123 prime: "+ cal.isPrime(123123));
		System.out.println("Is 1231 prime: "+ cal.isPrime(1231));
		System.out.println("__________________________");
		cal.getAllPrimeNumbers(46);
		System.out.println("\n__________________________");
		System.out.println("The factorial of 6 is: "+cal.factorial(6));
	}
}
