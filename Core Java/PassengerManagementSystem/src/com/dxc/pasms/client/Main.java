package com.dxc.pasms.client;

import java.util.Scanner;
import com.dxc.pasms.model.Passenger;

import com.dxc.pasms.dao.PassengerDAO;
import com.dxc.pasms.dao.PassengerDAOImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassengerDAO passengerDAO = new PassengerDAOImpl();

		while (true) {
			System.out.println("MENU");
			System.out.println("1. Add the Passenger Detail");
			System.out.println("2. Get All The Passenger");
			System.out.println("3. Get Passenger Details By Passenger PNR");
			System.out.println("4. Delete Passenger Details");
			System.out.println("5. Update Passenger Details");
			System.out.println("6. Exit");
			Scanner scanner = new Scanner(System.in);
			int choice = 0;
			System.out.println("Please enter your choice: (1-3)");

			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Please enter Passenger PNR");
				int passengerPNR = scanner.nextInt();
				System.out.println("Please enter Passenger Name");
				String passengerName = scanner.next();
				System.out.println("Please enter Passenger source");
				String source = scanner.next();
				System.out.println("Please enter Passenger destination");
				String destination = scanner.next();
				System.out.println("Please enter Passenger fare");
				int fare = scanner.nextInt();

				Passenger passenger = new Passenger(passengerPNR, passengerName, source, destination, fare);

				passengerDAO.addPassenger(passenger);
				break;

			case 2:
				System.out.println(passengerDAO.getAllPassenger());
				break;

			case 3:
				System.out.println("Enter the Passenger PNR: ");
				int passPNR = scanner.nextInt();
				System.out.println(passengerDAO.getPassengerDetails(passPNR));
				break;

			case 4:
				System.out.println("Enter the Passenger PNR: ");
				int passPNRdel = scanner.nextInt();
				passengerDAO.deletePassenger(passPNRdel);
				break;

			case 5:

				System.out.println("Please enter Passenger PNR");
				int passengerPNRup = scanner.nextInt();
				System.out.println("Please enter Passenger Name");
				String passengerNameUp = scanner.next();
				System.out.println("Please enter Passenger source");
				String sourceUp = scanner.next();
				System.out.println("Please enter Passenger destination");
				String destinationUp = scanner.next();
				System.out.println("Please enter Passenger fare");
				int fareUp = scanner.nextInt();

				Passenger passengerUp = new Passenger(passengerPNRup, passengerNameUp, sourceUp, destinationUp, fareUp);
				passengerDAO.updatePassenger(passengerUp);

			case 6:
				System.out.println("Thanks for using my app");
				System.exit(0);

			default:
				System.out.println("R U Okay. Please enter (1-3)");
			}
		}
	}

}
