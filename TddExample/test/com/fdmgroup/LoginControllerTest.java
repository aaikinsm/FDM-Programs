package com.fdmgroup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class LoginControllerTest {

	private View mockedView;
	private Validator mockedValidator;
	private LoginController lc;
	
	@Before
	public void init(){
		mockedView = mock(View.class);
		mockedValidator = mock(Validator.class);
		lc = new LoginController(mockedView, mockedValidator);
		when(mockedView.getUserInput()).thenReturn("Test");
	}
	
	@Test
	public void testLoginControllerCallsGetUserInput(){
		lc.handle();
		verify(mockedView, atLeast(1)).getUserInput();
	}
	
	@Test
	public void testLoginControllerCallsValidator(){
		lc.handle();
		verify(mockedValidator, times(1)).validate("Test");
	}

	@Test
	public void testLoginControllerOrder(){
		lc.handle();
		InOrder inOrderView = inOrder(mockedView);
		InOrder inOrderValidator = inOrder(mockedValidator);
		inOrderView.verify(mockedView).getUserInput();
		inOrderValidator.verify(mockedValidator).validate("Test");
	}
}
