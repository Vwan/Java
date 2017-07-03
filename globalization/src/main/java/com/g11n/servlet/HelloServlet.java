package com.g11n.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String user=req.getParameter("user");
		req.setAttribute("user", user);
		
		RequestDispatcher rd = req.getRequestDispatcher("/hello.jsp");
		resp.setContentType("text/html; charset=UTF-8");
		rd.forward(req, resp);		
		
	}

}
