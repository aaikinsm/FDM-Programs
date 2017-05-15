package com.fdmgroup;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringOperationTest {
		
		@Test
		public void testReverseWithMoreThanTwoChars(){
			StringOperation so = new StringOperation();
			String reversedString = so.reverse("ABCD");
			assertEquals("ABDC", reversedString);
		}
		
		@Test
		public void testReverseWithTwoChars(){
			StringOperation so = new StringOperation();
			String reversedString = so.reverse("AB");
			assertEquals("BA", reversedString);
		}

		@Test
		public void testReverseWithOneChar(){ 
			StringOperation so = new StringOperation();
			String reversedString = so.reverse("A");
			assertEquals("A", reversedString);
		}

		@Test
		public void testReverseWithNoChars(){
			StringOperation so = new StringOperation();
			String reversedString = so.reverse("");
			assertEquals("", reversedString);
		}

		@Test
		public void testReverseWithNull(){
			StringOperation so = new StringOperation();
			String reversedString = so.reverse(null);
			assertEquals(null, reversedString);
		}
}
