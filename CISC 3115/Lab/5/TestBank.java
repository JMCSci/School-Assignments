/* CISC 3115 - Lab #5																
 * Jason Moreau																																				
 * Program reads in name and balance from two files (names.txt and balance.txt)		
 * Models an ATM; NO LOOP
 * When prompted, choose one of the following account names: Cobb, Fry, Miller, Ollie, Zee
 */

package lab5;

import java.io.File;
import java.util.Scanner;
import java.util.InputMismatchException;

public class TestBank {
	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(System.in);
		Account account = new Account();
		Bank bank = new Bank();
		Boolean start = true;
		String selection = null;
		String name = null;
		// Input data from file into bank
		inputData(bank);
		// Sort data
		sortData(bank);
		System.out.println("*****************************************");
		System.out.println("*    CISC 3115 Bank Management System   *");
		System.out.println("*****************************************");
		System.out.print("\nPlease enter your account name: ");
		name = input.next();
		name = capitalizeLetter(name);
		
			while(start) {
				// Validate name in Bank
				if(bank.accountLookup(name)) {
				// Set name in Account class
				account.setName(name);
				blankLine();
				System.out.println("*** MAIN MENU ***\n"); 
				System.out.println("I - Inquiry");
				System.out.println("D - Deposit");
				System.out.println("W - Withdrawal");
				System.out.println("Q - Quit\n");
				System.out.println("-----------------------------------------");
				System.out.print("\nSelection: ");
				selection = input.next();
				blankLine();
				// Capitalize letter
				selection = capitalizeLetter(selection);
				try {
					switch(selection) {
					case "I": account.setBalance(bank.find(name).getBalance());
						      System.out.println("Account Inquiry for " + account.getName());
							  System.out.printf("Balance: $%.2f" , account.getBalance());
							  blankLine();
							  break;
					case "D": System.out.print("Enter deposit amount: "); 
							  bank.find(name).deposit(input.nextDouble()); 
							  account.setBalance(bank.find(name).getBalance());
							  System.out.printf("New balance: $%.2f", account.getBalance());
							  blankLine();
							  break;
					case "W": System.out.print("Enter withdrawal amount: "); 
							  bank.find(name).withdrawal(input.nextDouble()); 
							  account.setBalance(bank.find(name).getBalance());
							  System.out.printf("New balance: $%.2f", account.getBalance());
							  blankLine();
							  break;
					case "Q": System.out.println("Bank Account Summary");
							  for(int i = 0; i < bank.getNum(); i++) {
							  System.out.println(bank.getAccounts()[i].toString());
						      }	
							  System.out.println("\nGoodbye");
							  start = false;
							  continue;
					default:  System.out.println(selection + ", is not a valid selection!");
							  break;
					}
					
				} catch (InputMismatchException ex) {
					blankLine();
					System.out.println("Invalid input. You must enter a number.");
					// Clear scanner 
					input.next();
					continue;
				}
					blankLine();
					System.out.println("*****************************************");
					System.out.println("*    CISC 3115 Bank Management System   *");
					System.out.println("*****************************************");
					System.out.print("\nPlease enter your account name: ");
					name = input.next();
					name = capitalizeLetter(name);
					continue;	
				}
				blankLine();
				System.out.println("Account not found. Please try again.");
				System.out.print("\nPlease enter your account name: ");
				name = input.next();
				name = capitalizeLetter(name);
				continue;
				}
			System.out.println("\n*** END OF PROGRAM ***");
			input.close();
	}
	
	/* METHOD: blankLine
	 * Prints a blank line to the console */
	public static void blankLine() {
		System.out.println();
	}
	
	/* METHOD: capitalizeLetter
	 * Capitalize letter */
	public static String capitalizeLetter(String word) {
		char temp1 = ' ';
		String temp2 = null; 
		temp1 = word.charAt(0);
		temp2 = Character.toString(temp1);
		temp2 = temp2.toUpperCase();
		word = temp2 + word.substring(1, word.length());
		return word;
	}
	
	/* METHOD: inputData 
	 * Reads in data from a file */
	public static void inputData(Bank bank) throws Exception {
		Scanner inputNames = new Scanner(new File("names.txt"));
		Scanner inputBalance = new Scanner(new File(("balances.txt")));
		String name = null;
		double balance = 0;
		
		while(inputNames.hasNext()) {
			name = inputNames.next();
			balance = inputBalance.nextDouble();
			bank.addAccount(name, balance);
		}
		inputNames.close();
		inputBalance.close();
	}
	/* METHOD: printData
	 * Print data in array */
	public static void printData(Bank bank) {
		for(int i = 0; i < bank.getNum(); i++) {
			System.out.println(bank.getAccounts()[i].toString());
		}
	}
	
	/* METHOD: sortArray
	 * Sort array using bubble sort algorithm */
	public static void sortData(Bank bank) {
		Account tempObj = null;
		for(int i = 0; i < bank.getNum(); i++) {
			for(int j = 0; j < bank.getNum() - 1; j++) {
				if(bank.getAccounts()[j].getName().charAt(0) > bank.getAccounts()[j + 1].getName().charAt(0)) {
					tempObj = bank.getAccounts()[j];
					bank.getAccounts()[j] = bank.getAccounts()[j + 1];
					bank.getAccounts()[j + 1] = tempObj;
				}
			}
		}
	}
	
}

