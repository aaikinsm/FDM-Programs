package com.fdmgroup.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Calculator {

	@NotNull
	@Digits(integer = 6, fraction = 0)
	private BigDecimal num1;
	
	@NotNull
	@Digits(integer = 6, fraction = 0)
	private BigDecimal num2;

	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculator(BigDecimal num1, BigDecimal num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "Calculator [num1=" + num1 + ", num2=" + num2 + "]";
	}

	public BigDecimal getNum1() {
		return num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	public BigDecimal getNum2() {
		return num2;
	}

	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}
	
	public Integer add(){
		return num1.intValue() + num2.intValue();
	}
}
