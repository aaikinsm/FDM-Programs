package com.fdmgroup;

public class BusinessCheckingAccount extends CheckingAccount implements Bussiness {

	private Company company;
	
	public BusinessCheckingAccount(int id, int firstCheck, BankCustomer customer) {
		super(id, firstCheck, customer);
	}

	@Override
	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public Company getCompany() {
		return company;
	}

}
