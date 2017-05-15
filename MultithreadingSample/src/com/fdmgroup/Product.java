package com.fdmgroup;

import java.util.Scanner;

public class Product {

	public void produce() throws InterruptedException{
		System.out.println("Inside produce...");
		synchronized (this){
			wait();
			System.out.println("After wait...");
		}
	}

	public void consume(){
		Scanner scanner = new Scanner(System.in);
		try {
			Thread.sleep(2000);
			System.out.println("Insde consumer ..press enter");
			scanner.nextLine();
			synchronized (this){
				notify();
				System.out.println("After Notify..");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Product pr = new Product();
		
		Thread producer = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					pr.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumer = new Thread (new Runnable() {
			
			@Override
			public void run() {
				pr.consume();
			}
		});
		
		producer.start();
		consumer.start();
	}
}
