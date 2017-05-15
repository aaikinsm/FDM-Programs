package com.fdmgroup;

public class MainApp {
	
	public static void main(String[] args) {
//		Thread.currentThread().setPriority(8);
//		Thread.currentThread().setName("Main App");
//		System.out.println(Thread.currentThread());
		
		CounterThread t1 = new CounterThread(10, 100, 2, 200, "----------->");
		CounterThread t2 = new CounterThread(100, 1000, 5, 100, "--->");
		t1.setDaemon(true); //kill thread when main thread ends
		t2.setDaemon(true);
		t1.start();
		t2.start();
		
		for (int i= 1; i<=10; i++ ){
			System.out.println("------->"+ i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		try {
			t1.join();
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
