package com.fdmgroup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.entity.User;

@SessionAttributes(value={"user"}, types={User.class})
@Controller
public class AuthenticationController {
	
	@Autowired
	private ApplicationContext context;
	
	@RequestMapping(value="/login", method = {RequestMethod.GET})
	public String login(Model model){
		User user = new User();
		model.addAttribute("user", user);
		
		return "login";
	}
	
	@RequestMapping(value="/processLogin", method = {RequestMethod.POST, RequestMethod.GET})
	public String processLogin(Model model, @Valid User user, BindingResult br){
		
		if (br.hasErrors())
			return "login";
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User retrievedUser = userDAO.getUserByUsername(user.getUsername());
		if (retrievedUser != null){
			if (retrievedUser.getPassword().equals(user.getPassword())){
				model.addAttribute("user", retrievedUser);
				return "welcome";
			}
		}
		
		model.addAttribute("errorMsg", "Username/Password is wrong.");

		return "login";
	}
	
	@RequestMapping(value = "/logout", method = {RequestMethod.GET})
	public String logout(Model model, SessionStatus ss){
		ss.setComplete();
		
		return "redirect:/login";
	}
}
