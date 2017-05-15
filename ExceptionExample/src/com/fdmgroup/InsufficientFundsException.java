package com.fdmgroup;

public class InsufficientFundsException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "There are not enough funds to complete the operation";
	}

}
