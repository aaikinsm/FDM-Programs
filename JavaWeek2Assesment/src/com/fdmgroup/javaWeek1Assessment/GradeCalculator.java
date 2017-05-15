package com.fdmgroup.javaWeek1Assessment;

public class GradeCalculator {

	public String getClassification(double mark) {
		if(mark < 75)
			return "fail";
		else if(mark >= 75 && mark < 80)
			return "pass";
		else if ( mark >= 80 && mark < 90)
			return "merit";
		else 
			return "distinction";
	}

}
