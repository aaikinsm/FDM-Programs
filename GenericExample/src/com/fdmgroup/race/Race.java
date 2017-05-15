package com.fdmgroup.race;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Race<D extends Driver,V extends Vehicle & AllWheelDrive & Comparable<? super Suv>> {

	private List<D> drivers;
	private Map<D, V> racers;
	
	public Race() {
		super();
		drivers = new ArrayList<>();
		racers = new HashMap<>();
	}
	
	public void addRacer (D driver, V vehicle){
		drivers.add(driver);
		racers.put(driver, vehicle);
	}
	
	public D beginRace(){
		System.out.println("Racing.....");
		Random random = new Random();
		return drivers.get(random.nextInt(drivers.size()));
	}
	
	public V getVehicle (D driver){
		return racers.get(driver);
	}
}
