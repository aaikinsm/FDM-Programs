package com.fdmgroup.service;

import java.util.Random;

public class GreetFactory {

	private static final String GREET = "GREET";
	
	public static GreetService create(String language, String message) {
		if (language.equals(GREET)){
			Random r = new Random();
			GreetService gs = new GreetService();
			gs.setMessage(message);
			gs.setNumber(r.nextInt(1000));
			return gs;
		}else
			return null;
	}
}
