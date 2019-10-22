package Core_Java;

import java.util.Scanner;

public class SumOfPositives {
	Scanner s = new Scanner(System.in);
	int num = 0;
	int sum = 0;
	int choice;
	int choiceCount = 1;
	int count = 0;

	public void display() {

		for (int i = 0; i < choiceCount; i++) {
			System.out.println("Please Enter number (between 0-100): " + (++count));
			num = s.nextInt();

			if (num > 100) {
				count--;
				choiceCount++;
				System.out.println("Number is more than 100");
				continue;
			}

			if (num < 0) {
				count--;
				choiceCount++;
				System.out.println("Negative numbers are not allowed");
				continue;

			}

			sum += num;

			System.out.println("Do you want to continue (1 to continue, any number to exit)");
			choice = s.nextInt();

			if (choice == 1) {
				choiceCount++;
			}
		}
		System.out.println("Your sum is" + sum);

	}

	public static void main(String[] args) {
		SumOfPositives obj = new SumOfPositives();
		obj.display();
		System.out.println("Thanks for using my program.");
	}
}
