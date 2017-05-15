package com.fdmgroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortApp {

	public static void main(String[] args) {
		Book b1 = new Book("Intro to Java", "James Gosling", "Sun Microsystems", "1231-231-31245", 1, 2005, 39.95f);
		Book b2 = new Book("7 Habbits", "Frank Covey", "Personal Dev", "7331-311-31245", 2, 2015, 29.95f);
		Book b3 = new Book("Success Principles", "Canfield", "New York Pub", "1756-781-31343", 3, 2007, 89.95f);
		Book b4 = new Book("Power of Now", "Erkhatole", "Pub U of Toronto", "231-2631-3245", 4, 2004, 3.50f);
		Book b5 = new Book("Intro to Java", "James Gosling", "Sun Microsystems", "1231-231-31245", 1, 2005, 39.95f);
		
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		books.add(b4);
		
		Collections.sort(books);
		
		for (Book book : books) {
			System.out.println(book);
		}
		
		Student s1 = new Student(1, "Mary James", 88.0f );
		Student s2 = new Student(2, "Joseph Smith", 100.0f );
		Student s3 = new Student(3, "David Bowie", 45.0f );
		Student s4 = new Student(4, "John Doe", 65.0f );
		Student s5 = new Student(5, "Shahab Rahimi", 75.0f );
		
		List<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		students.add(s5);
		Collections.sort(students, StudentComparator.sortByGradeDesc);
		
		for (Student student : students) {
			System.out.println(student);
		}
	}
}
