package com.fdmgroup;

public class StringOperation {

	public String reverse(String input) {
		
		if (input == null || input.length() == 1 || input.isEmpty())
			return input;
		
		byte[] bytes = input.getBytes();
		byte temp = bytes[input.length() - 2];
		bytes[input.length() - 2] = bytes[input.length() - 1];
		bytes[input.length() - 1] = temp;
		
		return new String(bytes);
	}

}
