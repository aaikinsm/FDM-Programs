package com.fdmgroup;

public class Company extends BankCustomer{
	
	public Company(int idNumber, int taxIdNumber, String name, String address) {
		super(idNumber, taxIdNumber, name, address);
	}

	public void depositToAllAccounts(int dAmount) {
		for (BankAccount bankAccount : accounts) {
			bankAccount.deposit(dAmount);
		}
	}
}
