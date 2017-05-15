package com.fdmgroup.model;

import java.util.ArrayList;

public class Result {

	private int resultId;
	private Exam exam;
	private User user;
	private ArrayList<Boolean> resultData = new ArrayList<>();
	private int passMark = 50;

	public Result(int resultId, Exam exam, User user) {
		super();
		this.resultId = resultId;
		this.exam = exam;
		this.user = user;
	}

	public int getResultId() {
		return resultId;
	}

	public User getUser() {
		return user;
	}

	public ArrayList<Boolean> getResultData() {
		return resultData;
	}

	public void addResultData(boolean resultData) {
		this.resultData.add(resultData);
	}

	public Exam getExam() {
		return exam;
	}
	
	public void setPassMark(int pass){
		passMark = pass;
	}
	
	public float calculateResult(){
		float mark = 0;
		for (Boolean ans : resultData) {
			if (ans == true)
				mark++;
		}
		return mark/resultData.size()*100;
	}
	
	public boolean passed(){
		if (calculateResult()>=passMark)
			return true;
		else
			return false;
	}

}
