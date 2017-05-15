package com.fdmgroup;

public class IllegalAccountStateException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "The operation can not be done in the current state of the account" ;
	}
}
