package com.fdmgroup.javaWeek1Assessment;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class GradeCalculatorTest {

	private GradeCalculator calc;
	
	@Before
	public void setup(){
		calc = new GradeCalculator();
	}
	
	@Test
	public void test_GetClassification_ReturnsStringFail_IfInputDoubleIsLessThan75() {
		double mark = 70.0;
		String result = calc.getClassification(mark);
		assertEquals("fail", result);
	}
	
	@Test
	public void test_GetClassification_ReturnsStringPass_IfInputDoubleIsGreaterThanOrEqualTo75AndLessThan80() {
		double mark = 76;
		String result = calc.getClassification(mark);
		assertEquals("pass", result);
	}
	
	@Test
	public void test_GetClassification_ReturnsStringMerit_IfInputDoubleIsGreaterThanOrEqualTo80AndLessThan90() {
		double mark = 82;
		String result = calc.getClassification(mark);
		assertEquals("merit", result);
	}
	
	@Test
	public void test_GetClassification_ReturnsStringDistinction_IfInputDoubleIsGreaterThanOrEqualTo90() {
		double mark = 92;
		String result = calc.getClassification(mark);
		assertEquals("distinction", result);
	}
}
