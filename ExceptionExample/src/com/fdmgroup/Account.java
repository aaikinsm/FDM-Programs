package com.fdmgroup;

public class Account {

	private double balance;
	private String status;

	public Account(double balance, String status) {
		super();
		this.balance = balance;
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amount){
		if (status.equalsIgnoreCase("CLOSED"))
			throw new IllegalAccountStateException();
		balance += amount;
		return true;
	}
	
	public boolean withdraw(double amount)throws InsufficientFundsException{
		if (status.equalsIgnoreCase("CLOSED"))
			throw new IllegalAccountStateException();
		if (balance-amount < 0) 
			throw new InsufficientFundsException();
		balance -= amount;
		return true;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
		
}
