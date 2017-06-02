package com.fdmgroup.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.dao.UserJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.SessionUser;
import com.fdmgroup.model.TimerThread;
import com.fdmgroup.model.User;
import com.fdmgroup.view.CreateExamView;
import com.fdmgroup.view.ExamView;

public class ExamController {
	private Exam exam;
	private Result result;
	private User user;
	private ExamJpaDao examCollectionDao;
	private static ExamController examController;
	private int examTime, qRemaining;
	Question q;
	ExamView eView;
	TimerThread timer;
	Scanner in = new Scanner(System.in);

	private ExamController() {
		super();
		examCollectionDao = ExamJpaDao.getInstance();
		user = SessionUser.getLoggedInUser();
	}

	public static ExamController getInstance() {
		if (examController == null) {
			examController = new ExamController();
		}
		return examController;
	}

	public void viewExams(int courseId) {
		List<Exam> exams = examCollectionDao.findAll();
		
		if (exams.isEmpty()) {
			System.out.println("There are no available exams");
		} else {
			System.out.println("Enter the ID of the exam you would like to open");
			for (Exam exam : exams) {
				if((exam.getCourse() !=null && exam.getCourse().getCourseId() == courseId) || courseId == 0)
				System.out.println("ID:" + exam.getId() + ") " + exam.getTitle());
			}
			Scanner in = new Scanner(System.in);
			int idNum = in.nextInt();
			startExam(idNum);
		}
	}

	public void viewUserResults(User user) {
		List<Result> uResults = examCollectionDao.getUserResults(user);
		if (uResults.isEmpty()) {
			System.out.println("You have not taken an exam yet");
		} else {
			for (Result result : uResults) {
				Exam e = examCollectionDao.findById(result.getExam().getId());
				System.out.print(e.getTitle() + " --> " + result.calculateResult() + "%");
				if (result.passed())
					System.out.println(" : Passed");
				else
					System.out.println(" : Failed");
			}
		}

	}

	public void viewExamResults(User user) {
		List<Result> uResults = examCollectionDao.getExamResults(user);
		if (uResults.isEmpty()) {
			System.out.println("No one has taken your exam yet");
		} else {
			for (Result result : uResults) {
				Exam e = examCollectionDao.findById(result.getExam().getId());
				User u = UserJpaDao.getInstance().findById(result.getUser().getId());
				System.out.print(u.getFirstName() + " " + u.getLastName() + " --> " + e.getTitle() + ": "
						+ result.calculateResult() + "%");
				if (result.passed())
					System.out.println(" : Passed");
				else
					System.out.println(" : Failed");
			}
		}

	}

	public void startExam(int id) {
		exam = (Exam) examCollectionDao.findById(id);
		if (exam != null) {
			eView = new ExamView(exam.getTitle());
			examTime = exam.getTimer();
			exam.randomize();
			result = new Result(exam, SessionUser.getLoggedInUser());
			q = exam.getNextQuestion();

			eView.button.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (q != null && eView.button.getLabel().equals("START")) {
						qRemaining = exam.getNumOfQuestions();
						timer = new TimerThread(examTime, eView);
						timer.start();
						System.out.println("Starting Exam");
						eView.qText.setText(q.getQuestion());
						eView.button.setLabel("Next");
						eView.qCount.setText("Questions remaining: " + qRemaining);
						qRemaining--;
					} else if (q != null && eView.button.getLabel().equals("Next")) {
						eView.qCount.setText("Questions remaining: " + qRemaining);
						qRemaining--;
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
						if (q == null) {
							examComplete();
						} else {
							eView.qText.setText(q.getQuestion());
						}
					}
				}
			});
		}
	}

	public void examComplete() {
		eView.qCount.setText("Exam Complete");
		eView.eTimer.setText("");
		eView.qText.setText("");
		timer.stop = true;
		eView.qText.setText("Your Result: " + result.calculateResult() + "%");
		examCollectionDao.addResult(result);
	}

	public void createExam() {
		ArrayList<Question> questions = new ArrayList<>();
		CreateExamView createEView = new CreateExamView();
		createEView.addQButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!createEView.questionText.getText().isEmpty()) {
					Question q = new Question(createEView.questionText.getText());
					createEView.questionText.setText("");
					if (!createEView.ans1.getText().isEmpty()) {
						q.addPossibleAnswer("a) " + createEView.ans1.getText());
						createEView.ans1.setText("");
					}
					if (!createEView.ans2.getText().isEmpty()) {
						q.addPossibleAnswer("b) " + createEView.ans2.getText());
						createEView.ans2.setText("");
					}
					if (!createEView.ans3.getText().isEmpty()) {
						q.addPossibleAnswer("c) " + createEView.ans3.getText());
						createEView.ans3.setText("");
					}
					if (!createEView.ans4.getText().isEmpty()) {
						q.addPossibleAnswer("d) " + createEView.ans4.getText());
						createEView.ans4.setText("");
					}
					if (createEView.selections.getSelectedCheckbox() == null) {
						createEView.heading.setText("Please select the correct answer");
					} else {
						q.setCorrectAnswer(createEView.selections.getSelectedCheckbox().getLabel().substring(0, 1));

						questions.add(q);
						createEView.heading.setText("Question #" + (questions.size() + 1));
					}

				} else {
					createEView.heading.setText("Please enter a question");
				}
			}
		});

		createEView.doneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (questions.isEmpty() || createEView.title.getText().equals("Enter Exam Title Here")) {
					createEView.heading.setText("You forgot to set a title or add a question");
				} else {
					int seconds = Integer.parseInt(createEView.time.getText()); // :TODO
																				// error
																				// handling
					int rand = 0;
					if (createEView.randomized.isEnabled())
						rand = 1;
					Exam myExam = new Exam(seconds, createEView.title.getText(), rand, user);
					myExam.setQuestions(questions);
					examCollectionDao.create(myExam);
				}

			}
		});
	}
}
