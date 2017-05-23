package com.fdmgroup.model;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.fdmgroup.view.ExamView;

public class TimerThread extends Thread{

	int duration = 0;
	ExamView view;
	public boolean stop = false;

	public TimerThread(int duration, ExamView view) {
		super();
		this.duration = duration;
		this.view = view;
	}
	
	@Override
	public void run() {
		super.run();
		for (int i = duration; i >= 0; i--) {			
			if (stop) break;
			view.eTimer.setText(""+i);
			if (i == 0)
				System.out.println("Time is up");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
