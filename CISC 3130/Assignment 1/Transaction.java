/* Transaction class
 * Creates a new transaction object
 * Object is stored in ArrayList in Account class
 * Individual transactions can be called with getTransaction method in Account class 
 */

package assignment1;

import java.text.DecimalFormat;

public class Transaction extends Account {
	protected String id = "";
	protected String type = "";
	protected int tNumber = 0;
	protected String description = "";
	protected int quantity = 0;
	protected double itemPrice = 0;
	protected double transactionTotal = 0;
	protected double balance = 0;
	DecimalFormat decimal = new DecimalFormat("##.00");
	
	// Creates a new transaction when called from Account class
	Transaction(String id, String type, int tNumber, String description, 
			int quantity, double itemPrice, double transactionTotal) throws Exception {
		this.id = id;
		this.type = type;
		this.tNumber = tNumber;
		this.description = description;
		this.quantity =  quantity;
		this.itemPrice  = itemPrice;
		this.transactionTotal = transactionTotal;
		calculate();
	}
	
	/* calculate: Processes transaction
	 * Used to update account balances in Account class
	 */
	public void calculate() {
		if(type.matches("O")) {
			// process order
		setRunningTotal(getPreviousBalance() + transactionTotal);
			this.setPreviousBalance(getRunningTotal());
		} else if(type.matches("P")) { 
			//process payment
			setRunningTotal(getPreviousBalance() - transactionTotal);
			setPreviousBalance(getRunningTotal());
		}
		setFinalBalance(runningTotal);
		
	}
	
	public String getId() {
		return id;
	}
	
	public String getType() {
		return type;
	}
	
	public int getNumber() {
		return tNumber;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getPrice() {
		return itemPrice;
	}
	
	public double getTotal() {
		return transactionTotal;
	}
	
	@Override
	/* toString: Used when calling individual transactions from Account class */
	public String toString() {
		return tNumber + "\t" + description + "\t" + decimal.format(transactionTotal);
	}
	
}

