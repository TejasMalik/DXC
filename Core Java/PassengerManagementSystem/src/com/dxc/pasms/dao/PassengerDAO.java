package com.dxc.pasms.dao;

import java.util.List;
import com.dxc.pasms.model.Passenger;

public interface PassengerDAO {
	public Passenger getPassengerDetails(int passengerPNR);

	public List<Passenger> getAllPassenger();

	public void addPassenger(Passenger passenger);

	public void deletePassenger(int passengerPNR);

	public void updatePassenger(Passenger passenger);
}
