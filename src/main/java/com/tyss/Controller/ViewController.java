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



@WebServlet("/view")
public class ViewController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		String email = (String) httpSession.getAttribute("email");
		if (email != null) {
			int id = Integer.parseInt(req.getParameter("id"));
			StudentDao dao = new StudentDao();
			Student student = dao.findbyId(id);

			req.setAttribute("student", student);
			RequestDispatcher dispatcher = req.getRequestDispatcher("View.jsp");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("invalid", "Login first to acess");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
