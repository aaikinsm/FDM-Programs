package com.fdmgroup;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getId() - o2.getId();
	}
	
	public static Comparator<Student> sortByIdDesc = new Comparator<Student>() {

		@Override
		public int compare(Student o1, Student o2) {
			return o2.getId() - o1.getId();
		}
	};
	
	public static Comparator<Student> sortByGradeAsc = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			return (int) (o1.getGrade() - o2.getGrade());
		}
	};
	
	public static Comparator<Student> sortByGradeDesc = new Comparator<Student>() {
		
		@Override
		public int compare(Student o1, Student o2) {
			return (int) (o2.getGrade() - o1.getGrade());
		}
	};

}
