package com.fdmgroup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

@Controller
public class SearchController {

	@Autowired
	private ApplicationContext context;
	
	SearchController() {
	}
	
	@RequestMapping(value="/showSearch", method={RequestMethod.GET, RequestMethod.POST})
	public String search(){
		return "search";
	}
	
	@RequestMapping(value="/search", method={RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody List<User> search(@RequestParam String query){
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		List<User> users = userDAO.findUserByNameAndCompany(query);

		return users;
	}
}
