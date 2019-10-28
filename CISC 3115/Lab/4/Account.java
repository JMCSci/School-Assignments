/* Account class */

package lab4;

import java.text.DecimalFormat;

public class Account {
	DecimalFormat decimal = new DecimalFormat("#0.00");					// format string value two decimal places
	private String name = null;
	private double balance = 0;
	private double amount = 0;
	
	// No-arg constructor
	Account() {
		
	}
	
	// Argument constructor
	Account(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	
	// Setter: setName
	public void setName(String newValue) {
		name = newValue;
	}
	
	// Setter: setBalance
	public void setBalance(double newValue) {
		balance = newValue;
	}
	
	// Setter: setAmount
	public void setAmount(double newValue) {
		amount = newValue;
	}
	
	// Getter: getAmount
	public double getAmount() {
		return amount;
	}
	
	// Getter: getName
	public String getName() {
		return name;
	}
	
	// Getter: getBalance
	public double getBalance() {
		return balance;
	}
	
	/* METHOD: withdrawal */
	public double withdrawal(double newValue) {
		if (amount <= balance) {
			balance = balance - newValue;
		}
		return balance;
	}
	
	/* METHOD: printData
	 * Prints data with custom toString method */
	@Override
	public String toString() {
		return name + "\t" + "$" + decimal.format(balance);
		
	}
	

}
