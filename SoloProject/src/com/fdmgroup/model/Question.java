package com.fdmgroup.model;

import java.util.ArrayList;

import javax.persistence.Embeddable;

@Embeddable
public class Question {
	
	private String question;
	private ArrayList<String> possibleAnswers;
	private String correctAnswer;
	private String note;
	
	public Question(String question) {
		super();
		this.question = question;
		possibleAnswers = new ArrayList<String>();
	}

	public String getQuestion() {
		String q = question;
		for (String string : possibleAnswers) {
			q += "\n\t ("+string;
		}
		return q;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public void addPossibleAnswer(String ans){
		possibleAnswers.add(ans);
	}
}