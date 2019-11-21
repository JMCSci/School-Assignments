/* Account class */

package lab5;

import java.text.DecimalFormat;

public class Account {
	// Format string value two decimal places
	DecimalFormat decimal = new DecimalFormat("#0.00");					
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
	public double withdrawal(double withdrawal) {
		if(amount <= balance) {
			balance = balance - withdrawal;
			if(balance < 0) {
				System.out.println("Account overdrawn. Please deposit funds as soon as possible.");
			}
		}
		return balance;
	}
	
	/* METHOD: deposit */
	public void deposit(double deposit) {
		balance = balance + deposit;
	}
	
	/* METHOD: toString
	 * Prints data with custom toString method */
	@Override
	public String toString() {
		return name + "\t" + "$" + decimal.format(balance);
	}
	

}
