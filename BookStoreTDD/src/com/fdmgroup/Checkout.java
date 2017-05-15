package com.fdmgroup;

import java.util.ArrayList;

public class Checkout {
	
	public static int getDiscount(ArrayList<Book> bookList) {
		int discount = 0;
		discount += bookList.size()/3;
		if (bookList.size()>=10)
			discount += 10;
		return discount;
	}

	public double calculatePrice(Basket basket) {
		double price = 0;
		for (Book book : basket.getBooksInBasket()) {
			price += book.price;
		}
		price -= getDiscount(basket.getBooksInBasket());
		return price;
	}
	
}
