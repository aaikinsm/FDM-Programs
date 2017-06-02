package com.fdmgroup.app;

import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.dao.UserJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.User;

public class MainApp {
	public static void main(String[] args) {
		HomeController hc = HomeController.getInstance();
		//addSampleData();
		hc.showHome();
	}

	
	
	
	public static void addSampleData() {
		User u1 = new User("aam", "123", "Albert", "Mensah");
		User u2 = new User("cindyj", "234", "Cindy", "Jackson");
		User u3 = new User("king", "234", "Kingsley", "Amankwah");
		User u4 = new User("admin", "admin", "George", "Shrinks");
		User u5 = new User("hfar", "123", "Hose", "Farres");
		User u6 = new User("wilc", "123", "William", "Clifford");
				
		u3.setRole(1);
		u2.setRole(1);
		u4.setRole(2);
		
		UserJpaDao.getInstance().create(u1);
		UserJpaDao.getInstance().create(u2);
		UserJpaDao.getInstance().create(u3);		
		UserJpaDao.getInstance().create(u4);		
		UserJpaDao.getInstance().create(u5);		
		UserJpaDao.getInstance().create(u6);		
		
		Exam myExam = new Exam(30, "SQL Quiz", 1, u2);
		Question q1 = new Question("What does SQL stand for?");
		q1.addPossibleAnswer("Structured Query Language");
		q1.addPossibleAnswer("Strong Question Language");
		q1.addPossibleAnswer("Structured Question Language");
		q1.setCorrectAnswer("A");
		Question q2 = new Question("Which SQL statement is used to extract data from a database?");
		q2.addPossibleAnswer("GET");
		q2.addPossibleAnswer("SELECT");
		q2.addPossibleAnswer("OPEN");
		q2.addPossibleAnswer("EXTRACT");
		q2.setCorrectAnswer("B");
		Question q3 = new Question("Which SQL statement is used to update data in a database?");
		q3.addPossibleAnswer("SAVE");
		q3.addPossibleAnswer("SAVE AS");
		q3.addPossibleAnswer("MODIFY");
		q3.addPossibleAnswer("UPDATE");
		q3.setCorrectAnswer("D");
		myExam.addQuestion(q1);
		myExam.addQuestion(q2);
		myExam.addQuestion(q3);
		ExamJpaDao.getInstance().create(myExam);
	
		Exam myExam2 = new Exam(45, "G1 Road Test", 1, u3);
		Question qD1 = new Question(
				"In poor weather conditions drivers are permitted to use high beam lights however drivers must switch back to low beam lights when:");
		qD1.addPossibleAnswer("Following closer than 60 meters behind another vehicle");
		qD1.addPossibleAnswer("Drivers are never permitted to drive with high beam lights");
		qD1.addPossibleAnswer("Approaching an oncoming vehicle closer than 150 meters");
		qD1.addPossibleAnswer("Both answers A) and C) are correct");
		qD1.setCorrectAnswer("d");
		Question qD2 = new Question(
				"The vehicle in front of you is stopped at a crosswalk for a pedestrian. You should:");
		qD2.addPossibleAnswer("Pass the stopped vehicle on the right");
		qD2.addPossibleAnswer("Stop, sound the horn and wait for the driver's signal to pass");
		qD2.addPossibleAnswer("Not pass any vehicle stopped to allow a pedestrian to cross");
		qD2.addPossibleAnswer("Pass the stopped vehicle on the Left");
		qD2.setCorrectAnswer("c");
		Question qD3 = new Question("Unless you are intending to turn left or pass another vehicle you should:");
		qD3.addPossibleAnswer("Drive on the shoulder of the highway");
		qD3.addPossibleAnswer("Drive in the center lane");
		qD3.addPossibleAnswer("Keep to the well to the right");
		qD3.addPossibleAnswer("Keep to the well to the Left");
		qD3.setCorrectAnswer("c");
		Question qD4 = new Question(
				"G1 or G2 Drivers - You may be called in for an interview with the Ministry of Transportation if you accumulate how many demerit points?");
		qD4.addPossibleAnswer("2 demerit points");
		qD4.addPossibleAnswer("6 or more demerit points");
		qD4.addPossibleAnswer("9 or more demerit points");
		qD4.addPossibleAnswer("At any time at the discretion of the ministry");
		qD4.setCorrectAnswer("b");
		Question qD5 = new Question(
				"When entering a highway from a private road/driveway you should:");
		qD5.addPossibleAnswer("Yield to all vehicles approaching on the highway");
		qD5.addPossibleAnswer("Speed up and enter the highway as quickly as possible");
		qD5.addPossibleAnswer("Sound horn and proceed with caution");
		qD5.addPossibleAnswer("Enter highway, you have the right of way");
		qD5.setCorrectAnswer("a");
		myExam2.addQuestion(qD1);
		myExam2.addQuestion(qD2);
		myExam2.addQuestion(qD3);
		myExam2.addQuestion(qD4);
		myExam2.addQuestion(qD5);
		ExamJpaDao.getInstance().create(myExam2);
	}	
}
