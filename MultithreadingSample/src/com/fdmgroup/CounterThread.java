package com.fdmgroup;

public class CounterThread extends Thread {
	
	private int min;
	private int max;
	private int step;
	private long sleepTime;
	private String arrow;
	

	public CounterThread(int min, int max, int step, long sleepTime, String arrow) {
		super();
		this.min = min;
		this.max = max;
		this.step = step;
		this.sleepTime = sleepTime;
		this.arrow = arrow;
	}

	@Override
	public void run() {
		for (int i = min; i <= max; i+=step) {
			System.out.println(arrow + i);
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
