package com.fdmgroup;

public class Cat extends Mammal{

	@Override
	public void hibernate() {
		System.out.println("Cats don't hibernate");

	}

	@Override
	public void move() {
		System.out.println("Cat is moving...");
	}

	@Override
	public void eat() {
		System.out.println("Cat is moving...");
	}

	@Override
	public void makeNoise() {
		System.out.println("Cat is meowing...");		
	}
}
