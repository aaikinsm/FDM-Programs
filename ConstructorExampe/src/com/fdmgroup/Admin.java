package com.fdmgroup;

public class Admin extends User {
	
	private String lastLogin;
	

	public Admin() {
		super();
	}

	public Admin(String username, String password) {
		super(username, password);
	}

	public Admin(String username) {
		super(username);
	}
	

	public Admin(String username, String password, String lastLogin) {
		super(username, password);
		this.lastLogin = lastLogin;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Override
	public String toString() {
		return "Admin [lastLogin=" + lastLogin + ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword()
				+ "]";
	}
	
	
	
}
