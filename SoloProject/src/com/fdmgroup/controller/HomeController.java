package com.fdmgroup.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.fdmgroup.dao.UserCollectionDao;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.User;
import com.fdmgroup.view.HomeView;

public class HomeController {

	private static HomeController homeController;
	private UserCollectionDao userDao;
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("SoloProject");
	
	
	private HomeController() {
		super();
		userDao = UserCollectionDao.getInstance();
	}
	
	public static HomeController getInstance(){
		if (homeController == null){
			homeController = new HomeController();
		}
		return homeController;
	}


	public void showHome(){
		HomeView.getInstance().displayOptions();
	}

	public void doRegister(String username, String password, String firstname, String lastname) {

		User u = new User(1, username,password,firstname, lastname);
		User createdUser = userDao.create(u);
		
		if (createdUser != null){
			System.out.println("Registration successful.");
			SessionUser.setLoggedInUser(createdUser);
			HomeView.getInstance().showDashboard();
		}else{
			System.out.println("Error registration not successful");
			HomeView.getInstance().displayOptions();
		}
		
	}
	
	public void doLogin(String username, String password){
		User foundUser = userDao.findByUsername(username);
		if (foundUser != null && foundUser.getPassword().equals(password)){
			SessionUser.setLoggedInUser(foundUser);
			HomeView.getInstance().showDashboard();
		}else{
			System.out.println("Username/password is wrong");
			HomeView.getInstance().displayOptions();
		}
	}
	
	public void doLogout(){
		SessionUser.setLoggedInUser(null);
		System.out.println("-------------------");
		HomeView.getInstance().displayOptions();
	}
	
}