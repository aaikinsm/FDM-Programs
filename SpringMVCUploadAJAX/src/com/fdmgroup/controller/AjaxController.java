package com.fdmgroup.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fdmgroup.dao.UserDAO;
import com.fdmgroup.model.User;

@Controller
public class AjaxController {

	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/showUserForm", method = RequestMethod.GET)
	public String showUserForm(Model model){
		model.addAttribute("u", new User());
		return "userForm";
	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@RequestMapping(value = "/getUser", method = {RequestMethod.GET, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(@RequestBody Map<String, String> json){
		return userDao.findUserById(Integer.parseInt(json.get("uId")));
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User getUserById(@RequestBody User u){
		userDao.createUser(u);
		return u;
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User updateUser(@RequestBody Map<String, String> json){
		User u = new User(json.get("username"), json.get("password"), json.get("firstname"), json.get("lastname"));
		userDao.updateUser(Integer.parseInt(json.get("uId")), u);
		return u;
	}
	
	@RequestMapping(value = "/removeUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody User removeUser(@RequestBody Map<String, String> json){
		User u = userDao.deleteUser(Integer.parseInt(json.get("uId")));
		return u;
	}
}
