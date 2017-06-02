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
			new CreateExamView();
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
	
	
	public void showStudentDashboard(){
		System.out.println("*** Welcome "+SessionUser.getLoggedInUser().getFirstName()
				+" "+SessionUser.getLoggedInUser().getLastName()+" ***");
		System.out.println("This is your Student dashboard");
		System.out.println("Press 1 to logout \nPress 2 to view available exams \n"
				+ "Press 3 to view your exam results");
		String option = scanner.nextLine();
		switch (option){
		case "1":
			HomeController.getInstance().doLogout();
			break;
		case "2":
			ExamController.getInstance().viewExams(0);
			break;
		case "3":
			ExamController.getInstance().viewUserResults(SessionUser.getLoggedInUser());
			break;
		default:
			showStudentDashboard();
			break;
		}
		
	}

	public void showTeacherDashboard(){
		System.out.println("*** Welcome "+SessionUser.getLoggedInUser().getFirstName()
				+" "+SessionUser.getLoggedInUser().getLastName()+" ***");
		System.out.println("This is your Teacher dashboard");
		System.out.println("Press 1 to logout \nPress 2 to view all exams"
				+ "\nPress 3 to create exams \nPress 4 to view exam results..");
		String option = scanner.nextLine();
		switch (option){
		case "1":
			HomeController.getInstance().doLogout();
			break;
		case "2":
			ExamController.getInstance().viewExams(0);
			break;
		case "3":
			ExamController.getInstance().createExam();
			break;
		case "4":
			ExamController.getInstance().viewExamResults(SessionUser.getLoggedInUser());
			break;
		default:
			showStudentDashboard();
			break;
		}
		
	}
	
	
	public void showAdminDashboard(){
		//TODO: Implement course management
		System.out.println("*** Welcome "+SessionUser.getLoggedInUser().getFirstName()
				+" "+SessionUser.getLoggedInUser().getLastName()+" ***");
		System.out.println("This is your Administrator dashboard");
		System.out.println("Press 1 to logout \nPress 2 to create exams \n"
				+ "Press 3 to view your exam results");
		String option = scanner.nextLine();
		switch (option){
		case "1":
			HomeController.getInstance().doLogout();
			break;
		case "2":
			ExamController.getInstance().createExam();
			break;
		case "3":
			ExamController.getInstance().viewExamResults(SessionUser.getLoggedInUser());
			break;
		default:
			showStudentDashboard();
			break;
		}
		
	}

}
