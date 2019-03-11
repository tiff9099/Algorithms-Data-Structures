/**
 * Plays Greedy Coin game such that the computer never loses.
 * @author Tiffany Taghvaiee
 */
import java.io.*;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class GreedyCoinGame {
	List<Integer> list = new LinkedList<Integer>();
	int computerScore = 0;
	int playerScore = 0;

	public GreedyCoinGame(String file) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File(file));

		while (inFile.hasNext()) {
			list.add(inFile.nextInt());
		}

		inFile.close();
	}

	// prints the coins and their position
	public void printCoins() {
		//print out each element and its position in the linked list
		System.out.println("+++++++++++");
		System.out.println("Coins: " + list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println(" ");

		System.out.println(); //
		System.out.println("Positions: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " ");
		}
		
		System.out.println(" "); 
		System.out.println("Human:" + Integer.toString(playerScore) + "Computer:" + Integer.toString(computerScore));
		System.out.println("+++++++++++");
	}

	public void playGame() {
		// get the keyboard for the silly human
		Scanner keyboard = new Scanner(System.in);
		// TO-DO Play the game using the Red Blue strategy
		int red = 0;
		int blue = 0;
		int select;

		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				red = red + list.get(i);
			}
			else {
				blue = blue + list.get(i);
			}
		}

		if (red > blue) {
			select = 0;
		} 
		else {
			select = list.size()-1; 
		}
		
		System.out.println("Let's play the coin game!");
		printCoins();
		System.out.println(Integer.toString(select)); //?
		//System.out.println("Indicate the position of the coin you choose: ");
		//int playerChoice = keyboard.nextInt();
		computerScore += list.get(select);
		list.remove(select);
		printCoins();

		while(true) {
			int playerChoice = -1;
			while(playerChoice != list.size()-1 && playerChoice != 0) {
				System.out.println("Indicate the position of the coin you choose: ");
				playerChoice = keyboard.nextInt();
			}

			playerScore += list.get(playerChoice);
			list.remove(playerChoice);

			if (list.size() == 0) {
				System.out.println("Game Over! Final Score You: " + Integer.toString(playerScore) +  "Me: " + Integer.toString(computerScore));
				break;
			}
			printCoins();

			if (playerChoice == 0) {
				select = 0;
			} else {
				select = list.size() - 1;
			}
			System.out.println(Integer.toString(select));
			computerScore += list.get(select);
			list.remove(select);
			printCoins();
		}
		keyboard.close();
	}

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.err.println("Pass a file on the command line");
			System.exit(0);
		}
		
		GreedyCoinGame game = new GreedyCoinGame(args[0]);
		game.playGame();
	}
}
