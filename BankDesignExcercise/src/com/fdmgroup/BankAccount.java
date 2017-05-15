package com.fdmgroup;

public abstract class BankAccount {
	private int idNumber; 
	protected double balance;
	
	public BankAccount(int id){
		idNumber = id;
	}

	public double getBalance() {
		return balance;
	}
	
	public void correction(int balance) {
		this.balance = balance;
	}
	
	public abstract boolean deposit(int amount);
	
	public abstract boolean withdraw (int amount);
}
