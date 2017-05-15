package com.fdmgroup;
import static org.junit.Assert.*;

import org.junit.Test;
public class ArithmeticTest {

	@Test
	public void testAdd(){
		Arithmetic ar = new Arithmetic();
		assertEquals(45, ar.add(15,30));
	}
}
