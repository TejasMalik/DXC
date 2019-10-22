package com.dxc.pasms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.pasms.dao.PassengerDAO;
import com.dxc.pasms.dao.PassengerDAOImpl;
import com.dxc.pasms.model.Passenger;

@WebServlet("/PassengerController")
public class PassengerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PassengerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int passengerPNR = Integer.parseInt(request.getParameter("passengerPNR"));
		Passenger passenger = new Passenger();
		PassengerDAO passengerDAO = new PassengerDAOImpl();

		passenger = passengerDAO.getPassengerDetails(passengerPNR);
		HttpSession session = request.getSession();
		if (passenger == null) {
			session.setAttribute("searchedPassenger", "No record with passenger PNR : " + passengerPNR + " exists");
		}else {
			session.setAttribute("searchedPassenger", passenger);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchResult.jsp");
        dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
