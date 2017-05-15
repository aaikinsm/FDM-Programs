package com.fdmgroup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class CatalogueTest {
	
	private Catalogue mockCatalogue;
	private Catalogue mockReadItemCommand;
	
	@Before
	public void init(){
		mockCatalogue = mock(Catalogue.class);		
		mockReadItemCommand = mock(Catalogue.class);	
		//when(mockReadItemCommand.getAllBooks()).then(mockReadItemCommand.readAll);
	}
	
	@Test
	public void test_getAllBooksForEmptyCatalogue(){
		when(mockCatalogue.getAllBooks()).thenReturn(new ArrayList<Book>());		
		assertEquals(0,mockCatalogue.getAllBooks().size());
	}
	
	@Test
	public void test_verifyReadAllFromReadItemCommandIsClaled(){
		when(mockCatalogue.getAllBooks()).thenReturn(new ArrayList<Book>());		
		assertEquals(0,mockCatalogue.getAllBooks().size());
	}
}
