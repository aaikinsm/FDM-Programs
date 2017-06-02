package com.fdmgroup.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdmgroup.dao.ExamJpaDao;
import com.fdmgroup.model.Exam;

/**
 * Servlet implementation class DeleteExamServlet
 */
@WebServlet("/delete")
public class DeleteExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("examId"));
		ExamJpaDao examDao = new ExamJpaDao();
		Exam exam = examDao.findById(id);
		examDao.delete(exam);
		
		response.sendRedirect("index.jsp");
	}

}
