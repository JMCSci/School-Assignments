/* Transaction class
 * Transaction class also calculates sales revenue and applies any applicable discounts.
 */

package assignment2;

import java.text.DecimalFormat;

public class Transaction {
	String recordType = "";
	double quantity = 0;
	double price = 0;
	double revenue = 0;
	double discount = 0;
	final double MARKUP = 0.30;
	double totalRevenue = 0;
	
	Transaction() {
		
	}
	
	Transaction(String recordType, double quantity, double price) {
		this.recordType = recordType;
		this.quantity = quantity;
		this.price = price;
		// Sets discount value if transaction is a Promotion
		if(this.recordType.matches("P")) {
			this.discount = quantity;
		}
	}
	
	/* sale: Calculates revenue along with markup */
	void sale(double transactionQuantity) {
		revenue = (price * transactionQuantity); // price * quantity
		revenue += (revenue * MARKUP); 	// Revenue plus markup
	}
	
	/* useDiscount: Applies discount to sale */
	void useDiscount(double discount) {
		revenue -= (revenue * discount);
	}
	
	
	void setQuantity(double newValue) {
		quantity = newValue;
	}
	
	double getDiscount() {
		return discount;
	}
	
	
	double getQuantity() {
		return quantity;
	}
	
	
	double getRevenue() {
		return revenue;
	}
	
	double getTotalRevenue() {
		return totalRevenue;
	}
	
	/* toString: Overridden toString method */
	public String toString() {
		DecimalFormat p = new DecimalFormat("##.00");
		DecimalFormat q = new DecimalFormat("##.##");
		String x = "Quantity: " + q.format(quantity) + ", Price: $" + p.format(price);
		return x;
	} 
	
	

}
