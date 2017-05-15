package com.fdmgroup;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class MainApp {

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
		
		for (Book book : books) {
			System.out.println(book);
		}
		
		System.out.println("-----------");
		
		System.out.println(books.get(2));
		books.remove(b5);
		
		System.out.println("-----------");
		
		for (Book book : books) {
			System.out.println(book);
		}
		
		System.out.println("-----------");
		
		System.out.println("Does books list have b5? "+books.contains(b5));
		System.out.println("Element index of b5 "+books.indexOf(b5));
		
		System.out.println("-----------");
		
		Map<String, String> dictionary = new Hashtable<>();
		dictionary.put("Apple", "A kind of friut and a name of a company");
		dictionary.put("Table", "A kind of urniture and a place to hold data");
		dictionary.put("Chair", "A kind of furniture to sit on");
		
		dictionary.put("Apple", "Is a fruit");
		
		Set<String> keys = dictionary.keySet();
		for (String key : keys) {
			System.out.println(key + " --> "+ dictionary.get(key));
		}

		System.out.println("-----------");
		
		if (dictionary.containsKey("Chair")){
			System.out.println("The meaninig of chair is: "+ dictionary.get("Chair"));
		}
		else {
			System.out.println("Word not found");
		}
	}

}
