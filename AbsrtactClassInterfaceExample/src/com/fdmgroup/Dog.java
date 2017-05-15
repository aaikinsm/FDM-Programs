package com.fdmgroup;

public class Dog extends Mammal {

	private String breed;
	
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public void hibernate() {
		System.out.println("Dogs don't hibernate");

	}

	@Override
	public void move() {
		System.out.println("Dog is moving...");
	}

	@Override
	public void eat() {
		System.out.println("Dog is moving...");
	}

	@Override
	public void makeNoise() {
		System.out.println("Dog is Barking...");		
	}

}
