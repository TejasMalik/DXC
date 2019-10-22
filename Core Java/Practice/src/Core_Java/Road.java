package Core_Java;

public class Road {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck truck = new Truck("Red", 6, 100);
		Car car = new Car("Yellow", 4, 101);
		Bus bus = new Bus("Green", 6, 102);
		
		truck.Accelerate();
		car.ApplyBreak();
		bus.StartEngine();
		
		truck.CarryLoad();
		
	}

}
