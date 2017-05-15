package com.fdmgroup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArithmethicOperation {

	private int[] numbers;
	
	public int add(){
		if (numbers == null)
			return 0;
		
		int sum = 0;
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	public int[] getNumbers() {
		return numbers;
	}

	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}
	
	public double div(){
		if (numbers == null)
			return 0.0;
		double d = numbers[0];
		for (int i=1; i<numbers.length; i++) {
			if(numbers[i] != 0)
				d /= numbers[i];
			else 
				return 0;
		}
		return d;
	}
	
	public double div(int a, int b){
		if (b==0)
			return 0;
		return a/b;
	}
	
	public void testCheckeExeption() throws FileNotFoundException, IOException{
		FileInputStream fis = new FileInputStream("C:/users/albert.mensah/Desktop/test.txt");	
		fis.read();
	}
}
