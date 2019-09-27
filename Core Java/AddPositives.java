package Core_Java;

import java.util.Scanner;

public class AddPositives {
	public void display() {
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();

		if (num1 < 0 || num2 < 0) {
			System.out.println("Numbers are negative");
			return;
		}

		System.out.println("Addition is: " + (num1 + num2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddPositives obj = new AddPositives();
		obj.display();

	}
}
