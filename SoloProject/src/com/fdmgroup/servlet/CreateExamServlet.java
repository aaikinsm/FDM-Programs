package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.User;


@WebServlet("/create")
public class CreateExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public CreateExamServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if(user != null){
			if(request.getParameter("question") != null){
				addQuestion(request, response);
			}else{
				finalizeCreation(request, response, user);
			}
		}else{
			response.sendRedirect("login");
		}
	}
	
	public void addQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Question q = new Question();
		q.setQuestion(request.getParameter("question"));
		q.addPossibleAnswer(request.getParameter("ansA"));
		q.addPossibleAnswer(request.getParameter("ansB"));
		if (!request.getParameter("ansC").equals("")){
			q.addPossibleAnswer(request.getParameter("ansC"));
			if (!request.getParameter("ansD").equals(""))
				q.addPossibleAnswer(request.getParameter("ansD"));
		}
		q.setCorrectAnswer(request.getParameter("correct"));
		
		List<Question> questionList;
		if(request.getSession().getAttribute("questionList") == null){
			questionList = new ArrayList<Question>();
		}else{
			questionList = (List<Question>) request.getSession().getAttribute("questionList");
		}
		questionList.add(q);
		request.getSession().setAttribute("questionList", questionList);
		RequestDispatcher rd = request.getRequestDispatcher("createExam.jsp");
		rd.forward(request, response);
	}
	
	public void finalizeCreation(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException{
		if (request.getSession().getAttribute("questionList") != null){
			List<Question> questionList = (List<Question>) request.getSession().getAttribute("questionList");
			request.getSession().removeAttribute("questionList");
			int timer = Integer.parseInt(request.getParameter("duration"))*60;
			int isRandomized =0;
			if(request.getParameter("randomize")!=null){
				isRandomized = 1;
			}
			Exam exam = new Exam(timer, request.getParameter("title"), isRandomized, user);
			if(user.getCourse() != null){
				exam.setCourse(user.getCourse());
			}
			exam.setQuestions(questionList);
			ExamJpaDao examDao = new ExamJpaDao();
			examDao.create(exam);
		}else{
			//TODO show no questions error
			System.out.println("no questions added");
		}
	}

}
