package com.fdmgroup.race;

public class RaceApp {

	public static void main(String[] args) {
		Driver d1 = new Driver("John Frigillana", "FP-4512-1212-12", 30);
		Driver d2 = new Driver("Jennifer Leung", "JL-466-12123-12", 18);
		Driver d3 = new Driver("Shawn Xue", "SX-7432-12322-12", 30);
		Driver d4 = new Driver("Albert Mensah", "AM-7512-1892-23", 42);
		Driver d5 = new Driver("Shahab Rahimi", "SR-4517-7892-21", 50);
		
		Suv v1 = new Suv ("SUV", "Audi Q7", 9, 4);
		Suv v2 = new Suv ("Cart", "Golf Cart", 20, 8);
		Suv v3 = new Suv ("Car", "Honda Civic", 6, 4);
		Suv v4 = new Suv ("Car", "Smart", 6, 4);
		Suv v5 = new Suv ("SUV", "BMW X6", 8, 4);
		
		Race<Driver, Suv> race = new Race<>();
		race.addRacer(d1, v1);
		race.addRacer(d2, v2);
		race.addRacer(d3, v3);
		race.addRacer(d4, v4);
		race.addRacer(d5, v5);
		
		Driver winner = race.beginRace();
		System.out.println("The lucky winner is: "+winner+"  --> "+race.getVehicle(winner));
	}
}
