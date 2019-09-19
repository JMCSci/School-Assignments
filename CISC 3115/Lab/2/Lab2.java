/* LAB #2
 * Program reads in name and balance
 * Prints the accounts
 * Sorts the accounts
 * Prints account again 
 * Prints all of the balance
 */

package lab_2;

import java.util.Scanner;
import java.io.File;

public class Lab_2 {
	public static void main(String[] args) throws Exception {
		String [] name = new String [5];
		double [] balance = new double [5];
		inputData(name, balance);
		printArrays(name, balance);
		emptyLine();
		sortArrays(name, balance);
		printArrays(name, balance);
		totalBalance(balance);

	}
	
	/* METHOD: emptyLine
	 * Prints an empty line to the console
	 */
	public static void emptyLine() {
		System.out.println();
	}
	
	
	/* METHOD: inputData
	 * Adds data to arrays
	 */
	public static void inputData(String name[], double balance[]) throws Exception {
		Scanner inputName = new Scanner(new File("name.txt"));
		Scanner inputBalance = new Scanner(new File("balance.txt"));
		// input data for names
		for(int i = 0; i < name.length; i++) {
			name[i] = inputName.next();
			balance[i] = inputBalance.nextDouble();
			inputName.close();
			inputBalance.close();
		}
		
	}
	
	/* METHOD: sortArrays
	 * Sorts both the name and balance arrays
	 */
	public static void sortArrays(String name[], double balance[]) {
		String temp1 = null;
		double temp2;
		// Bubble sort
		for(int i = 0; i < name.length - 1; i++) {
			for(int j = 0; j < name.length - 1; j++) {
				if(name[j].charAt(0) > name[j+ 1].charAt(0)) {
					temp1 = name[j]; 
					temp2 = balance[j];
					name[j] = name[j + 1];
					balance[j] = balance[j + 1];
					name[j + 1] = temp1;
					balance[j + 1] = temp2;
				}
				
			}
			
		}
	}
	
	/* METHOD: printArrays
	 * Print arrays
	 */
	public static void printArrays(String name[], double balance[]) {
		for(int i = 0; i < name.length; i++) {
			System.out.printf("\n" + name[i] + "\t" + "$%.2f", balance[i]);
		}

	}
	
	/* METHOD: totalBalance
	 * Returns the total balance of all the arrays
	 */
	public static void totalBalance(double balance[]) {
		double totalBalances = 0;
		for(int i = 0; i < balance.length; i++) {
			totalBalances = balance[i] + totalBalances;
		}
		System.out.printf("\n\nThe total balance in the array is: $%.2f", totalBalances);
	}

}
