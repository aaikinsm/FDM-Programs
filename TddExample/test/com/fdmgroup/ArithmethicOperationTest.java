package com.fdmgroup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ArithmethicOperationTest {

	@Mock
	private ArithmethicOperation mockedArithmeticOperation;
	
	@Spy
	private ArithmethicOperation spyArithmeticOperation;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		//spyArithmeticOperation = spy(ArithmethicOperation.class);
		
		when(mockedArithmeticOperation.add(10, 20)).thenReturn(30);
		when(mockedArithmeticOperation.add(25, 35)).thenReturn(60);
		when(mockedArithmeticOperation.add(7, 49)).thenReturn(56);
		
		when(mockedArithmeticOperation.div(45, 9)).thenReturn(5);
		when(mockedArithmeticOperation.div(anyInt(), eq(0))).thenThrow(ArithmeticException.class);
		
		when(spyArithmeticOperation.add(10, 20)).thenReturn(30);
		when(spyArithmeticOperation.add(25, 35)).thenReturn(60);
		when(spyArithmeticOperation.add(7, 49)).thenReturn(100);
		
	}
	
	@Test
	public void testAdd(){
		assertEquals(30, mockedArithmeticOperation.add(10, 20));
		assertEquals(60, mockedArithmeticOperation.add(25, 35));
		assertEquals(56, mockedArithmeticOperation.add(7, 49));
		assertEquals(100, spyArithmeticOperation.add(7, 49));
	}

	@Test 
	public void testDiv(){
		assertEquals(5, mockedArithmeticOperation.div(45, 9));
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivWithZero(){
		assertEquals(5, mockedArithmeticOperation.div(45, 0));
	}
	
	@Test
	public void testOrder(){
		InOrder io = inOrder(mockedArithmeticOperation);
		mockedArithmeticOperation.div(10, 15);
		mockedArithmeticOperation.add(7, 11);
		mockedArithmeticOperation.add(9, 45);
		
		io.verify(mockedArithmeticOperation).div(10, 15);
		io.verify(mockedArithmeticOperation).add(7, 11);
		io.verify(mockedArithmeticOperation).add(9, 45);		
	}
}
