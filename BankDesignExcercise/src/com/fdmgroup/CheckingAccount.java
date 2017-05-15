package com.fdmgroup;

public class CheckingAccount extends BankAccount{

	private int nextCheck;
	private BankCustomer customer;
	
	public CheckingAccount(int id, int firstCheck, BankCustomer customer) {
		super(id);
		nextCheck = firstCheck;
		this.customer = customer;
	}

	@Override
	public boolean withdraw (int amount){
		if (amount < 0)
			return false;
		balance -= amount;
		return true;
	}
	
	@Override
	public boolean deposit(int amount) {
			if (amount < 0)
				return false;
			balance += amount;
			return true;
	}

	public void nextCheck(){
		nextCheck++;
	}
}
