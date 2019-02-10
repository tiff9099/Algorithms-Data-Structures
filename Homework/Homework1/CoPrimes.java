/*Tiffany Taghvaiee [Homework #1]
 * This program is passed 2 parameters representing the pairs to generate.
 * It generates the co-primes from (1,1) to (m,n).
 * Outputs results as a grid with * representing a co-prime pair
 */
 
import java.util.*; 

public class CoPrimes 
{
	//Main Method
	public static void main(String[]args) {
		if (args.length != 2) {
			System.err.println("Must be passed two integer values > 0");
			System.exit(0);
		}
		//Expects 2 parameters passed on the command line
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);

		/*
		 * Determines whether pair (m,n) is co-prime or not if gcd ==1
		 * An '*' appears if the coordinates (i,j) represent a co-prime, 
		 * or a space if it is not a co-prime pair
		 */
		for (int i = m; i > 0; i--) {
			for (int j = 1; j <= n; j++) {
				if (gcd(i,j) == 1) { //Euclidean method 
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.print("\n"); 
		}
	}

	//helper method for determining the GCD of a pair of numbers
	public static int gcd(int m, int n) {
		while(n != 0){
			int i;
			i= n;
			n = m%n;
			m = n;
		}
		return m;	
	}
}
