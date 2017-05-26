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
import com.fdmgroup.dao.ExamCollectionDao;
import com.fdmgroup.dao.UserCollectionDao;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User foundUser = UserCollectionDao.getInstance().findByUsername(username);
		
		if(foundUser != null && foundUser.getPassword().equals(password)){
			HttpSession session = request.getSession();
			session.setAttribute("user", foundUser);
			session.setMaxInactiveInterval(60);
			RequestDispatcher rd = null;
			if(foundUser.getRole()==0){
				List<Exam> exams = ExamCollectionDao.getInstance().findAll();
				request.setAttribute("examList", exams);
				List<Result> uResults =  ExamCollectionDao.getInstance().getUserResults(foundUser);
				request.setAttribute("resultList", uResults);
				rd = request.getRequestDispatcher("/WEB-INF/welcomeStudent.jsp");
			}
			else if(foundUser.getRole()==1){
				rd = request.getRequestDispatcher("/WEB-INF/welcomeTeacher.jsp");
			}
			else if(foundUser.getRole()==2){
				rd = request.getRequestDispatcher("/WEB-INF/welcomeAdmin.jsp");
			}
			rd.forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "username/password is wrong");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
