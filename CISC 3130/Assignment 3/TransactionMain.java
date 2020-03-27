/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #3
 *  
 * "XYZ Widget Store" receives shipments of widgets at various costs.
 * The store's policy is FIFO and to charge a 30% markup on items sold.
 * Program reads data from master file and utilizes linked lists and queues.
 * LinkedList contains Transaction objects
 * Transaction class calculates sales revenue and applies any applicable discounts.
 * Total revenue and total widgets sold are printed at the end of the program 
 * If applicable, remaining inventory is also printed.
 */

package assignment2;

import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;

public class TransactionMain {
	public static void main(String[] args) throws Exception  {
		Scanner sc = new Scanner(new File("master"));
		LinkedList <Transaction> list = new LinkedList<Transaction>();
		double promotion = 0;
		boolean usePromo = false;
		int promoCount = 0;
		double totalQuantity = 0;
		double totalRevenue = 0;
		
		while(sc.hasNextLine()) {
			// Create new Transaction object with data read from file
			Transaction transaction = new Transaction(sc.next(), sc.nextDouble(), sc.nextDouble());
//			print(transaction, transaction.recordType);		
			if(transaction.recordType.matches("S")) { 
				// *** CHECKS PROMOTION STATUS ***
				if(usePromo == true) {
					// Count increases by 1
					promoCount++;
					// Check widget quantity in first node
					if(transaction.quantity < list.getFirst().quantity) {
						list.getFirst().setQuantity(list.getFirst().quantity - transaction.quantity);
						// Complete sale and use discount 
						list.getFirst().sale(transaction.quantity);
						list.getFirst().useDiscount(promotion);
						// Add quantity sold to totalQuantity variable
						totalQuantity += transaction.quantity;
						System.out.printf("%.0f at $%.2f each -- Sales: $%.2f", transaction.quantity, list.getFirst().price,  
								list.getFirst().getRevenue()); 
						// Add revenue from transaction to totalRevenue variable
						totalRevenue += list.getFirst().getRevenue();		
					} else if(transaction.quantity == list.getFirst().quantity) {
						// Complete sale and use discount
						list.getFirst().sale(transaction.quantity);
						list.getFirst().useDiscount(promotion);
						totalQuantity += list.getFirst().quantity;
						System.out.printf("%.0f at $%.2f each -- Sales: $%.2f", list.getFirst().quantity, list.getFirst().price,
								list.getFirst().revenue);
						list.getFirst().setQuantity(list.getFirst().quantity - transaction.quantity);
						// Add revenue from transaction to totalRevenue variable and remove node from list
						totalRevenue += list.pop().getRevenue();
					} else {
						// Complete sale and use discount
						list.getFirst().sale(list.getFirst().quantity);
						list.getFirst().useDiscount(promotion);
						totalQuantity += list.getFirst().quantity;
						System.out.printf("%.0f at $%.2f each -- Sales: $%.2f \n", list.getFirst().quantity, list.getFirst().price,
								list.getFirst().revenue);
						list.getFirst().setQuantity(transaction.quantity - list.getFirst().quantity);
						System.out.printf("Remainder of %.0f widgets not available\n", list.getFirst().quantity);
						// Set quantity in node to zero
						list.getFirst().setQuantity(0);
						// Add revenue from transaction to totalRevenue variable and remove node from list
						totalRevenue += list.pop().getRevenue();
					}
					
					// Check if discount has been twice; if it has reset it
					if(promoCount == 2) {
						promoCount = 0;
						usePromo = false;
						promotion = 0;
					}
					
				} else {
					// Check widget quantity in first node
					if(transaction.quantity < list.getFirst().quantity) {
						list.getFirst().setQuantity(list.getFirst().quantity - transaction.quantity);
						// Complete sale
						list.getFirst().sale(transaction.quantity);
						// Add quantity sold to totalQuantity variable
						totalQuantity += transaction.quantity;
						System.out.printf("%.0f at $%.2f each -- Sales: $%.2f", transaction.quantity, list.getFirst().price,
							list.getFirst().getRevenue()); 
						// Add revenue from transaction to totalRevenue variable
						totalRevenue += list.getFirst().getRevenue();
				
					} else if(transaction.quantity == list.getFirst().quantity) {
						list.getFirst().sale(transaction.quantity);
						totalQuantity += list.getFirst().quantity;
						System.out.printf("%.0f at $%.2f each -- Sales $%.2f", list.getFirst().quantity, list.getFirst().price,
								list.getFirst().revenue);
						list.getFirst().setQuantity(list.getFirst().quantity - transaction.quantity);
						// Add revenue from transaction to totalRevenue variable and remove node from list
						totalRevenue += list.pop().getRevenue();
						
					} else {
						list.getFirst().sale(list.getFirst().quantity);
						totalQuantity += list.getFirst().quantity;
						System.out.printf("%.0f at $%.2f each -- Sales: $%.2f \n", list.getFirst().quantity, list.getFirst().price, 
								list.getFirst().revenue);
						list.getFirst().setQuantity(transaction.quantity - list.getFirst().quantity);
						System.out.println("Remainder of " + list.getFirst().quantity + " widgets not available");
						// Set quantity in node to zero
						list.getFirst().setQuantity(0);
						// Add revenue from transaction to totalRevenue variable and remove node from list
						totalRevenue += list.pop().getRevenue();
					}

				}
			} else if(transaction.recordType.matches("R")) {
				// Add widget shipment to rear of list
				list.addLast(transaction);
				// Insert into warehouse
				System.out.println(transaction.toString());
			} else if(transaction.recordType.matches("P")) {
				System.out.println("Discount: " + transaction.getDiscount() * 100 + "% off next two purchases");
				// Set promotion value
				usePromo = true;
				promotion = transaction.quantity;	// *** REALLY DISCOUNT ***
			}
			blank();
			
		}
		
		System.out.println("### FINAL TOTAL ###");
		System.out.printf("%.0f Widgets sold \n", totalQuantity);
		System.out.printf("Total Sales: $%.2f \n", totalRevenue);
		
		// If applicable, print remaining inventory 
		if(list.size() > 0) {
			System.out.println("\n### REMAINING INVENTORY ###");
			remaining(list);
		}
		
		
		sc.close();
	}
	
	/* remaining: Prints quantity and price values in remaining nodes */
	public static void remaining(LinkedList<Transaction> list) {
		int size = list.size();
		for(int i = 0; i < size; i++) {
			System.out.println(list.pop());
		}
	}
	
	/* print: Prints data from file */
	public static void print(Transaction transaction, String type) {
		System.out.println(transaction.recordType + " " + transaction.quantity + 
				" " + transaction.price);
	}
	
	/* blank: Prints an empty line */
	public static void blank() {
		System.out.println();
	}
	
}
