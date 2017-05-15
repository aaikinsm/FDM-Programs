package com.fdmgroup;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class PointOperationTest {
	private static Point p1 = null, p2=null;
	private static PointOperation po;
	
	@BeforeClass
	public static void setup(){
		po = new PointOperation();
	}

	@Test
	public void testCalculateDistance(){
		double d = po.calculateDistance(new Point(14,45),new Point(114,200));
		assertEquals (184.4586, d, 0.001);
	}
	
	@Test
	public void testCalculateDistanceWithNegativeValue(){
		double d = po.calculateDistance(new Point(-54,-7), new Point(114,200));
		assertEquals (0, d, 0.001);
	}
	
	@Test
	public void testCalculateDistanceWithNullValue(){
		double d = po.calculateDistance(null, new Point(114,200));
		assertEquals (0, d, 0.001);
	}
	
	@Test
	public void testDiv(){
		double rVal = po.div(12,4);
		assertEquals(3.0, rVal, 0.001);
	}

	@Test  (expected = ArithmeticException.class)
	public void testDivWithZeroDivider(){
		po.div(12,0);
	}
}
