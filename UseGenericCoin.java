
/*[Tiffany Taghvaiee]
 *This program tests the GenericCoin class by tossing 2 coins 100 times each and then reporting the 
 *differences between the number of heads between the two coins. 
/*/

public class UseGenericCoin {

	//main method to test GenericCoin class
	@Test
	public static void main(String[]args) {
		GenericCoin coin1 = new GenericCoin(); //creates coin1 with type GenericCoin
		GenericCoin coin2 = new GenericCoin(); //creates coin2 with type GenericCoin

		int heads1 = 0; 
		int heads2 = 0;
		for (int i=0; i<100; i++) { //for loop that tosses both coins 100 times each
			coin1.toss();
			if(coin1.isHeads() == true) {
				heads1++;
			}
			coin2.toss();
			if(coin2.isTails()== true) {
				heads2++;
			}
		}

		if (heads1 > heads2) { //reports the % of heads for the 1st coin  
			int heads= heads1-heads2;
			System.out.println("The 1st coin was heads"+heads+ "more times.");
		}
		else if (heads2 > heads1) { //reports the % of heads for the 2nd coin
			int heads= heads2-heads1;
			System.out.println("The 2nd coin was heads"+heads+ "more times.");
		}
		else { //reports if results were equal for both coins
			System.out.println("Both coins had the same number of heads.");
		}
	}
}
