package com.fdmgroup;

public class BusinessSavingsAccount extends SavingsAccount implements Bussiness{

	Company company; 
	public BusinessSavingsAccount(int id, BankCustomer customer) {
		super(id, customer);
	}

	@Override
	public void setCompany(Company c) {
		company = c;
		
	}

	@Override
	public Company getCompany() {		
		return company;
	}

}
