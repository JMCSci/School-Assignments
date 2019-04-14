/* Jason Moreau
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #5
 * 
 * This program will simulate playing a game of dice by utilizing several methods.
 * If the user rolls a 7 or 11, the player wins. If the user rolls a 2 or 12, the player loses. 
 * The program will then prompt the user to play again or end the game. 
 * If the user rolls any other number, the player MUST play another game until they win.
 * The user can end the game if they enter ZERO for Die 1.
 */

package hw5;

import java.util.Scanner;

public class HW5 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int die1, die2, dieReturn = 0;
		System.out.print("Input an integer between 1 and 6 for Die 1: ");
		die1 = input.nextInt();
		// checks die roll to see if user input is between 1 and 6
		if(die1 < 0 || die1 > 6) {
			while(die1 < 0 || die1 > 6) {
				System.out.print("Please enter a valid number from 1 - 6: ");
				die1 = input.nextInt();
			}
		} else 
			
			while(die1 > 0) {	
				System.out.println("Die 1 is: " + die1);
				System.out.print("Input an integer between 1 and 6 for Die 2: ");
				die2 = input.nextInt();
				// checks die roll to see if user input is between 1 and 6
				if(die2 < 0 || die2 > 6) {
					while(die2 < 0 || die2 > 6) {
					System.out.print("Please enter a valid number from 1 - 6: ");
					die2 = input.nextInt();
					}
				} else
				System.out.println("Die 2 is: " + die2);
				// value returned by outcome method is saved and used to determine message that will be printed
				dieReturn = outcome(die1, die2);
				// roll 2 or 12 -- player loses 
				if(dieReturn == 2 || dieReturn == 12) {
					System.out.println("Sorry, you lose. Play again?\n");
				}
				// roll 7 or 11 -- player wins 
				else if(dieReturn == 7 || dieReturn == 11) {
					System.out.println("YOU WIN!!! Play again?\n"); 
				} 	
				// roll any other number -- player must continue 
				else if(dieReturn != 7 || dieReturn != 11 || dieReturn != 2 || dieReturn != 12) {
						System.out.println("Sorry, you lose. Please try again.\n");
						continueGame(dieReturn);
				}
				System.out.print("Input an integer between 1 and 6 for Die 1 or enter ZERO to stop. ");
				die1 = input.nextInt();
				}
			System.out.println("\n----GAME OVER----");
			input.close();
			}
	
	// Method outcome -- returns sum of Die 1 and Die 2
	public static int outcome(int die1, int die2) {
		int sum, dieSum = 0;
		sum = die1 + die2;
		if(sum == 2 || sum == 12) {
			dieSum = sum;
		}
		if(sum == 7 || sum == 11) {
			dieSum = sum;
		} 	
		if(sum != 7 || sum != 11 || sum != 2 || sum != 12) {
				dieSum = sum;
		}
		return dieSum;
	}
	
	// Method: continueGame -- user plays game until they win
	public static void continueGame(int dieSum) {
		Scanner input = new Scanner(System.in);
		int die3, die4, result; 
		System.out.println("Input an integer between 1 and 6 for Die 3: ");
		die3 = input.nextInt();
		// checks die roll to see if user input is between 1 and 6
		if(die3 < 0 || die3 > 6) {
			while(die3 < 0 || die3 > 6) {
			System.out.print("Please enter a valid number from 1 - 6: ");
			die3 = input.nextInt();
			}
		} else
		System.out.println("Die 3 is: " + die3);
		
		while(die3 > 0) {
		System.out.println("Input an integer between 1 and 6 for Die 4: ");
		die4 = input.nextInt();
		// checks die roll to see if user input is between 1 and 6
		if(die4 < 0 || die4 > 6) {
			while(die4 < 0 || die4 > 6) {
			System.out.print("Please enter a valid number from 1 - 6: ");
			die4 = input.nextInt();
			}
		} else
		System.out.println("Die 4 is: " + die4);
		result = die3 + die4; 
		if(result == 7) {
			System.out.println("You lose.\n");break;
		}
		if(result != 7 || result != dieSum) {
			System.out.println("Sorry, you lose. Please try again.\n");
		}
		if(result == dieSum) {
			System.out.println("YOU WIN!!!\n");break;
		}
		System.out.println("Input an integer between 1 and 6 for Die 3: ");
		die3 = input.nextInt(); 
		}
	}
}
