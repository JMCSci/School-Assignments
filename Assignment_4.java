package hw4;

import java.util.Scanner; 

public class HW4 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int value1, value2, value3, ans, even, initiateLoop, counter = 0; 
		introduction();
		System.out.print("Enter a number to start program: ");
		initiateLoop = input.nextInt();
		
		while(initiateLoop > 0) {
			counter++; 
		System.out.println("Input three integers:");
		value1 = input.nextInt();
		value2 = input.nextInt();
		value3 = input.nextInt();
		System.out.println("The original integers are: " + value1 + ", " + value2 + ", " + value3 + ".");
		ans = findsum(value1, value2, value3); 
		System.out.println("The sum is " + ans);
		printmyname(ans);
		even = howmanyeven(value1, value2, value3);
		System.out.println("There are is/are " + even + " even numbers.");
		System.out.println("Enter a number to restart or ZERO to stop"); 
		initiateLoop = input.nextInt();
		}
		System.out.println(counter + " set(s) of data values were entered and processed.\n");
		System.out.println("----END OF PROGRAM----");
	}
	// prints name - no value returned
	public static void introduction() {
		System.out.println("Jason Moreau\n");
	}
	// calculates sum of two largest integers - returns sum
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
			sum = max3 + sum;  
		return sum; 
	}
	// use ans variable (in main) as loop counter 
	public static void printmyname(int loopCount) {
		for(int i = 0; i <= loopCount; i++) {
			if(loopCount > 0 && loopCount < 10)
			System.out.println("Jason Moreau");
			} if(loopCount <= 0) {
				System.out.println("Cannot print name if sum is less than or equal to zero.");
			} else if(loopCount > 10) {
				System.out.println("Cannot print name if sum is greater than 10.");
			}
		}
	// determine how many values are even; returns total to main
	public static int howmanyeven(int val1, int val2, int val3) {
		int totalEven = 0; 
		if(val1 % 2 == 0)
			totalEven++;
		if(val2 % 2 == 0)
			totalEven++;
		if(val3 % 2 == 0)
			totalEven++;
		return totalEven;
	}
}
