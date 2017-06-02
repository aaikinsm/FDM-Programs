package com.fdmgroup.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.persistence.Persistence;

import com.fdmgroup.controller.ExamController;
import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.dao.UserJpaDao;
import com.fdmgroup.model.Exam;
import com.fdmgroup.model.Result;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		User foundUser = new UserJpaDao().findByUsername(username);

		if (foundUser != null && foundUser.getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", foundUser);
			session.setMaxInactiveInterval(300);
			session.setAttribute("errorMsg","");

			processUserDashboard(request, response, foundUser);

		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "username/password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("user") != null) {
			User foundUser = (User) req.getSession().getAttribute("user");

			processUserDashboard(req, resp, foundUser);
		}else{
			resp.sendRedirect("login");
		}
	}

	public void processUserDashboard(HttpServletRequest request, HttpServletResponse response, User foundUser)
			throws ServletException, IOException {

		ExamJpaDao examDao = new ExamJpaDao();
		RequestDispatcher rd = null;

		if (foundUser.getRole() == 0) {
			List<Exam> exams = examDao.findAll();
			request.setAttribute("examList", exams);
			List<Result> uResults = examDao.getUserResults(foundUser);
			request.setAttribute("resultList", uResults);
			rd = request.getRequestDispatcher("/WEB-INF/welcomeStudent.jsp");
		} else if (foundUser.getRole() == 1) {
			List<Exam> exams = examDao.findByAuthor(foundUser);
			request.setAttribute("examList", exams);
			rd = request.getRequestDispatcher("/WEB-INF/welcomeTeacher.jsp");
		} else if (foundUser.getRole() == 2) {
			rd = request.getRequestDispatcher("/WEB-INF/welcomeAdmin.jsp");
		}
		rd.forward(request, response);
	}

}
