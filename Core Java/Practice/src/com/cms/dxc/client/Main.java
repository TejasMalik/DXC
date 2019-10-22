package com.cms.dxc.client;

import com.cms.dxc.exception.InvalidBillAException;
import com.cms.dxc.exception.InvalidCustomerIdException;
import com.cms.dxc.model.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Customer customer = null;

		try {
			customer = new Customer(100, "Tejas", "Delhi", 98000);
		} catch (InvalidBillAException b) {
			b.printStackTrace();
		} catch (InvalidCustomerIdException e) {
			System.out.println(e.getMessage());
		}
		customer.display();
	}

}
