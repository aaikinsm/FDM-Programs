package com.fdmgroup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {
		
		ArithmethicOperation ao = new ArithmethicOperation();
		try {
			ao.testCheckeExeption();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int[] array = {12, 23, 0, 14, 7};
		ao.setNumbers(array);;
		System.out.println("The result of add is "+ao.add());
		System.out.println("The result of div is "+ao.div());
		//System.out.println("The result of div is "+ao.div(12,0));
		System.out.println("_______________________________________");
		
		Account ac1 = new Account(125.0, "OPEN");
		Account ac2 = new Account(0.0, "CLOSED");
		
		try {
			System.out.println(ac1.withdraw(130));
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
		System.out.println("After Withdraw...");
		
		ac2.deposit(36.50);
		System.out.println("After Depsit...");
	}
}
