/*
 * This program is passed a decimal number on the command line
 * and outputs whether or not is a binary palindrome
 */
import java.util.Scanner;
public class IsBinaryPalindrome {

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String message;
		int messageInt;
		String messageFinal;
		
		do {
			System.out.println("Enter a palindrome:");
			message = scanner.nextLine();
			messageInt = Integer.parseInt(message);
			messageFinal = Integer.toBinaryString(messageInt);
	
			PalindromeChecker.main(messageFinal); 
		}
		while (message.length() != 0);
		scanner.close();
	}
}
