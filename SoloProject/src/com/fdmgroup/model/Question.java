package com.fdmgroup.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "OE_QUESTION")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "question_id")
	private int id;

	@Column
	private String question;

	@Column
	private String correctAnswer;

	@Column
	private String note;

	@Column
	private String possibleAnswer1 = "";

	@Column
	private String possibleAnswer2 = "";

	@Column
	private String possibleAnswer3 = "";

	@Column
	private String possibleAnswer4 = "";

	@Transient
	private ArrayList<String> possibleAnswers;

	@ManyToOne
	private Exam exam;

	public Question() {
		super();
		possibleAnswers = new ArrayList<String>();
	}

	public Question(String question) {
		super();
		this.question = question;
		possibleAnswers = new ArrayList<String>();
	}

	public String getQuestion() {
		loadPossibleAnswers();
		String q = "\n"+question+"\n";
		for (String string : possibleAnswers) {
			q += "\n\t ("+(char)(65+possibleAnswers.indexOf(string))+ ") " + string;
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

	public void addPossibleAnswer(String ans) {
		possibleAnswers.add(ans);
		savePossibleAnswers();
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public void savePossibleAnswers() {
		if (possibleAnswers.size() > 0)
			possibleAnswer1 = possibleAnswers.get(0);

		if (possibleAnswers.size() > 1)
			possibleAnswer2 = possibleAnswers.get(1);

		if (possibleAnswers.size() > 2)
			possibleAnswer3 = possibleAnswers.get(2);

		if (possibleAnswers.size() > 3)
			possibleAnswer4 = possibleAnswers.get(3);
	}

	public void loadPossibleAnswers() {
		if (possibleAnswers.isEmpty()) {
			if (possibleAnswer1 != null && !possibleAnswer1.isEmpty())
				possibleAnswers.add(possibleAnswer1);
			if (possibleAnswer2 != null && !possibleAnswer2.isEmpty())
				possibleAnswers.add(possibleAnswer2);
			if (possibleAnswer3 != null && !possibleAnswer3.isEmpty())
				possibleAnswers.add(possibleAnswer3);
			if (possibleAnswer4 != null && !possibleAnswer4.isEmpty())
				possibleAnswers.add(possibleAnswer4);
		}
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", correctAnswer=" + correctAnswer + ", note=" + note
				+ ", possibleAnswer1=" + possibleAnswer1 + ", possibleAnswer2=" + possibleAnswer2 + ", possibleAnswer3="
				+ possibleAnswer3 + ", possibleAnswer4=" + possibleAnswer4 + ", possibleAnswers=" + possibleAnswers
				+ ", exam=" + exam + "]";
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
		Question other = (Question) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
