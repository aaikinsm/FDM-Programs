package com.fdmgroup;

public class SavingsAccount extends BankAccount{

	private int interestRate = 0;
	private BankCustomer customer;
	
	public SavingsAccount(int id, BankCustomer customer) {
		super(id);
		this.customer = customer;
	}

	public int getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(int interestRate) {
		this.interestRate = interestRate;
	}
	
	@Override
	public boolean withdraw (int amount){
		if (amount < 0 || balance-amount < 0 )
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
	
}
