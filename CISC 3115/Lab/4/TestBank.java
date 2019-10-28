/* CISC 3115 - Lab #4																
 * Jason Moreau																		
 * 																					
 * Program reads in name and balance from two files (names.txt and balance.txt)		
 * Program utilizes methods in Bank and Account classes								
 * Withdrawals are made to three accounts 											
 * Accounts in bank are printed to the console 
 */

package lab4;

import java.io.File;
import java.util.Scanner;

public class TestBank {
	public static void main(String[] args) throws Exception {
		Bank bank = new Bank();
		Account account = new Account();
		inputData(bank);
		sortData(bank);
		System.out.println("Bank Accounts"); 
		printData(bank);
		blankLine();
		// Set balance in Bank class with called account 
		bank.setBalance(bank.find("Miller").getBalance());
		// Set amount variable in Account class using Bank balance
		account.setAmount(bank.getBalance());
		// Set balance variable in Account class using Account amount
		account.setBalance(account.getAmount());
		// Set balance in Bank class using Account balance
		bank.setBalance(account.getBalance());
		System.out.println("Withdrawal Balance");
		// Find an account and initiate a withdrawal 
		bank.find("Miller").withdrawal(10);
		System.out.println(bank.find("Miller"));
		bank.find("Zee").withdrawal(750.75);
		System.out.println(bank.find("Zee"));
		bank.find("Fry").withdrawal(4.99);
		System.out.println(bank.find("Fry"));
		blankLine();
		System.out.println("Bank Accounts (updated)");
		// Print all accounts in Bank array
		for(int i = 0; i < bank.getNum(); i++) {
			System.out.println(bank.getAccounts()[i].toString());
		}	
	}
	
	/* METHOD: blankLine
	 * Prints a blank line to the console */
	public static void blankLine() {
		System.out.println();
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

