/**
 * @date February 2, 2019
 * @author Tiffany Taghvaiee 
 * 
 * CMPT 202- Homework #2: Snowman
 *Snowman is a spelling game whereby the computer chooses a random word,
 *and the player must guess it within 6 tries. For each incorrect guess, 
 *a new part of the snowman is constructed. If the player cannot correctly 
 *guess the word within 6 tries, an entire snowman is completed, and the player loses. 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Snowman {
	//this list will reference words.txt
	List<String> wordList = new ArrayList<String>();

	//Reads in the list of words
	public void readWords(String fileName) throws FileNotFoundException {
		Scanner s = new Scanner(new File(fileName));

		while (s.hasNext())
			wordList.add(s.next());

		s.close();
	}


	//Selects a random word from the list and returns it.
	public String getWord() {

		Random r = new Random();

		return wordList.get(r.nextInt(wordList.size()));
	}

	// Plays the game (:
	public void playGame(String word) {
		char nextChoice;
		char[] wordArray = word.toCharArray();
		char [] output = word.toCharArray();
		ArrayList guesses = new ArrayList();
		int numberOfWrongGuesses = 0;

		//Outputs initial game board
		for (int i = 0; i < word.length(); i++) {
			output[i] = '_';
			System.out.print(" " + output[i] + " ");
		}
		System.out.println();

		//Reads players input
		Scanner reader = new Scanner(System.in);

		while (true) {
			//Retrieves next letter
			System.out.print("Select a letter: ");
			nextChoice = reader.next().charAt(0);

			/*
			 * If they enter a character other than 'a ... z' or 'A ... Z' 
			 * you simply ignore the input value and prompt again. 
			 * 
			 * If they enter '$' as a character, you do not check to see if it 
			 *  occurs in the word, nor do you count it against one of their guesses.
			 */
			if ((nextChoice >= 'a' && nextChoice <= 'z') || (nextChoice >= 'A' && nextChoice <= 'Z')) {
				nextChoice = Character.toLowerCase(nextChoice); //make lowercase

				if (!guesses.contains(nextChoice)) {
					guesses.add(nextChoice);
					if (contains(wordArray, nextChoice)) {
						System.out.println(" ");

						for (int i=0; i < word.length(); i ++) {
							if (wordArray[i] == nextChoice) {
								output[i] = nextChoice;
							}
						}
					}
					else {
						System.out.println(nextChoice + " does not appear");
						System.out.println(" ");
						numberOfWrongGuesses++; 
					}

					//Outputs new game board
					for (int i = 0; i<word.length(); i++) {
						System.out.println(" " + output[i] + " ");
					}
					System.out.println(" ");
					System.out.println("Incorrect guesses = " + numberOfWrongGuesses);

					//if-else statement that outputs whether the player won or lost
					//stops game
					if(equals(wordArray, output)) {
						System.out.println("Congratulations, you won!");
						break; 
					}

					if (numberOfWrongGuesses == 6) {
						System.out.println("I'm sorry, you lost! The word was " + word);
						break; 
					}
				}
				else {
					System.out.println("You already guessed that!");
				}

			}
			else {
				System.out.println("Please input letters only!");
			}

		}
	}

	//main method (:
	public static void main(String[] args) {
		Snowman game = new Snowman();

		try {
			game.readWords("words.txt");
			game.playGame(game.getWord());
		} catch (FileNotFoundException fnf) {
			System.err.println("words.txt file Not Found");
		}


	}
	//equals helper method
	public boolean equals (char[] wordArray, char[] output) {
		int numberOfCorrectLetters = 0;
		for (int i=0; i<wordArray.length; i++) {
			if (wordArray[i] == output[i]) {
				numberOfCorrectLetters++;
			}
		}
		if (numberOfCorrectLetters == wordArray.length) {
			return true; //returns true for correct answers
		}
		else {
			return false; //returns false for incorrect answers
		}
	}
	//contains helper method
	public boolean contains(char[] wordArray, char nextChoice) {
		for (int i = 0; i < wordArray.length; i++) {
			if (wordArray[i] == nextChoice) {
				return true;
			}
		}
		return false;
	}

}
