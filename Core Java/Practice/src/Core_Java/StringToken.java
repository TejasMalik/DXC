package Core_Java;

import java.util.StringTokenizer;

public class StringToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "Tejas:Divakar:Koushik:Yash";
		StringTokenizer str = new StringTokenizer(message, ":");
		int p = str.countTokens();
		for (int i = 1; i <= p; i++) {
			System.out.println((i) + " :  " + str.nextToken());
		}

		System.out.println("Total: " + p);
	}

}
