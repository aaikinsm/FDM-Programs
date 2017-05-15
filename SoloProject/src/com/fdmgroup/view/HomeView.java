package com.fdmgroup.view;

import java.util.Scanner;

import com.fdmgroup.controller.ExamController;
import com.fdmgroup.controller.HomeController;
import com.fdmgroup.model.SessionUser;

public class HomeView {
	
	private static HomeView homeView;
	Scanner scanner;
	

	private HomeView() {
		super();
		scanner = new Scanner(System.in);
	}

	public static HomeView getInstance(){
		if(homeView == null){
			homeView = new HomeView();
		}
		return homeView;
	}

	public void displayOptions() {
		System.out.println("Welcome");
		System.out.println("Select");
		System.out.println("1) Login\n2) Register");
		String option = scanner.nextLine();
		
		switch (option){
		case "1":
			showLogin();
			break;
		case "2":
			showRegister();
			break;
		case "3":
			ExamController.getInstance().createExam();
			ExamController.getInstance().startExam(1);
			break;
		default: 
			System.out.println("Invalid option");
			displayOptions();
			break;
		}

	}



	private void showLogin() {
		System.out.println("Enter Username");
		String username = scanner.nextLine();
		
		System.out.println("Enter password");
		String password = scanner.nextLine();
		HomeController.getInstance().doLogin(username,password);
	}



	private void showRegister() {
		System.out.println("Enter Username");
		String username = scanner.nextLine();
		
		System.out.println("Enter password");
		String password = scanner.nextLine();
		
		System.out.println("Enter first name");
		String firstname = scanner.nextLine();
		
		System.out.println("Enter last name");
		String lastname = scanner.nextLine();
		
		HomeController.getInstance().doRegister(username,password,firstname,lastname);
	}
	
	public void showDashboard(){
		System.out.println("This is your dashboard");
		System.out.println("Welcome "+SessionUser.getLoggedInUser().getFirstName()+" "+SessionUser.getLoggedInUser().getLastName());
		System.out.println("Press 1 to logout");
		String option = scanner.nextLine();
		switch (option){
		case "1":
			HomeController.getInstance().doLogout();
			break;
		case "3":
			ExamController.getInstance().createExam();
			ExamController.getInstance().startExam(1);
			break;
		default:
			showDashboard();
			break;
		}
		
	}
	

}
