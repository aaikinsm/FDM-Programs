package com.fdmgroup;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CheckoutTest {
	
	Checkout checkout;
	@Before
	public void init(){
		checkout = new Checkout();
	}
			 
	@Test
	public void test_calculatePriceReturnsDoubleWithEmptyBasket(){
		Object price = checkout.calculatePrice(new Basket());
		assertEquals(0.0, price);
	}
	
	@Test
	public void test_calculatePriceReturnsWithOneBook(){
		Basket basket = new Basket();
		basket.addBookToBasket(new Book(34.99));
		Object price = checkout.calculatePrice(basket);
		assertEquals(34.99, price);
	}
	
	@Test
	public void test_calculatePriceReturnsWithTwoBooks(){
		Basket basket = new Basket();
		basket.addBookToBasket(new Book(5.00));
		basket.addBookToBasket(new Book(7.89));
		Object price = checkout.calculatePrice(basket);
		assertEquals(12.89, price);
	}
	
	@Test
	public void test_calculatePriceReturnsWithSevenBooks(){
		Basket basket = new Basket();
		for (int i = 0; i< 7; i++){
			basket.addBookToBasket(new Book(5.00));
		}
		Object price = checkout.calculatePrice(basket);
		assertEquals(33.00, price);
	}
	
	@Test
	public void test_calculatePriceReturnsWithTenBooks(){
		Basket basket = new Basket();
		for (int i = 0; i< 10; i++){
			basket.addBookToBasket(new Book(5.00));
		}
		Object price = checkout.calculatePrice(basket);
		assertEquals(37.00, price);
	}
}
