/**
 * Tiffany Taghvaiee & Elsa Sveen
 * This program determines whether or not a string entered is a palindrome. 
 */

import java.util.Scanner; 

public class PalindromeChecker
{
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String message = null;
		do {
			System.out.println("Enter a string:");

			message = scan.nextLine();
			//System.out.println("*"+message);

			//creates 2 stacks
			Stack<Character>forward = new ArrayStack<Character>();
			Stack reverse = new ArrayStack();
			boolean isPalindrome = true;

			//adds characters of input to forward stack
			for (int i=0; i< message.length(); i++) {
				forward.push(message.charAt(i)); //
			}

			//adds characters of input in reverse to reverse stack
			for (int i = message.length(); i > 0; i--) { //?
				reverse.push(message.charAt(i-1));
			}

			//compares forward & reverse stacks to see if it's a palindrome
			for (int i = 0; i< message.length(); i++) {
				if (forward.pop() != reverse.pop()) {
					isPalindrome = false;
				}
			}
			if (isPalindrome == true) {
				System.out.println(message + " is a palindrome!");
			}
			if (isPalindrome == false) {
				System.out.println(message + " is not a palindrome.");
			}
		}
		while (message.length() != 0);
		scan.close();
	}
}





