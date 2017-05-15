package com.fdmgroup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "OE_EXAM")
@NamedQueries({
	@NamedQuery(name = "exam.findAll", query = "Select e from Exam e")
})
public class Exam implements IStorable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "exam_id")
	private int id;	
	
	@Column
	private int timer;
	
	@Column
	private String title;
	
	@Column
	private boolean isRandomized;
	
	@Column
	private boolean isDeleted;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User creator;
	
	@Embedded
	private List<Question> questions;
	//@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	//private List<Result> results;
	
	@Transient
	private int currentIndex = -1;

	public Exam() {
		super();
	}

	public Exam(User creator) {
		super();
		this.creator = creator;
		timer = 60;
		title = "";
		questions = new ArrayList<>();
	}

	public Exam(int timer, String title, boolean isRandomized, User creator) {
		super();
		this.timer = timer;
		this.title = title;
		this.isRandomized = isRandomized;
		this.creator = creator;
		questions = new ArrayList<>();
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public int getNumOfQuestions(){
		return questions.size();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}

	public void removeQuestion(Question q) {
		questions.remove(q);
	}

	public void randomize() {
		if (isRandomized) {
			ArrayList<Question> randQuestions = new ArrayList<>();
			int size = questions.size();
			for (int i = 0; i < size; i++) {
				int num = (int) (Math.random() * questions.size());
				randQuestions.add(questions.get(num));
				questions.remove(num);
			}
			questions = randQuestions;
		}
	}

	public Question getNextQuestion() {
		currentIndex++;
		if (currentIndex >= questions.size())
			return null;
		else
			return (questions.get(currentIndex));
	}

	public void setDeleted(boolean state) {
		isDeleted = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public boolean isRandomized() {
		return isRandomized;
	}

	public void setRandomized(boolean isRandomized) {
		this.isRandomized = isRandomized;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exam other = (Exam) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	/*public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}*/
}
