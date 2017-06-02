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
	@NamedQuery(name = "exam.findAll", query = "Select e from Exam e"),
	@NamedQuery(name = "exam.findByCourse", query = "Select e from Exam e where e.course = :ecourse"),
	@NamedQuery(name = "exam.findAllByCreator", query = "Select e from Exam e where e.creator = :ecreator")
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
	
	@Column(name = "is_randomized")
	private int isRandomized;
	
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private User creator;
	
	@OneToMany(mappedBy = "exam")
	private List<Question> questions;
	
	@OneToMany(mappedBy = "exam")
	private List<Result> results;
	
	@ManyToOne
	private Course course;
	
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

	public Exam(int timer, String title, int isRandomized, User creator) {
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

	public Question getNextQuestion() {
		currentIndex++;
		if (currentIndex >= questions.size())
			return null;
		else
			return (questions.get(currentIndex));
	}

	public void randomize() {
		if (isRandomized==1) {
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

	public void setDeleted(int state) {
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

	public int isRandomized() {
		return isRandomized;
	}

	public void setRandomized(int isRandomized) {
		this.isRandomized = isRandomized;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public int isDeleted() {
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
	
	
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", timer=" + timer + ", title=" + title + ", isRandomized=" + isRandomized
				+ ", isDeleted=" + isDeleted + ", questions=" + questions + ", creator=" + creator + ", results="
				+ results + ", course=" + course + ", currentIndex=" + currentIndex + "]";
	}
	
	
}
