package com.fdmgroup;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class BasketTest {
	
	private Basket basket;
	
	@Before
	public void init(){
		basket = new Basket();
	}

	@Test
	public void test_GetBooksInBasketIfEmptyBasket(){
		ArrayList <Book> bookList = basket.getBooksInBasket();
		assertEquals(true,bookList.isEmpty());
	}
	
	@Test
	public void test_GetBooksInBasketIf1BookInBasket(){
		basket.addBookToBasket(new Book(7.99));
		ArrayList <Book> bookList = basket.getBooksInBasket();		
		assertEquals(1,bookList.size());
	}

	@Test
	public void test_GetBooksInBasketIf2BooksInBasket(){
		basket.addBookToBasket(new Book(29.45));
		basket.addBookToBasket(new Book(12.98));
		ArrayList <Book> bookList = basket.getBooksInBasket();		
		assertEquals(2,bookList.size());
	}
	
	@Test
	public void test_checkOut6BooksGetDiscount(){
		for (int i = 0; i< 6; i++){
			basket.addBookToBasket(new Book(5.99));
		}
		ArrayList <Book> bookList = basket.getBooksInBasket();
		int discount = Checkout.getDiscount(bookList);
		assertEquals(2,discount);
	}

	@Test
	public void test_checkOut9BooksGetDiscount(){
		for (int i = 0; i< 9; i++){
			basket.addBookToBasket(new Book(3.56));
		}
		ArrayList <Book> bookList = basket.getBooksInBasket();
		int discount = Checkout.getDiscount(bookList);
		assertEquals(3,discount);
	}
	
	@Test
	public void test_checkOut12BooksGetDiscount(){
		for (int i = 0; i< 12; i++){
			basket.addBookToBasket(new Book(8.49));
		}
		ArrayList <Book> bookList = basket.getBooksInBasket();
		int discount = Checkout.getDiscount(bookList);
		assertEquals(14,discount);
	}
	
	@Test
	public void test_checkOut21BooksGetDiscount(){
		for (int i = 0; i< 21; i++){
			basket.addBookToBasket(new Book(34.99));
		}
		ArrayList <Book> bookList = basket.getBooksInBasket();
		int discount = Checkout.getDiscount(bookList);
		assertEquals(17,discount);
	}
}
