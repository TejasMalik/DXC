package com;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Success extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Date date = new Date();
		response.getWriter().println("<h1>Welcome To DXC</h1>");
		response.getWriter().println("<h1>you agreed on: </h1>" + date);
	}

}
