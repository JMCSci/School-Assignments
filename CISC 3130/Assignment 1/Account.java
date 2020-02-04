/* Account class
 * Reads and updates master file using transaction file
 * Creates a new Transaction object for an individual account
 * Each transactions is saved in a data structure (ArrayList)
 * When necessary, an individual transaction can be called using the getTransaction method
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

	// Create a dynamic array for each Account instance
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
	
	/* getTransaction: Retrieves and creates a transaction
	 * Reads from Scanner class 
	 * Creates a new Transaction object and updates balance in master file
	 */
	public int getTransaction(Scanner sc1, Scanner sc2, int seekIndex) throws Exception, EOFException {		
		File file = new File("masterFile");
		RandomAccessFile inout = new RandomAccessFile(file, "rw");
		DecimalFormat decimal = new DecimalFormat("##.00");

		// Reads in three tokens from master file and adds them to Account class instance variables
		id = sc1.next();
		name = sc1.next();
		previousBalance = sc1.nextDouble();
		
		initialBalance = previousBalance;

		Scanner scanner = new Scanner(new File("transactionFile"));
		String line = "";
		
		// Search file for id -- use it to check parameter
		while(scanner.hasNext()) {
			if(scanner.nextLine().startsWith(id)) {
				line = id.toString();
				//System.out.println(line);
				break;
			}
		}
		
		while(line.startsWith(id)) {
			// Start 2nd scanner where id equal first token
			sc2.next();
			String type = sc2.next();
			int tNumber = sc2.nextInt();
			String description = sc2.next();
			int quantity = sc2.nextInt();
			double itemPrice  = sc2.nextDouble();
			double transactionTotal = sc2.nextDouble();
			
			Transaction transaction = new Transaction(id, type, tNumber, description, 
					quantity, itemPrice, transactionTotal);
			list.add(transaction);
			// If scanner contains another line continue and add to line string
			// Use line to check while condition
			// If not, stop
				if(scanner.hasNextLine()) {
					line = scanner.nextLine();
				} else {
					break;
				}
				
				// Append file contents
				 // -- finalBalance will be the initialBalance -- 
				inout.seek(seekIndex);
				inout.writeBytes(decimal.format(finalBalance));		
		}
		scanner.close(); 
		inout.close();
		return seekIndex;
	}
	
	/* readTransaction: Account invoice */
	public void invoice() {
		System.out.println(name + "\t" + id + "\t");
		System.out.printf("Previous balance: %.2f\n", initialBalance);
		emptyLine();
		for(Transaction text: list) {
			System.out.println(text.getId() + "\t" + text.getDescription() + "\t" + text.getPrice());
		}
		emptyLine();
		System.out.printf("Balance due: $%.2f \n", finalBalance);
		emptyLine();
	}	
	
	/* getTransaction: Used to retrieve individual transactions */
	public void getTransaction(int transactionNumber) {
		System.out.println("\n" + list.get(transactionNumber).toString());
	}
	
	public void emptyLine() {
		System.out.println();
	}
	
}
