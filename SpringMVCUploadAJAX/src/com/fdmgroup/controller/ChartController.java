package com.fdmgroup.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

@Controller
public class ChartController {

	Map<String, Float> marks = null;
	
	@Autowired
	private ApplicationContext context;
	
	ChartController(){
		marks = new HashMap<String, Float>();
		marks.put("Pass", 85.0F);
		marks.put("Fail", 15.0F);
	}
	
	@RequestMapping(value="/chart", method={RequestMethod.GET, RequestMethod.POST})
	public String search(Model model){
		model.addAttribute("marks", marks);
		return "chart";
	}
	
	@RequestMapping(value="/timer", method={RequestMethod.GET, RequestMethod.POST})
	public String timer(Model model){
		model.addAttribute("maxTime", 5);
		return "timer";
	}
	
	@RequestMapping(value="/page", method={RequestMethod.GET, RequestMethod.POST})
	public String page(Model model){
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		List<User> users = userDAO.findAll();
		model.addAttribute("users", users);
		return "pagination";
	}
	
	@RequestMapping(value="/pagination", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody String pagination(Model model){
		String st = "{\"data\": [" +
	    "[" + 
	      "\"Tiger Nixon\"," +
	      "\"System Architect\"," +
	      "\"Edinburgh\"," + 
	      "\"5421\"," + 
	      "\"2011/04/25\"," +
	      "\"$320,800\"" +
	    "]," +
	    "[" +
	      "\"Donna Snider\"," +
	      "\"Customer Support\"," +
	      "\"New York\"," +
	      "\"4226\"," + 
	      "\"2011/01/25\"," +
	      "\"$112,000\"" +
	    "]" +
	  "]" +
	"}\"";
		
		return st;
	}
}
