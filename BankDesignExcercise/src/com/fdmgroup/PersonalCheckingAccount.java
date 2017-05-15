package com.fdmgroup;

public class PersonalCheckingAccount extends CheckingAccount implements Personal {

	private Person person;
	
	public PersonalCheckingAccount(int id, int firstCheck, BankCustomer customer) {
		super(id, firstCheck, customer);
	}

	@Override
	public void setPerson(Person person) {
		this.person = person;

	}

	@Override
	public Person getPerson() {
		return person;
	}

}
