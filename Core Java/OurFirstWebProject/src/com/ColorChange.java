package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ColorChange extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ColorChange() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String usern = request.getParameter("usern");
		String[] color = request.getParameterValues("color");

		if (color == null) {
			request.getParameter("<h1>No color Selected</h1>");
		} else {
			for (String c : color) {
				response.getWriter().println("<h1><font color =" + c + ">Hello, " + usern + "</font></h1>");
			}
		}
	}

}
