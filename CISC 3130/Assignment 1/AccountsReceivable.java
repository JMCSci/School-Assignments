/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #1
 *  
 * "ABC" Hardware Company" has hired me to write a program for its Accounts Receivable department 
 * Program reads in records from two separate files
 * Transaction file used to update master file
 * Uses OOP
 */

package assignment1;

import java.util.Scanner;
import java.io.File;

public class AccountsReceivable {
	public static void main(String[] args) throws Exception {
		File file1 = new File("masterFile");
		Scanner sc1 = new Scanner(file1);
			
		File file2 = new File("transactionFile");
		Scanner sc2 = new Scanner(file2);
		
		// Update master file balance
		// Byte indices 25, 61, 97, 133, 169, 205, ... (n + 36)
		int seekIndex = 0;
		
		/* Pass scanner as argument so that tokens are read sequentially */
		Account account1 = new Account();
		seekIndex = 25;
		account1.getTransaction(sc1, sc2, seekIndex);
		account1.invoice();
	//	account1.readTransaction(1);  		// can be used to read individual transactions
		
		Account account2 = new Account();
		seekIndex = account2.getTransaction(sc1, sc2, (seekIndex + 36));
		account2.invoice();
		
		Account account3 = new Account();
		seekIndex = account3.getTransaction(sc1, sc2, (seekIndex + 36));
		account3.invoice(); 
		
		Account account4 = new Account();
		seekIndex = account4.getTransaction(sc1, sc2, (seekIndex + 36));
		account4.invoice();
		
		Account account5 = new Account();
		seekIndex = account5.getTransaction(sc1, sc2, (seekIndex + 36));
		account5.invoice();
		
		Account account6 = new Account();
		seekIndex = account6.getTransaction(sc1, sc2, (seekIndex + 36));
		account6.invoice();
		
		Account account7 = new Account();
		seekIndex = account7.getTransaction(sc1, sc2, (seekIndex + 36));
		account7.invoice();
		
		sc1.close();
		sc2.close();
	}

}
