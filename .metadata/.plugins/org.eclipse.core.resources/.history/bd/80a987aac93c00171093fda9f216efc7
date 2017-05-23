package com.fdmgroup.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OE_COURSE")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "course_id")
	private int courseId;
	
	@Column
	private String title;
	
	@OneToOne
	private User teacher;
	
	@OneToMany(mappedBy = "course")
	private List<User> students;
	
	@OneToMany(mappedBy = "course")
	private List<Exam> courseExams;
	
	
	public Course() {
		super();
	}
	
	public Course(String title, User teacher) {
		super();
		this.title = title;
		this.teacher = teacher;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public List<User> getStudents() {
		return students;
	}

	public void setStudents(List<User> students) {
		this.students = students;
	}

	public List<Exam> getCourseExams() {
		return courseExams;
	}

	public void setCourseExams(List<Exam> courseExams) {
		this.courseExams = courseExams;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseId;
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
		Course other = (Course) obj;
		if (courseId != other.courseId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", teacher=" + teacher + ", students=" + students
				+ ", courseExams=" + courseExams + "]";
	}
	
	
}
