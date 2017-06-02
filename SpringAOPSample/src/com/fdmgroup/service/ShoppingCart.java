package com.fdmgroup.service;

import org.springframework.stereotype.Component;
@Component
public class ShoppingCart {

	public void addItem (String name, int quantity){
		System.out.println(quantity+" "+name+" added to the cart.");
	}

	public void removeItem (String name){
		System.out.println(name+" removed from the cart.");
	}

	public void empty () throws Exception{
		System.out.println("The cart is empty.");
		throw new Exception("Shopping Cart Exception..");
	}
	
	public Integer loop(){
		int sum = 0;
		for (int i = 0; i < 11; i++) {
			sum+= i;
			System.out.print(i+", ");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return sum;
	}
}
