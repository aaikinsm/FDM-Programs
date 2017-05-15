package com.fdmgroup;

public class MainApp {
	public static void main(String[] args) {
		FilingCabinet fc = FilingCabinet.getInstance();
		System.out.println(fc.getCount());
		
		FilingCabinet fc2 = FilingCabinet.getInstance();
		System.out.println(fc2.getCount());
		System.out.println(fc.getCount());
	}
}
