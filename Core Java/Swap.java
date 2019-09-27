package Core_Java;

import java.util.Scanner;

public class Swap {
	public void display() {
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();

		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println("First Number:" + num1);
		System.out.println("Second Number:" + num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Swap obj = new Swap();
		obj.display();

	}
}
