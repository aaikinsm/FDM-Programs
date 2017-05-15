package com.fdmgroup.model;

public class SessionUser {

	private static User loggedInUser;

	public static User getLoggedInUser() {
		return loggedInUser;
	}

	public static void setLoggedInUser(User user) {
		loggedInUser = user;
	}
	
}
