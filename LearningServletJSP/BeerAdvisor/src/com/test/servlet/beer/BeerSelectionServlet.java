package com.test.servlet.beer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.servlet.beer.model.Brands;

/**
 * Servlet implementation class BeerSelection
 */
@WebServlet("/BeerSelection")
public class BeerSelectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String color = request.getParameter("color");
		Brands sb = new Brands();
		color="light";
		List brands = sb.getBrands(color);
		response.setContentType("text/html");
	/*	response.setCharacterEncoding("UTF-8");
		System.out.println(String.valueOf(brands.size()));
		while (brands.iterator().hasNext()){
			response.getWriter().write("1Test Servlet color is:<br>"+brands.iterator().next()+"</br>");
			
		}
	*/
		request.setAttribute("color", brands);
		RequestDispatcher rd = request.getRequestDispatcher("testBeer.jsp");
		rd.forward(request, response);
				

	}

}
