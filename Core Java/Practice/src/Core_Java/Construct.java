package Core_Java;

public class Construct {

	private String customerName;
	private int customerId;
	private String customerAddress;
	private int billAmount;

	public Construct() {
		customerName = "Not Available";
		customerId = 0;
		customerAddress = "Address not available";
		billAmount = 100;
	}

	public Construct(int customerId, String customerName, String customerAddress, int billAmount) {
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerAddress = customerAddress;
		this.billAmount = billAmount;

	}

	public void display() {
		System.out.println("Customer name: " + customerName);
		System.out.println("Customer Id: " + customerId);
		System.out.println("Customer Address: " + customerAddress);
		System.out.println("Customer Bill Amount: " + billAmount);
		System.out.println("*************************************************************");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Construct c1 = new Construct(1, "Neha", "Bangalore", 900);
		Construct c2 = new Construct(2, "Rekha", "Delhi", 8900);
		Construct c3 = new Construct();
		Construct c4 = new Construct(3, "Jaya", "Mumbai", 900);
		Construct c5 = new Construct();


		c1.display();
		c2.display();
		c3.display();
		c4.display();
		c5.display();
	}

}
