package Core_Java;

public class Vehicle {

	public String color;
	public int noOfTyres;
	public int model;

	public Vehicle(String color, int noOfTyres, int model) {
		this.color = color;
		this.noOfTyres = noOfTyres;
		this.model = model;
	}

	public void StartEngine() {
		System.out.println("Engine Started");
	}

	public void ApplyBreak() {
		System.out.println("Brakes are applied");
	}

	public void Accelerate() {
		System.out.println("Vehicle Moves");
	}
}

class Truck extends Vehicle {

	public Truck(String color, int noOfTyres, int model) {
		super(color, noOfTyres, model);
		// TODO Auto-generated constructor stub
	}

	public void CarryLoad() {
		System.out.println("Truck is carrying Load");
	}

}

class Car extends Vehicle {
	public Car(String color, int noOfTyres, int model) {
		super(color, noOfTyres, model);
		// TODO Auto-generated constructor stub
	}

}

class Bus extends Vehicle {
	public Bus(String color, int noOfTyres, int model) {
		super(color, noOfTyres, model);
		// TODO Auto-generated constructor stub
	}

}
