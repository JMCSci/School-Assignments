/* Account class
 * Reads and updates master file using transaction file
 * Creates a new Transaction object for an individual account
 * Each transaction is saved in a data structure -- ArrayList
 * Individual account transactions can be called using the getTransaction method
 * An invoice for each account can be printed to the console using the invoice method
 */

package assignment1;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.RandomAccessFile;
import java.io.EOFException;
import java.text.DecimalFormat;

public class Account {
	protected static String id = "";
	protected static String name = "";
	protected double initialBalance = 0;
	protected static double previousBalance = 0;
	protected static double finalBalance = 0;
	protected static int index = 0;
	protected static double runningTotal = 0;
	// Creates a dynamic array for each Account instance
	// List contains each transaction per account
	ArrayList<Transaction> list = new ArrayList<>();
	
	Account() {
		
	}
	
	public double getPreviousBalance() {
		return previousBalance;
	}
	
	public double getFinalBalance() {
		return finalBalance;
	}
	
	public double getRunningTotal() {
		return runningTotal;
	}
	
	public void setPreviousBalance(double newValue) {
		previousBalance = newValue;
	}
	
	public void setFinalBalance(double newValue) {
		finalBalance = newValue;
	}
	
	public void setRunningTotal(double newValue) {
		runningTotal = newValue;
	}
	
	/* inputTransaction: Retrieves and creates a transaction
	 * Reads from Scanner class 
	 * Creates a new Transaction object and updates balance in master file
	 */
	public int inputTransaction(Scanner sc1, Scanner sc2, int seekIndex) throws Exception, EOFException {		
		File file = new File("master");
		RandomAccessFile inout = new RandomAccessFile(file, "rw");
		DecimalFormat decimal = new DecimalFormat("##.00");

		// Reads in three tokens from master file and adds them to Account class instance variables
		id = sc1.next();
		name = sc1.next();
		previousBalance = sc1.nextDouble();
		
		initialBalance = previousBalance;

		Scanner scanner = new Scanner(new File("transaction"));
		String line = "";
		
		// Search file for id -- if there is a match, add line token to line variable (used in next while loop), if not, program ends
		while(scanner.hasNext()) {
			if(scanner.nextLine().startsWith(id)) {
				line = id.toString();
				break;
			} 
		}
		
		// Use matching id in file to get transaction data
		while(line.startsWith(id)) {
			// Start 2nd scanner when id equal to first token; inputs each token manually into variable; used in Transaction constructor
			sc2.next();
			String type = sc2.next();
			int tNumber = sc2.nextInt();
			String description = sc2.next();
			int quantity = sc2.nextInt();
			double itemPrice  = sc2.nextDouble();
			double transactionTotal = sc2.nextDouble();
			// Create transaction object and add it ArrayList
			Transaction transaction = new Transaction(id, type, tNumber, description, 
					quantity, itemPrice, transactionTotal);
			list.add(transaction);
			// If scanner contains another line continue reading and add line token to line variable and update file
			// Use line variable to check while condition
			// If next line doesn't exist, stop reading and update file
				if(scanner.hasNextLine()) {
					line = scanner.nextLine();
				} else {
					inout.seek(seekIndex);
					inout.writeBytes(decimal.format(finalBalance));
					break;
				}
				// Append file contents
				inout.seek(seekIndex);
				inout.writeBytes(decimal.format(finalBalance));
		}
		scanner.close(); 
		inout.close();
		return seekIndex;
	}
	
	/* invoice: Prints account invoice to console */
	public void invoice() {
		System.out.printf("%-10s %s \n", name, id);
		if(initialBalance < 0) {
			System.out.printf("Previous balance: %15s %.2f\n", "-$", Math.abs(initialBalance));
		} else {
			System.out.printf("Previous balance: %15s %.2f\n", "$", initialBalance);
		}
		
		emptyLine();
		for(Transaction text: list) {
			if(text.getType().contentEquals("P")) {
				System.out.printf("%-10s %-19s -$ %-10.2f \n", text.getNumber(), text.getDescription(), text.getTotal());
			} else {
				System.out.printf("%-10s %-20s $ %-10.2f \n", text.getNumber(), text.getDescription(), text.getTotal());
			}
		}
		emptyLine();
		if(finalBalance < 0) {
			System.out.printf("Balance owed: %19s $%.2f \n", "$", Math.abs(finalBalance));
		} else {
			System.out.printf("Balance due:  %19s %3.2f \n", "$", finalBalance);
		}
		emptyLine();
	}	
	
	/* getTransaction: Retrieves individual transactions */
	public void readTransaction(int transactionNumber) {
		System.out.println("\n" + list.get(transactionNumber).toString());
	}
	
	/* emptyLine: Prints a blank line (whitespace) */
	public void emptyLine() {
		System.out.println();
	}
	
}

