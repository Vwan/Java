package com.hp.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name="SessionTimeout",
		urlPatterns="/sessionInterval")
public class SessionInvalidateServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();
			session.setAttribute("foo", "42");
			session.setAttribute("bar", "420");
			session.setMaxInactiveInterval(1);
			String foo = (String) session.getAttribute("foo");
			if (session.isNew()){
				out.println("New Session:" + foo);
			}
			else {
				out.println("welcome back: " + foo);
			}
			out.println("Foo: " + foo);
			}
}
