/* Jason Moreau
 * CISC 1115 - ETR6
 * Spring 2019
 * 
 * Assignment #6
 * 
 * This program will call a series of methods to process a set of data into two arrays
 * To be more specific, the first array will read in data and have its average calculated
 * This data will then be used to calculate the distance between the average and the values stored in each element of the first array
 * The second array will then store these values in its corresponding elements and have its average taken
 * 
 */

package hw6;

import java.util.Scanner;

public class HW6 {
	public static void main(String[] args) {
	// array will be large but all of the elements will not be used
		double [] firstArray = new double [50];
		double [] secondArray = new double [50];
	// size variable will be used in method for loop
		int size = 15;
		double average1, average2;
	// call readData method to read size items into firstArray
		readData(firstArray, size);
		System.out.println("Here is the original array: ");
	// call printArray method to print values of firstArray
		printArray(firstArray, size);
	// call findAverage method to calculate average of values stored in firstArray
		average1 = findAverage(firstArray, size);
		System.out.printf("\n\nThe average of the values stored in the first array is: %.2f", average1);
	// call howFarAway to construct a new array called secondArray
		howFarAway(firstArray, secondArray, size, average1); 
	// call printArray again to print values of secondArray
		System.out.println("\n\nHere is the new array: ");
		printArray(secondArray, size);
	// call findAverage method to calculate average of values stored in secondArray
		average2 = findAverage(secondArray, size);
		System.out.printf("\n\nThe average of the values stored in the second array is: %.2f", average2);
	}
	// Method: readData -- read size items into array
	public static void readData(double firstArray[], int size) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input values of array: ");
		for(int i = 0; i < size; i++) {
			firstArray[i] = input.nextDouble();
		}
		input.close();
	}
	// Method: printArray -- prints values stored in firstArray
	public static void printArray(double firstArray[], int size) {
		for(int i = 0; i < size; i++) { 
			if(i % 5 == 0)
			System.out.printf("\n%.2f" + "\t", firstArray[i]);
			else
				System.out.printf("%.2f" + "\t", firstArray[i]);
		}
	}
	// Method: findAverage -- calculates the average of values stored in firstArray
	public static double findAverage(double firstArray[], int size) {
		double sum = 0;
		double averageValue1;
		for(int i = 0; i < size; i++) {
			sum = firstArray[i] + sum;
		}
			averageValue1 = sum / size;
			return averageValue1;
	}
	// Method: howFarAway -- constructs secondArray
	public static double [] howFarAway(double firstArray[], double secondArray[], int size, double average) {
		for(int i = 0; i < size; i++) 
			secondArray[i] = firstArray[i] - average;
			return secondArray;
	}
	// Method: printArray -- prints values from secondArray -- method overload
	public static void printArray(double secondArray[], int size) {
		for(int i = 0; i < size; i++)
		if(i % 5 == 0)
			System.out.printf("\n%.2f" + "\t", secondArray[i]);
			else
				System.out.printf("%.2f" + "\t", secondArray[i]);
	}
	// Method: findAverage -- calculates the average of values stored in secondArray -- method overload
	public static double findAverage(int secondArray[], int size) {
		int sum = 0;
		double averageValue2;
		for(int i = 0; i < size; i++) {
			sum = secondArray[i] + sum;
		}
		averageValue2 = sum / size; 
		return averageValue2; 
	}
}
