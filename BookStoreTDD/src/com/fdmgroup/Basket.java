package com.fdmgroup;

import java.util.ArrayList;

public class Basket {

	private ArrayList <Book> books = new ArrayList<Book>();
	
	public ArrayList<Book> getBooksInBasket() {
		return books;
	}
	
	public void addBookToBasket(Book book){
		books.add(book);
	}

}
