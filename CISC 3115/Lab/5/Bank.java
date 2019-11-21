/* Bank class */

package lab5;

public class Bank {
	private int n = 0;									
	// Balance of account
	private double balance = 0;							
	// Names of account
	private String name = null;							
	Account [] accountArray = new Account[100];
	
	// No-arg constructor
	Bank() {
	
	}
	
	// Setter: Set setBalance
	public void setBalance(double newValue) {
		this.balance = newValue;
	}
	
	// Setter: Set setName
	public void setName(String newValue) {
		this.name = newValue;
	}
	
	// Getter: getBalance
	public double getBalance() {
		return balance;
	}
	
	// Getter: getName
	public String getName() {
		return name;
	}
	
	// Getter: getNum
	public int getNum() {
		return n;
	}
	
	/* METHOD: getAccounts 
	 * Returns array */
	public Account[] getAccounts() {
		return accountArray;
	}
	
	/* METHOD: addAccount
	 * Creates a new Account object (using an argument constructor) and adds it to array
	 * n-variable used as a counter for the number of accounts in the array */
	public void addAccount(String name, double balance) {
		accountArray[n] = new Account(name, balance); 
		n++;
	}
	
	/* METHOD: find
	 * Checks if name in object matches name in parameter
	 * If it does, the object in the array is returned 
	 * If not, nothing is returned */
	public Account find(String name) {
		for(int i = 0; i < n; i++) {
			if(accountArray[i].getName().equals(name)) {
				return accountArray[i];
			}
		}
		return null;
	}
	
	/* METHOD: accountLookup
	 * Checks if name in object matches name in parameter
	 * If it does, the object in the array is returned 
	 * If not, nothing is returned */
	public Boolean accountLookup(String name) {
		for(int i = 0; i < n; i++) {
			if(accountArray[i].getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

}
