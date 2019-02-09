
/*This program allows you to flip a coin.
Tiffany Taghvaiee CMPT 202-Lab #1 (January 17, 2019)
*/

public class GenericCoin {
	
public enum CoinSide{HEADS, TAILS}; //enumerated data type; maintains the side (heads/tails)
CoinSide side; //enumerated instance variable

public GenericCoin() {  //constructor
	side= CoinSide.HEADS;
}

public void setToHeads() { //sets the coin to heads
side= CoinSide.HEADS;
}

public void setToTails() { //sets the coin to tails
side= CoinSide.TAILS; 
}

public void toss() { //sets the coin randomly to heads/tails 50% of the time
double random= java.lang.Math.random(); 
if(random>=0 && random<.5) {
side= CoinSide.HEADS;
}
else {
side= CoinSide.TAILS; 
}		
}

public boolean isHeads() { //returns true if the coin is heads
	boolean b= true;
	if(side==CoinSide.HEADS) {
		b=true;
	}
	else {
		b=false;
	}
	return b;
}

public boolean isTails() { //returns true if the coin is tails
	boolean b= true;
	if(side==CoinSide.TAILS) {
		b=true;
}
	else {
		b=false;
	}
	return b;
}

public String toString() { //returns the String “heads” or “tails” based on the side coin.
	return "Side is" + side;
}
}



