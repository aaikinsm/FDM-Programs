package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Question;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class ExamNext
 */
@WebServlet("/next")
public class ExamNextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExamNextServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exam exam = (Exam) request.getSession().getAttribute("exam");
		int count = ((int) request.getSession().getAttribute("questionCount"))+1;
		int time = (Integer.parseInt(request.getParameter("time")));
		Result result = (Result) request.getSession().getAttribute("result");
		result.addResultData(Boolean.parseBoolean(request.getParameter("ans")));
		Question question = exam.getNextQuestion();
		if(time <= 0 || count == exam.getNumOfQuestions() || question == null){
			response.getOutputStream().write("Complete".getBytes());
			result.setUser((User) request.getSession().getAttribute("user"));
			result.setTotal(exam.getNumOfQuestions());
			request.getSession().removeAttribute("questionCount");
			request.getSession().removeAttribute("result");
			request.getSession().removeAttribute("question");
			request.getSession().removeAttribute("time");
			request.getSession().removeAttribute("exam");
			new ExamJpaDao().addResult(result);
			response.sendRedirect("index.jsp");
		}else{
		request.getSession().setAttribute("questionCount",count);
		request.getSession().setAttribute("result", result);
		request.getSession().setAttribute("question", question);
		request.getSession().setAttribute("time", time);
		request.getSession().setAttribute("exam", exam);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/exam.jsp");
		rd.forward(request, response);
		}
	}

}
