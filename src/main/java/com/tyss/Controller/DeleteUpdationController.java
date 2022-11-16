package com.tyss.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.dao.StudentDao;

@WebServlet("/delete")
public class DeleteUpdationController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		StudentDao dao=new StudentDao();
		
		
		if(id!=0) {
		dao.deleteStudentById(id);
		RequestDispatcher dispatcher=req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req, resp);
		}
		
		else {
			req.setAttribute("invalid", "Login first to acess");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");
			dispatcher.forward(req, resp);
		}
	
	}

}
