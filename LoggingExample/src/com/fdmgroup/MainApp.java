package com.fdmgroup;

public class MainApp {

	public static void main(String[] args) {
		Arithmetic ar = new Arithmetic();
		System.out.println(ar.add(14, 26));
		System.out.println(ar.sub(37, 47));
		System.out.println(ar.mul(21, 11));
		System.out.println(ar.div(72, 0));
	}
}
