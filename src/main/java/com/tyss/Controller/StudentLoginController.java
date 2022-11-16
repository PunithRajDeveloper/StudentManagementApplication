package com.tyss.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.dao.StudentDao;
import com.tyss.dto.Student;

@WebServlet("/login")
public class StudentLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		StudentDao dao = new StudentDao();
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("email", email);

		Student student = dao.findStudentByEmail(email);
		if (student.getPassword().equals(password)) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/home");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("invalid", "Invalid Password");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}