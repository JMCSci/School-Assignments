/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #1
 *  
 * "ABC" Hardware Company" has hired me to write a program for its Accounts Receivable department 
 * Program reads accounts from master file and account transactions from transaction file 
 * Account balances in master file are updated when read in from transaction file 
 * Invoice is printed for each account detailing all transactions made along with balances due
 * This program uses an OOP design approach and features only one array (Arraylist) to store account transactions
 */

package assignment1;

import java.util.Scanner;
import java.io.File;

public class AccountsReceivable {
	public static void main(String[] args) throws Exception {
		File master = new File("master");
		Scanner sc1 = new Scanner(master);
			
		File transaction = new File("transaction");
		Scanner sc2 = new Scanner(transaction);
		
		// Update master file balance
		// Byte indices 25, 61, 97, 133, 169, 205, ... (n + 36)
		int seekIndex = 0;
		
		/* Pass scanner as argument so that tokens are read sequentially */
		Account account1 = new Account();
		seekIndex = 25;
		account1.inputTransaction(sc1, sc2, seekIndex);
		account1.invoice();
		invoiceSeparator();
	//	account1.getTransaction(1);  		// can be used to read individual transactions
		
		Account account2 = new Account();
		seekIndex = account2.inputTransaction(sc1, sc2, (seekIndex + 36));
		account2.invoice();
		invoiceSeparator();
		
		Account account3 = new Account();
		seekIndex = account3.inputTransaction(sc1, sc2, (seekIndex + 36));
		account3.invoice();
		invoiceSeparator();
		
		Account account4 = new Account();
		seekIndex = account4.inputTransaction(sc1, sc2, (seekIndex + 36));
		account4.invoice();
		invoiceSeparator();
		
		Account account5 = new Account();
		seekIndex = account5.inputTransaction(sc1, sc2, (seekIndex + 36));
		account5.invoice();
		invoiceSeparator();
		
		Account account6 = new Account();
		seekIndex = account6.inputTransaction(sc1, sc2, (seekIndex + 36));
		account6.invoice();
		invoiceSeparator();
		
		Account account7 = new Account();
		seekIndex = account7.inputTransaction(sc1, sc2, (seekIndex + 36));
		account7.invoice();
		invoiceSeparator();
		
		sc1.close();
		sc2.close();
	}
	
	/* invoiceSeparator: Line break used to separate multiple invoices */
	public static void invoiceSeparator() {
		System.out.println("-----------------------------------------------\n");
	}

}

