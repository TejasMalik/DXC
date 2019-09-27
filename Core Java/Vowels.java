package Core_Java;

import java.util.Scanner;

public class Vowels {
	public void display() {
		Scanner s = new Scanner(System.in);
		char letter = s.next().charAt(0);

		if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
			System.out.println(letter + " is a vowel");
		} else {
			System.out.println(letter + " is not a vowel");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vowels obj = new Vowels();
		obj.display();

	}
}
