package com.fdmgroup;

import java.util.ArrayList;

public class BankCustomer {
	private int idNumber, taxIdNumber;
	private String name, address;
	protected ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

	public BankCustomer(int idNumber, int taxIdNumber, String name, String address) {
		super();
		this.idNumber = idNumber;
		this.taxIdNumber = taxIdNumber;
		this.name = name;
		this.address = address;
	}
	
	public int getIdNumber() {
		return idNumber;
	}
	
	public int getTaxIdNumber() {
		return taxIdNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void addBankAccount(BankAccount bAccount){
		accounts.add(bAccount);
	}
	

}
