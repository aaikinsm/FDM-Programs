package com.fdmgroup;

public class PersonalSavingsAccount extends SavingsAccount implements Personal {

	Person person;
	public PersonalSavingsAccount(int id, BankCustomer customer) {
		super(id, customer);
	}

	@Override
	public void setPerson(Person p) {
		person = p;

	}

	@Override
	public Person getPerson() {
		return person;
	}

}
