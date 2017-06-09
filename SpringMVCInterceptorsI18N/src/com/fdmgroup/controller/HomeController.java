package com.fdmgroup.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fdmgroup.entity.Calculator;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	@RequestMapping(value = "/showCalc", method = {RequestMethod.GET})
	public String showCalc(Model model){
		model.addAttribute("calculator", new Calculator());
		return "form";
	}
	
	@RequestMapping(value = "/calc", method = {RequestMethod.GET})
	public String calculate(Calculator calculator, HttpServletResponse response){
		calculator.setSum(calculator.getNum1() + calculator.getNum2());
		return "calculate";
	}
}
