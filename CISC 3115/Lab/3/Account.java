/* CISC 3115 - Lab #3
 * Jason Moreau
 * 
 * Account class
 * Class contains constructors and methods to create a name and balance object
 * 
 */

package account;

public class Account {
	private String name;
	private double balance;
	
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
	
	// Getter: getName
	public String getName() {
		return name;
	}
	
	// Getter: getBalance
	public double getBalance() {
		return balance;
	}
	
	
	/* METHOD: printData
	 * Print data
	 */
	public String toString() {
		return name + "\t" + "$" + balance;
		
	}
	

}
