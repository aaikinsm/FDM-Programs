package com.fdmgroup.view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class CreateExamView extends JFrame{


	private static final long serialVersionUID = 1L;
	
	public JLabel heading;
	public JTextField questionText;
	public JTextField ans1;
	public JTextField ans2;
	public JTextField ans3;
	public JTextField ans4;
	public JTextField title;
	public JTextField time;
	public JButton addQButton;
	public JButton doneButton;
	public Checkbox randomized;
	public CheckboxGroup selections;
	
	public CreateExamView(){
		this.setSize(500,300);
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void init() {
		heading = new JLabel("Enter the exam information below.");
		questionText = new JTextField();
		ans1 = new JTextField();
		ans2 = new JTextField();
		ans3 = new JTextField();
		ans4 = new JTextField();
		title = new JTextField("Enter Exam Title Here");
		time = new JTextField("60");
		randomized = new Checkbox("Randomize Questions");
		Checkbox selectA = new Checkbox("A is Correct");
		Checkbox selectB = new Checkbox("B is Correct");
		Checkbox selectC = new Checkbox("C is Correct");
		Checkbox selectD = new Checkbox("D is Correct");
		addQButton = new JButton("Add another question");
		doneButton = new JButton("DONE");
		
		selections = new CheckboxGroup();
		selectA.setCheckboxGroup(selections);
		selectB.setCheckboxGroup(selections);
		selectC.setCheckboxGroup(selections);
		selectD.setCheckboxGroup(selections);
		
		Container container  = getContentPane();
		container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
		Container innerContainerQ = new Container();
		Container innerContainerA = new Container();
		Container innerContainerB = new Container();
		Container innerContainerC = new Container();
		Container innerContainerD = new Container();
		Container innerContainerInfo = new Container();
		innerContainerQ.setLayout(new BorderLayout());
		innerContainerA.setLayout(new BorderLayout());
		innerContainerB.setLayout(new BorderLayout());
		innerContainerC.setLayout(new BorderLayout());
		innerContainerD.setLayout(new BorderLayout());
		innerContainerInfo.setLayout(new BorderLayout());
		
		container.add(heading);
		innerContainerQ.add(new JLabel(" Question:   "), BorderLayout.LINE_START);
		innerContainerQ.add(questionText, BorderLayout.CENTER);
		innerContainerA.add(new JLabel(" Answer (a):  "), BorderLayout.LINE_START);
		innerContainerA.add(ans1, BorderLayout.CENTER);
		innerContainerA.add(selectA, BorderLayout.LINE_END);
		innerContainerB.add(new JLabel(" Answer (b):  "), BorderLayout.LINE_START);
		innerContainerB.add(ans2, BorderLayout.CENTER);
		innerContainerB.add(selectB, BorderLayout.LINE_END);
		innerContainerC.add(new JLabel(" Answer (c):  "), BorderLayout.LINE_START);
		innerContainerC.add(ans3, BorderLayout.CENTER);
		innerContainerC.add(selectC, BorderLayout.LINE_END);
		innerContainerD.add(new JLabel(" Answer (d):  "), BorderLayout.LINE_START);
		innerContainerD.add(ans4, BorderLayout.CENTER);
		innerContainerD.add(selectD, BorderLayout.LINE_END);
		container.add(innerContainerQ);
		container.add(innerContainerA);
		container.add(innerContainerB);
		container.add(innerContainerC);
		container.add(innerContainerD);
		container.add(addQButton);
		container.add(innerContainerInfo);
		innerContainerInfo.add(title, BorderLayout.PAGE_START);
		innerContainerInfo.add(new JLabel("Exam Duration (Seconds):"), BorderLayout.LINE_START);
		innerContainerInfo.add(time, BorderLayout.CENTER);
		innerContainerInfo.add(randomized, BorderLayout.LINE_END);
		innerContainerInfo.add(doneButton, BorderLayout.PAGE_END);
		
	}
	
	
	
}
