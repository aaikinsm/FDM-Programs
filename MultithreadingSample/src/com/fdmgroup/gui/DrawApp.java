package com.fdmgroup.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class DrawApp extends JFrame implements Runnable{

	private static final long serialVersionUID = 1L;
	private static final String VERSION = "1.0.0";
	private boolean active = false;
	private static DrawApp da;
	
	private JTextField timeTf = new JTextField(20);
	private JButton startStopButton = new JButton("Start");
	
	DrawApp(){
		setTitle("Draw app version " + VERSION);
		init();
	}
	
	private void init(){
		Container container  = getContentPane();
		container.setLayout(new FlowLayout());
		container.add(timeTf);
		container.add(startStopButton);
		
		startStopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (startStopButton.getText().equalsIgnoreCase("Start")){
					startStopButton.setText("Stop");
					active = true;
					Thread t = new Thread(da);
					t.start();
					
					Thread t2 = new Thread(new Runnable(){
						public void run() {
							Graphics graphics = getContentPane().getGraphics();
							int x = 0;
							int y = 0;
							
							while (active){
								graphics.setColor(Color.RED);
								graphics.fillOval(x, y, 20, 20);
								try{
									Thread.sleep(40);
								}catch (InterruptedException e){
									e.printStackTrace();
								}
								graphics.clearRect(x, y, 20, 20);
								x+=1;
								y+=1;
							}
						};
					});
					t2.start();
					
					Thread t3 = new Thread(new Runnable() {
												
						@Override
						public void run() {
							Graphics graphics = getContentPane().getGraphics();
							int x = 500;
							int y = 500;
							
							while (active){
								graphics.setColor(Color.BLUE);
								graphics.fillOval(x, y, 50, 50);
								try{
									Thread.sleep(20);
								}catch (InterruptedException e){
									e.printStackTrace();
								}
								graphics.clearRect(x, y, 50, 50);
								x-=1;
								y-=1;
							}
						}
						
					});
					t3.start();
				}else{
					startStopButton.setText("Start");
					active = false;
				}
			}
		});
	}
	
	public static void main(String[] args) {
		da = new DrawApp();
		da.setSize(500,500);
		da.setVisible(true);
		da.setResizable(false);
		da.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void run() {
		while (active){
			timeTf.setText(LocalTime.now().toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
