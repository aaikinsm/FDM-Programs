package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "OE_RESULT")
@NamedQueries({
	@NamedQuery(name = "result.findExamResults", query = "Select r from Result r where r.exam = :rexam"),
	@NamedQuery(name = "result.findUserResults", query = "Select r from Result r where r.user = :ruser")
})
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "result_id")
	private int resultId;
	
	@Column
	private int passMark = 50;
	
	@Column
	private int correct = 0;
	
	@Column
	private int total = 0;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Exam exam;

	
	public Result() {
		super();
	}

	public Result(Exam exam, User user) {
		super();
		this.exam = exam;
		this.user = user;
	}

	public int getResultId() {
		return resultId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addResultData(boolean resultData) {
		if(resultData)
			correct++;
		total++;
	}

	public Exam getExam() {
		return exam;
	}
	
	public void setPassMark(int pass){
		passMark = pass;
	}
	
	public int calculateResult(){
		return correct*100/total;
	}
	
	public boolean passed(){
		if (calculateResult()>=passMark)
			return true;
		else
			return false;
	}

	public int getCorrect() {
		return correct;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int numOfQuestions) {
		total = numOfQuestions;
	}

}
