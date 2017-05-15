package com.fdmgroup;

import java.util.LinkedList;
import java.util.Random;

public class ProducerConsumer {

	private LinkedList<Integer> numbers = new LinkedList<>();
	private Object lock = new Object();
	private final int CAPACITY = 10;
	private Random random = new Random();
	
	public void produce() throws InterruptedException{
		while (true){
			synchronized (lock) {
				if(numbers.size() == CAPACITY){
					lock.wait();
				}
				numbers.add((random.nextInt(100)));
				lock.notify();
			}
			Thread.sleep(100);
		}
	}
	
	public void consume() throws InterruptedException{
		while (true){
			synchronized (lock) {
				if (numbers.isEmpty()){
					lock.wait();
				}
				
				System.out.println(numbers.size() + "  -->  "+numbers.removeFirst());
				lock.notify();
			}
		}
	}
	
	public static void main(String[] args) {
		ProducerConsumer pc = new ProducerConsumer();
		
		Thread producer = new Thread( new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});

		Thread consumer = new Thread( new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		
		producer.start();
		consumer.start();
	}
}
