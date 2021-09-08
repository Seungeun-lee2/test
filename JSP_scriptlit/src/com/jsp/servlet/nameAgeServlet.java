package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/nameAge")
public class nameAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url="/WEB-INF/views/forwardtest.jsp";
		
		String name=request.getParameter("name");
		String age=request.getParameter("age");
	
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
