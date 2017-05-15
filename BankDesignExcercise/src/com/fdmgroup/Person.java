package com.fdmgroup;

public class Person extends BankCustomer{
	
	public Person(int idNumber, int taxIdNumber, String name, String address) {
		super(idNumber, taxIdNumber, name, address);
	}
	
	public void resetAllAccounts(){
		for (BankAccount bankAccount : accounts) {
			bankAccount.correction(0);
		}
	}
}
