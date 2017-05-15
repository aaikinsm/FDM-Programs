package com.fdmgroup.math;

/**
 * 
 * This Class is built to do some basic math operations.
 * @author albert.mensah
 * @version 1.0.0
 *
 */
public class Calculator {
	private int num1;
	private int num2;
	
	public void setNum1 (int a){
		num1 = a;
	}
	
	public void setNum2 (int a){
		num2 = a;
	}
	
	public int add(){
		return num1 + num2;
	}
	
	public int sub(){
		return num1 - num2;
	}
	
	public int mul(){
		return num1 * num2;
	}
	
	public int div(){
		return num1 / num2;
	}
	
	/**
	 * 
	 * @param array is the input for calculating the average
	 * @return returns the average of integers in the array as double
	 * @since 1.0.0
	 */
	public double calculateAverage(int[] array){
		double sum = 0;
		/*for (int i = 0; i < array.length; i++){
			sum += array[i];
		}*/
		for (int i : array) {
			sum += i;			
		}
		return sum/array.length;
	}
	
	/**
	 * 
	 * @param min is minimum random value
	 * @param max is the maximum random value
	 * @return a random integer between min and max
	 */
	public int getRandomNumber(int min, int max){
		return (int)Math.round(Math.random()*(max-min)+min);
	}
	
	public boolean isPrime(int number){
		if (number == 0 || number == 1)
			return true;
		double rVal = (int)Math.sqrt(Math.abs(number));
		for (int i = 2; i<= rVal; i++){
			if (number % i == 0)
				return false;
		}
		return true;
	}
	
	public void getAllPrimeNumbers(int max){		
		if (max == 0 || max == 1){
			System.out.println("0 and 1 are prime numbers");
			return;
		}
		int counter = 0;
		/*while (counter <= max ){
			if (isPrime(counter))
				System.out.print(counter + ", ");
			counter++;
		}*/
		do{
			if (isPrime(counter))
				System.out.print(counter + ", ");
			counter++;
		} while (counter <= max );
	}
	
	/**
	 * Calculating the factorial of a long number
	 * @param number to calculate factorial
	 * @return a long number as a result
	 * @deprecated But we don't have any alternatives yet
	 */
	public long factorial(long number){
		
		if (number == 0 || number == 1)
			return 1;
		long result = number;
		result *= factorial(number -1);
		return result;
	}
}
