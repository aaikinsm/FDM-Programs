package com.fdmgroup.controller;

import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fdmgroup.model.Calculator;

@Controller
public class HomeController {

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String showHome(Model model){
		model.addAttribute("calc", new Calculator());
		return "welcome";
	}
	
	/*@RequestMapping(value = "/calculate", method = {RequestMethod.GET, RequestMethod.POST})
	public String calc(Model model, @RequestParam int num1, @RequestParam(value="num2") int number2){
		model.addAttribute("sum", (num1+number2));
		return "result";
	}*/
	
	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String calc(Model model, @Valid @ModelAttribute("calc") Calculator calc, BindingResult br ){
		if (br.hasErrors()){
			return "welcome";
		}
		model.addAttribute("sum", calc.add());
		return "result";
	}
	
	@RequestMapping(value = "/find/{id}")
	public String getInfo(@PathVariable int id, Model model){
		if (id ==1){
			model.addAttribute("info", "User1 info");
		}
		else if (id ==2){
			model.addAttribute("info", "User2 info");
		}
		return "info";
	}
}
