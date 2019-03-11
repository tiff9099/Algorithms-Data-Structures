/**
 * Tiffany Taghvaiee & Elsa Sveen
 * This program determines whether or not a string entered is a palindrome. 
 */

import java.util.Scanner; 

public class NewPalindromeChecker
{
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		String message = null;
		do {
			System.out.println("Enter a string:");

			message = scan.nextLine();
			//System.out.println("*"+message);

			//creates 1 stack, 1 queue
			Stack<Character>forward = new ArrayStack<Character>();
			Queue<Character> reverse = new ListQueue();
			boolean isPalindrome = true;

			//adds characters of input to forward stack
			for (int i=0; i< message.length(); i++) {
				forward.push(message.charAt(i)); //
			}

			//adds characters of input in reverse to reverse stack
			for (int i = 0; i < message.length(); i++) { //?
				reverse.add(message.charAt(i));
			}

			//compares forward & reverse stacks to see if it's a palindrome
			for (int i = 0; i< message.length(); i++) {
				if (forward.pop() != reverse.remove()) {
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
