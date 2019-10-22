package com.dxc.pasms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.pasms.model.Passenger;
import com.dxc.pasms.jdbc.DBConnection;

public class PassengerDAOImpl implements PassengerDAO {

	Connection connection = DBConnection.getConnection();

	@Override
	public Passenger getPassengerDetails(int passengerPNR) {
		// TODO Auto-generated method stub
		Passenger passenger = new Passenger();

		try {
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM passenger WHERE passengerPNR = " + passengerPNR);

			if (res.next()) {

				passenger.setPassengerPNR(res.getInt(1));
				passenger.setPassengertName(res.getString(2));
				passenger.setSource(res.getString(3));
				passenger.setDestination(res.getString(4));
				passenger.setFare(res.getInt(5));

				return passenger;

			} else {
				System.out.println("Record Not Found....");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Passenger> getAllPassenger() {
		// TODO Auto-generated method stub
		List<Passenger> allPassenger = new ArrayList<Passenger>();

		try {
			Statement stat = connection.createStatement();
			ResultSet res = stat.executeQuery("SELECT * FROM passenger");

			while (res.next()) {
				Passenger passenger = new Passenger();
				passenger.setPassengerPNR(res.getInt(1));
				passenger.setPassengertName(res.getString(2));
				passenger.setSource(res.getString(3));
				passenger.setDestination(res.getString(4));
				passenger.setFare(res.getInt(5));

				allPassenger.add(passenger);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allPassenger;
	}

	@Override
	public void addPassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connection.prepareStatement("INSERT INTO passenger VALUES(?,?,?,?,?)");
			stat.setInt(1, passenger.getPassengerPNR());
			stat.setString(2, passenger.getPassengertName());
			stat.setString(3, passenger.getSource());
			stat.setString(4, passenger.getDestination());
			stat.setInt(5, passenger.getFare());

			stat.executeUpdate();
			System.out.println("Details Added Successfully...");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deletePassenger(int passengerPNR) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement stat = connection
					.prepareStatement("DELETE FROM passenger WHERE passengerPNR = " + passengerPNR);

			stat.executeUpdate();
			System.out.println("Details Deleted Successfully...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		PreparedStatement stat;
		try {
			stat = connection.prepareStatement(
					"UPDATE passenger SET passengerName = ?, source = ?, destination = ?, fare = ? WHERE passengerPNR = ?");

			stat.setString(1, passenger.getPassengertName());
			stat.setString(2, passenger.getSource());
			stat.setString(3, passenger.getDestination());
			stat.setInt(4, passenger.getFare());
			stat.setInt(5, passenger.getPassengerPNR());

			stat.executeUpdate();
			System.out.println("Details Updated Successfully...");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
