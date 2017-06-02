package com.fdmgroup.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fdmgroup.dao.UserJpaDao;
import com.fdmgroup.model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		
		UserJpaDao userDao = new UserJpaDao();
		
		User foundUser = userDao.findByUsername(username);
		if(foundUser == null){
			User user = new User(username, password, fname, lname);
			userDao.create(user);	
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(300);
			session.setAttribute("errorMsg","");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/welcomeStudent.jsp");
			rd.forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "The username is taken");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
