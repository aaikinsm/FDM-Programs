package com.fdmgroup.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import com.fdmgroup.dao.ExamCollectionDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.TimerThread;
import com.fdmgroup.model.User;
import com.fdmgroup.view.ExamView;

public class ExamController {
	private Exam exam;
	private Result result;
	private User user;
	private ExamCollectionDao examCollectionDao;
	private static ExamController examController;
	private int examTime, qRemaining;
	Question q;
	ExamView eView;
	Scanner in = new Scanner(System.in);

	private ExamController() {
		super();
		examCollectionDao = ExamCollectionDao.getInstance();
		user = SessionUser.getLoggedInUser();
	}

	public static ExamController getInstance() {
		if (examController == null) {
			examController = new ExamController();
		}
		return examController;
	}

	public void startExam(int id) {	
		exam = (Exam) examCollectionDao.findById(id);
		if (exam != null) {
			eView = new ExamView(exam.getTitle());
			examTime = exam.getTimer();
			exam.randomize();
			result = new Result(0, exam, new User());
			q = exam.getNextQuestion();
			
			eView.button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(q != null && eView.button.getLabel().equals("START")){
						qRemaining = exam.getNumOfQuestions();
						TimerThread timer = new TimerThread(examTime, eView);
						timer.start();
						System.out.println("Starting Exam");
						eView.qText.setText(q.getQuestion());
						eView.button.setLabel("Next");
						eView.qCount.setText("Questions remaining: "+qRemaining);
						qRemaining--;
					}
					else if(q != null && eView.button.getLabel().equals("Next")){
						eView.qCount.setText("Questions remaining: "+qRemaining);
						qRemaining--;
						//System.out.println(q.getQuestion());
						if (eView.selections.getSelectedCheckbox().getLabel().equalsIgnoreCase(q.getCorrectAnswer())) {
							System.out.println("Correct");
							eView.eTimer.setText("CORRECT");
							result.addResultData(true);
						} else {
							System.out.println("Wrong");
							eView.eTimer.setText("WRONG");
							result.addResultData(false);
						}
						q = exam.getNextQuestion();
						if(q == null){
							eView.qCount.setText("Exam Complete");
							eView.eTimer.setText("");
							eView.qText.setText("");
						}else{
							eView.qText.setText(q.getQuestion());
						}
					}
				}
			});
			
			/*while (true) {
				q = exam.getNextQuestion();
				if (q == null)
					break;
				else {
					eView.qCount.setText("Questions remaining: "+qRemaining);
					qRemaining--;
					//System.out.println(q.getQuestion());
					eView.qText.setText(q.getQuestion());
					if (in.next().equalsIgnoreCase(q.getCorrectAnswer())) {
						//System.out.println("Correct");
						eView.eTimer.setText("CORRECT");
						result.addResultData(true);
					} else {
						//System.out.println("Wrong");
						eView.eTimer.setText("WRONG");
						result.addResultData(false);
					}
				}
				
				

			}
			System.out.println(user.getFirstName()+": "+result.calculateResult()+"%"); //test
*/		}
	}
	
	public void createExam(){
		//test//
		Question q1 = new Question("What is red?");
		q1.addPossibleAnswer("a) A shape");
		q1.addPossibleAnswer("b) A color");
		q1.setCorrectAnswer("b");
		Question q2 = new Question("What is 5+2?");
		q2.addPossibleAnswer("a) 7");
		q2.addPossibleAnswer("b) 8");
		q2.setCorrectAnswer("a");
		Exam myExam = new Exam(30, "My Almighty Exam", true, user);
		myExam.addQuestion(q1);
		myExam.addQuestion(q2);
		examCollectionDao.create(myExam);
	//	
	}
}
