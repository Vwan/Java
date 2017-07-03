package com.hp.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name="cookie",
		urlPatterns="/cookie")
public class CookieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies){
			out.println("cookie is: "+c.getName());
		}
		
			response.setContentType("text/html");
			
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
			Cookie cookie = new Cookie("foo",foo);
			//cookie.setMaxAge(1);
			response.addCookie(cookie);
			}
}
