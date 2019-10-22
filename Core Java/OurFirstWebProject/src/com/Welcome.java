package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Welcome extends HttpServlet {
	
	int counter = 0;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uname = request.getParameter("user");
		counter++;
		response.getWriter().println("<h1>Welcome To DXC, </h1>" +uname);
		response.getWriter().println("<h1>you are user number</h1>" +counter);
		
		for (int i = 0; i<5; i++) {
			response.getWriter().println("<h3>Tejas</h3>");
		}
		response.getWriter().println("<h1><a href = tc.html>Terms and Conditons</a></h1>");
		
		response.getWriter().println("<h1><a href = Products.html>Add Products</a></h1>");
	
	}

}
