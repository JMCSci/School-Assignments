/* CISC 3115 - Lab #6				
 * Jason Moreau											
 * Program reads in a series of names and phone numbers and inserts each into a HashMap. 
 * Full name is the key, object is a phone number. 
 * Program then prints phone number or "Unlisted".
 * Key names: Fry, Cobb, Miller, Ollie, Zee
 */

package lab6;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_6 {
	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		Scanner input = new Scanner(System.in);
		String key = null;
		String userDecision = null;
		boolean start = true;
		
		// Add names and numbers to HashMap
		map.put("Miller", "555-1234");
		map.put("Cobb", "555-9456");
		map.put("Zee", "555-0173");
		map.put("Ollie", "555-6382");
		map.put("Fry", "555-2035");
		
		while(start) {
			System.out.print("Enter name: ");
			key = input.next();
			checkName(map, key);
			System.out.println("Press C to continue or Q to quit");
			userDecision = input.next();
			start = quit(userDecision);
		}
		System.out.println("---END OF PROGRAM---");
		input.close();
	}
	
	/* METHOD: capitalizeName 
	 * Capitalizes the first letter in key name
	 */
	public static String capitalizeName(String key) {
		char temp1 = ' ';
		String temp2 = null;
		temp1 = key.charAt(0);
		temp1 = Character.toUpperCase(temp1);
		temp2 = Character.toString(temp1);		
		key = temp2 + key.substring(1, key.length());
		
		return key;
	}
	
	/* METHOD: checkName
	 * Checks HashMap for key match
	 * Capitalizes first letter in name so that user input matches key
	 * Returns phone number if key matches user input
	 * Returns "Unlisted" if key does not match user input
	 */
	public static void checkName(HashMap<String, String> map, String key) {
		key = capitalizeName(key);
		if(map.containsKey(key)) {
			System.out.println("Phone number: " + map.get(key) + "\n");
		} else {
			System.out.println("Unlisted");
		}
		
	}
	/* METHOD: quit
	 * Checks if user enters "C" to continue or "Q" to quit program
	 * Catches InputMismatchException
	 */
	public static boolean quit(String userDecision) {
		char decision = ' ';
		int num = 0;
		
		try {
			userDecision = userDecision.toUpperCase();
			decision = userDecision.charAt(0);
			num = Character.getNumericValue(decision);
			if(decision == KeyEvent.VK_Q) {
				return false;
			} else if(decision == KeyEvent.VK_C) {
				return true;
			}
		} 
		catch (InputMismatchException ex) {
			return true;
		}
		return true;
	}

}
