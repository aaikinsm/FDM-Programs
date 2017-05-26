package com.fdmgroup.app;

import com.fdmgroup.controller.HomeController;
import com.fdmgroup.dao.ExamCollectionDao;
import com.fdmgroup.dao.UserCollectionDao;
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
		
		UserCollectionDao.getInstance().create(u1);
		UserCollectionDao.getInstance().create(u2);
		UserCollectionDao.getInstance().create(u3);		
		UserCollectionDao.getInstance().create(u4);		
		UserCollectionDao.getInstance().create(u5);		
		UserCollectionDao.getInstance().create(u6);		
		
		Exam myExam = new Exam(30, "SQL Quiz", 1, u2);
		Question q1 = new Question("What does SQL stand for?");
		q1.addPossibleAnswer("a) Structured Query Language");
		q1.addPossibleAnswer("b) Strong Question Language");
		q1.addPossibleAnswer("c) Structured Question Language");
		q1.setCorrectAnswer("A");
		Question q2 = new Question("Which SQL statement is used to extract data from a database?");
		q2.addPossibleAnswer("a) GET");
		q2.addPossibleAnswer("b) SELECT");
		q2.addPossibleAnswer("c) OPEN");
		q2.addPossibleAnswer("d) EXTRACT");
		q2.setCorrectAnswer("B");
		Question q3 = new Question("Which SQL statement is used to update data in a database?");
		q3.addPossibleAnswer("a) SAVE");
		q3.addPossibleAnswer("b) SAVE AS");
		q3.addPossibleAnswer("c) MODIFY");
		q3.addPossibleAnswer("d) UPDATE");
		q3.setCorrectAnswer("D");
		myExam.addQuestion(q1);
		myExam.addQuestion(q2);
		myExam.addQuestion(q3);
		ExamCollectionDao.getInstance().create(myExam);
	
		Exam myExam2 = new Exam(45, "G1 Road Test", 1, u3);
		Question qD1 = new Question(
				"In poor weather conditions drivers are permitted to use high beam lights however drivers must switch back to low beam lights when:");
		qD1.addPossibleAnswer("a) Following closer than 60 meters behind another vehicle");
		qD1.addPossibleAnswer("b) Drivers are never permitted to drive with high beam lights");
		qD1.addPossibleAnswer("c) Approaching an oncoming vehicle closer than 150 meters");
		qD1.addPossibleAnswer("d) Both answers a) and c) are correct");
		qD1.setCorrectAnswer("d");
		Question qD2 = new Question(
				"The vehicle in front of you is stopped at a crosswalk for a pedestrian. You should:");
		qD2.addPossibleAnswer("a) Pass the stopped vehicle on the right");
		qD2.addPossibleAnswer("b) Stop, sound the horn and wait for the driver's signal to pass");
		qD2.addPossibleAnswer("c) Not pass any vehicle stopped to allow a pedestrian to cross");
		qD2.addPossibleAnswer("d) Pass the stopped vehicle on the Left");
		qD2.setCorrectAnswer("c");
		Question qD3 = new Question("Unless you are intending to turn left or pass another vehicle you should:");
		qD3.addPossibleAnswer("a) Drive on the shoulder of the highway");
		qD3.addPossibleAnswer("b) Drive in the center lane");
		qD3.addPossibleAnswer("c) Keep to the well to the right");
		qD3.addPossibleAnswer("d) Keep to the well to the Left");
		qD3.setCorrectAnswer("c");
		Question qD4 = new Question(
				"G1 or G2 Drivers - You may be called in for an interview with the Ministry of Transportation if you accumulate how many demerit points?");
		qD4.addPossibleAnswer("a) 2 demerit points");
		qD4.addPossibleAnswer("b) 6 or more demerit points");
		qD4.addPossibleAnswer("c) 9 or more demerit points");
		qD4.addPossibleAnswer("d) At any time at the discretion of the ministry");
		qD4.setCorrectAnswer("b");
		Question qD5 = new Question(
				"When entering a highway from a private road/driveway you should:");
		qD5.addPossibleAnswer("a) Yield to all vehicles approaching on the highway");
		qD5.addPossibleAnswer("b) Speed up and enter the highway as quickly as possible");
		qD5.addPossibleAnswer("c) Sound horn and proceed with caution");
		qD5.addPossibleAnswer("d) Enter highway, you have the right of way");
		qD5.setCorrectAnswer("a");
		myExam2.addQuestion(qD1);
		myExam2.addQuestion(qD2);
		myExam2.addQuestion(qD3);
		myExam2.addQuestion(qD4);
		myExam2.addQuestion(qD5);
		ExamCollectionDao.getInstance().create(myExam2);
	}	
}
