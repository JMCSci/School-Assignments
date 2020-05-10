/* Bubble Sort class */

package assignment6;

public class BubbleSort {
	int comparison;
	int swaps;
	
	BubbleSort() {
		
	}
	
	// bubblesort: Sorts an array using a bubble sort
	public void bubblesort(int[] bubblesort) {
		int temp = 0;
		for(int i = 0; i < bubblesort.length - 1; i++) {
			for(int j = 0; j < bubblesort.length - 1; j++) {
				if(bubblesort[j] > bubblesort[j + 1]) {
					comparison++;
					temp = bubblesort[j];
					bubblesort[j] = bubblesort[j + 1];
					swaps++;
					bubblesort[j + 1] = temp;
					swaps++;
				}
			}
		}
		
	}
	
	// getSwaps: Returns the amount of element swaps made within bubble sort algorithm
	public int getSwaps() {
		return swaps;
	}
	
	// getComparison: Returns the amount of value comparisons made with bubble sort algorithm
	public int getComparisons() {
		return comparison;
	}
	
	// print: Prints array contents
	public void print(int [] set) {
		System.out.println();
		System.out.println("*** Bubble Sort Array *** ");
		for(int i = 0; i < set.length; i++) {
			System.out.println(set[i]);
		}
		
	}

}
