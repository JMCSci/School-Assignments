/* Jason Moreau
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #4
 * 
 * This program will calculate the the sum of three integers that the user inputs
 * It will then print their name based on the the sum of the integers
 * The total amount of even numbers that the user inputs will also be tracked
 */

package hw4;

import java.util.Scanner; 

public class HW4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int value1, value2, value3, answer, even, initiateLoop = 1, counter = 0; 
		introduction();
		
		while(initiateLoop >= 1) {
			counter++; 
			emptyLine();
			System.out.println("Input three integers. ");
			System.out.println("Entering the combination 0, 0, 0 will end the program: ");
			value1 = input.nextInt();
			value2 = input.nextInt();
			value3 = input.nextInt(); 
			// combination 0, 0, 0 will end program and subtract 1 from the counter
			if(value1 == 0 && value3 == 0 && value3 == 0) { 
			 counter--; break;
			}
			System.out.println("The original integers are: " + value1 + ", " + value2 + ", " + value3 + ".");
			answer = findsum(value1, value2, value3); 
			System.out.println("The sum is " + answer);
			printmyname(answer);
			even = howmanyeven(value1, value2, value3);
			System.out.println("There are is/are " + even + " even numbers.");
			emptyLine();
			// Prompt user to continue or end loop
			System.out.println("Enter a number greater than zero to continue or ZERO to stop"); 
			initiateLoop = input.nextInt();
		}
		System.out.println(counter + " set(s) of data values was/were entered and processed.\n");
		System.out.println("----END OF PROGRAM----");
		input.close();
	}
	// Method: emptyLine -- prints a blank line
	public static void emptyLine() {
		System.out.println();
	}
	// Method: introduction -- prints name - no value returned
	public static void introduction() {
		System.out.println("Jason Moreau");
	}
	// Method: findsum -- calculates sum of two largest integers -- receives parameters from main (value1, value2, value3)
	// returns sum
	public static int findsum(int v1, int v2, int v3) { 
		int max1 = 0, max2 = 0, max3 = 0, sum = 0;
		if(v1 > v2 || v1 > v3)
			max1 = v1; 
		if(v2 > v1 || v2 > v3)
			max2 = v2; 
		if(v3 > v1 || v3 > v2)
			max3 = v3;
		if(max1 > max2 || max1 > max3)
			sum = max1 + sum; 
		if(max2 > max1 || max2 > max3)
			sum = max2 + sum;
		if(max3 > max1 || max3 > max2)
			sum = max1 + max2 + max3;  
		return sum; 
	}
	// Method: printmyname -- prints name based on answer variable passed to method and used as loop counter
	// amount of times name is printed based on value of parameter passed to method
	// not value returned
	public static void printmyname(int loopCount) {
		for(int i = 0; i <= loopCount; i++) {
			if(loopCount > 0 && loopCount <= 10)
			System.out.println("Jason Moreau");
			} if(loopCount <= 0) {
				System.out.println("Cannot print name if sum is less than or equal to zero.");
			} else if(loopCount > 10) {
				System.out.println("Cannot print name if sum is greater than 10.");
			}
		}
	// Method: howmanyeven -- determines how many values are even -- parameters passed to method (value1, value2, value3)
	// if statement doesn't count zero as an even number
	// returns total even numbers to main
	public static int howmanyeven(int val1, int val2, int val3) {
		int totalEven = 0; 
		if(val1 % 2 == 0 && val1 != 0)  
			totalEven++;	
		if(val2 % 2 == 0 && val2 != 0)
			totalEven++;
		if(val3 % 2 == 0 && val3 != 0)
			totalEven++;
		return totalEven;
	}
}
