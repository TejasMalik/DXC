package Core_Java;

import java.util.Scanner;

public class KnowDate {

	public void display() {
		Scanner s = new Scanner(System.in);
		int num1 = s.nextInt();
		int num2 = s.nextInt();
		
		System.out.println(num1 + num2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnowDate obj = new KnowDate();
		obj.display();

		
	}

}
