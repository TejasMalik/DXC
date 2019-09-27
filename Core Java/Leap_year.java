package Core_Java;

import java.util.Scanner;

public class Leap_year {
	public void display() {
		Scanner s = new Scanner(System.in);
		int year = s.nextInt();

		if (year % 4 == 0 && year % 100 != 0) {
			System.out.println(year + " is a leap year");
		} else {
			System.out.println(year + " is not a leap year");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leap_year obj = new Leap_year();
		obj.display();

	}
}
