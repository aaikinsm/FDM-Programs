package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ExamProcessServlet
 */
@WebServlet("/start_exam")
public class ExamStartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExamStartServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("user") != null){
			User user = (User)request.getAttribute("user");
			int examId = Integer.parseInt(request.getParameter("examId"));
			Exam exam = new ExamJpaDao().findById(examId);
			if(exam != null ){//&& exam.getCourse().getCourseId() == user.getCourse().getCourseId()){
				exam.randomize();
				request.getSession().setAttribute("questionCount",0);
				request.getSession().setAttribute("result", new Result(exam,user));
				request.getSession().setAttribute("question", exam.getNextQuestion());
				request.getSession().setAttribute("time", exam.getTimer());
				request.getSession().setAttribute("exam", exam);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/exam.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("The exam is not available to user");
			}
		}else{
			System.out.println("User must be logged in");
		}
	}


}
