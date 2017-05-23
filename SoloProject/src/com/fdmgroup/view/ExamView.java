package com.fdmgroup.view;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class ExamView extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public JLabel eTitle, eTimer, qCount; 
	public JTextArea qText; 
	public Button button;
	public CheckboxGroup selections;
	
	public ExamView(String title){
		eTitle = new JLabel(title);
		eTimer = new JLabel();
		qCount = new JLabel();
		qText = new JTextArea();
		button = new Button("START");

		qText.setWrapStyleWord(true);
		qText.setLineWrap(true);
		
		this.setTitle(title);
		this.setSize(500,300);
		init();
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void init(){
		
		selections = new CheckboxGroup();
		Checkbox cbA = new Checkbox("a"); 
		cbA.setCheckboxGroup(selections);
		Checkbox cbB = new Checkbox("b"); 
		cbB.setCheckboxGroup(selections);
		Checkbox cbC = new Checkbox("c"); 
		cbC.setCheckboxGroup(selections);
		Checkbox cbD = new Checkbox("d");
		cbA.setState(true);
		cbD.setCheckboxGroup(selections);
		
		
		Container container  = getContentPane();
		container.setLayout(new BoxLayout(container,BoxLayout.PAGE_AXIS));
		Container innerContainer2  = new Container();
		Container innerContainer  = new Container();
		innerContainer.setLayout(new FlowLayout());
		innerContainer2.setLayout(new GridLayout(0,2));
		container.add(innerContainer2);
		innerContainer2.add(eTitle);
		innerContainer2.add(qCount);
		innerContainer2.add(eTimer);
		container.add(qText);
		container.add(innerContainer);
		innerContainer.add(cbA);
		innerContainer.add(cbB);
		innerContainer.add(cbC);
		innerContainer.add(cbD);
		container.add(button);
		
	}
	
}
