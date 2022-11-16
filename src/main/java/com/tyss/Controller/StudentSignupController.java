package com.tyss.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.dao.StudentDao;
import com.tyss.dto.Student;



@WebServlet("/signup")
public class StudentSignupController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student();
		student.setName(req.getParameter("name"));
		student.setPhone(Long.parseLong(req.getParameter("phone")));
		student.setEmail(req.getParameter("email"));
		student.setPassword(req.getParameter("password"));

		StudentDao dao = new StudentDao();
		dao.saveStudent(student);

		req.setAttribute("message", "Sucessfully signed up");

		RequestDispatcher dispatcher = req.getRequestDispatcher("Signup.jsp");
		dispatcher.forward(req, resp);

	}

}