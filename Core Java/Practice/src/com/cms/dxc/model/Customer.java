package com.cms.dxc.model;

import com.cms.dxc.exception.InvalidBillAException;

public class Customer implements Comparable<Customer> {

	private String customerName;
	private int customerId;
	private String customerAddress;
	private int billAmount;

	public Customer() {
		customerName = "Not Available";
		customerId = 0;
		customerAddress = "Address not available";
		billAmount = 100;
	}

	public Customer(int customerId, String customerName, String customerAddress, int billAmount) throws Exception {
		if (customerId < 0) {
			throw new Exception("CustomerId not valid");
			
		}else {
			this.customerName = customerName;
		}
		this.customerId = customerId;
		this.customerAddress = customerAddress;

		if (billAmount < 0) {
			throw new InvalidBillAException("Bill Amount not valid");
		} else {
			this.billAmount = billAmount;
		}

	}

	public Customer(String customerName, String customerAddress) {
		this();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
	}

	public Customer(String customerName, int billAmount) {
		this();
		this.customerName = customerName;
		this.billAmount = billAmount;
	}

	public void display() {
		System.out.println("Customer name:" + customerName);
		System.out.println("Customer Id:" + customerId);
		System.out.println("Customer Address:" + customerAddress);
		System.out.println("Customer BillAmount:" + billAmount);
		System.out.println("*************************************************************");
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	
	public int compareTo(Customer o) {
		if (this.customerName.compareTo(o.customerName) < 0) {
			return 0;
		}else {
			return -1;
		}
	}

}
