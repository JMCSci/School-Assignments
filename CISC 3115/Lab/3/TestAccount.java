/* CISC 3115 - Lab #3
 * Jason Moreau
 * 
 * Program creates Account objects and saves them into an array
 * Reads in name and balance from two files (names.txt and balance.txt)
 * Prints the accounts in array
 * Sorts the accounts alphabetically
 * Prints account again 
 * Prints the total balance of the array
 * 
 */


package account;

import java.util.Scanner;
import java.io.File;

public class TestLab_3 {
	public static void main(String[] args) throws Exception {
		double arrayBalance = 0;
		// Create Account object array
		Account[] accountArray = new Account[5];
		
		inputData(accountArray);
		System.out.println("Unsorted Array");
		printArray(accountArray);
		emptyLine();
		sortArray(accountArray);
		System.out.println("Sorted Array");
		printArray(accountArray);
		emptyLine();
		arrayBalance = totalBalance(accountArray, arrayBalance);
		System.out.printf("Total array balance: %.2f", arrayBalance);

	}
	/* METHOD: inputData 
	 * Inputs data for file into array
	 */
	public static void inputData(Account accountArray[]) throws Exception {
		Scanner inputNames = new Scanner(new File("names.txt"));
		Scanner inputBalances = new Scanner(new File("balances.txt"));
				int i = 0;
				while(inputNames.hasNext()) {
					accountArray[i] = new Account();
					accountArray[i].setName(inputNames.next());
					accountArray[i].setBalance(inputBalances.nextDouble());
					i++;
				}
				inputNames.close();
				inputBalances.close();
	}
	
	/* METHOD: printArray
	 * Prints array
	 */
	public static void printArray(Account accountArray[]) {
		for(int j = 0; j < accountArray.length; j++) {
			System.out.println(accountArray[j].toString());
		}
	}
		
	/* METHOD: sortArray
	 * Sorts array - BUBBLE SORT (alphabetically)
	 */
	public static void sortArray(Account accountArray[]) {
		Account temp;
		for(int j = 0; j < accountArray.length - 1; j++) {
			for(int k = 0; k < accountArray.length - 1; k++) {
				if(accountArray[k].getName().charAt(0) > accountArray[k + 1].getName().charAt(0)) {
					temp = accountArray[k];
					accountArray[k] = accountArray[k + 1];
					accountArray[k + 1] = temp;						
				}
			}
		}	
	}
	
	/* METHOD: totalBalance
	 * Obtains array total balance
	 */
	public static double totalBalance(Account accountArray[], double arrayBalance) {
			for(int i = 0; i < accountArray.length; i++) {
				arrayBalance = accountArray[i].getBalance() + arrayBalance;
			}
			return arrayBalance;
		}
	
	/* METHOD: emptyLine
	 * Prints an empty line to the console
	 */
	public static void emptyLine() {
		System.out.println();
	}

}
