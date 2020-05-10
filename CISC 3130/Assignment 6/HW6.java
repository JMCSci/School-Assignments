/* Jason Moreau
 * CISC 3130 - EWQ6
 * Spring 2020
 *
 * Assignment #6 - Sorting
 * STEP 1 -- Subroutine reads in group of numbers to be sorted 
 * STEP 2 -- Subroutine to sort these values using three sorts
 * STEP 3 -- Subroutine determines which sort used the most, middle and least comparisons
 *
 */

package assignment6;

import java.io.File;
import java.util.Scanner;

public class HW6 {
	static int num = 1;
	public static void main(String[] args) throws Exception {
		int [] set1 = new int [10];
		int [] set2 = new int [10];
		int [] set3 = new int [10];
		int [] set4 = new int [50];
		int [] set5 = new int [50];
		int [] set6 = new int [50];
		int [] set7 = new int [100];
		int [] set8 = new int [100];
		int [] set9 = new int [100];
		System.out.println("*** 10 numbers in almost sorted order ***");
		data(set1);
		threeSort(set1);
		System.out.println("\n*** 10 numbers in random order ***");
		data(set2);
		threeSort(set2);
		System.out.println("\n*** 10 numbers in reverse order ***");
		data(set3);
		threeSort(set3);
		System.out.println("\n*** 50 numbers in almost sorted order ***");
		data(set4);
		threeSort(set4);
		System.out.println("\n*** 50 numbers in random order ***");
		data(set5);
		threeSort(set5);
		System.out.println("\n*** 50 numbers in reverse order ***");
		data(set6);
		threeSort(set6);
		System.out.println("\n*** 100 numbers in almost sorted order ***");
		data(set7);
		threeSort(set7);
		System.out.println("\n*** 100 numbers in random order ***");
		data(set8);
		threeSort(set8);
		System.out.println("\n*** 100 numbers in reverse order ***");
		data(set9);
		threeSort(set9);
	}
	
	// data: Reads in data from file
	public static void data(int[] set) throws Exception {
		Scanner sc = new Scanner(new File("Set" + Integer.toString(num)));
		System.out.println("\nOriginal Set");
		for(int i = 0; i < set.length; i++) {
			set[i] = sc.nextInt();
			System.out.println(set[i]);
		}
		
	}
	
	// copyArray: Copy array contents to another array
	public static void copyArray(int [] set, int [] copy) {
		for(int i = 0; i < set.length; i++) {
			copy[i] = set[i];
		}
	}
	
	// threeSort: Sorts data using three sort types (Bubble sort, Quick Sort, Heap Sort)
	public static void threeSort(int [] set) {
		int [] quicksort = new int [set.length];
		int [] heap = new int [set.length];
		// create 2 copies of original array for each sort
		copyArray(set, quicksort);
		copyArray(set, heap);
		/* start sorts and prints output */	
		Sorts.bubblesort(set);
		Sorts.quicksort(quicksort);
		Sorts.heapsort(heap);
		// use nextFile method after STEP 2 is complete
		nextFile();
	}
	
	// nextFile: Increment number to go next file (ex. Set1, Set2...Set9)
	public static void nextFile() {
		num++;
	}
	
	
	

}

/* Sorts class */
class Sorts {
	// Data fields hold swaps and comparison values 
	static int bubbleSwaps = 0;
	static int quickSwaps = 0;
	static int heapSwaps = 0;
	static int bubbleComparisons = 0;
	static int quickComparisons = 0;
	static int heapComparisons = 0;
	
	Sorts() {
	
	}
	
	// bubblesort: Sorts array, prints output, retrieves amount of sort swaps and comparisons 
	public static void bubblesort(int[] bubblesort) {
		BubbleSort sort = new BubbleSort();
		sort.bubblesort(bubblesort);
		sort.print(bubblesort);
		bubbleSwaps = sort.getSwaps();
		bubbleComparisons = sort.getComparisons();
		System.out.println("Swaps: " + sort.getSwaps());
		System.out.println("Comparisons: " + sort.getComparisons());
	}
	
	// quicksort: Sorts array, prints output, retrieves amount of sort swaps and comparisons 
	public static void quicksort(int[] quicksort) {
		QuickSort sort = new QuickSort();
		sort.quickSort(quicksort);
		sort.print(quicksort);
		quickSwaps = sort.getSwaps();
		quickComparisons = sort.getComparisons();
		System.out.println("Swaps: " + sort.getSwaps());
		System.out.println("Comparisons: " + sort.getComparisons());
	}
	
	// heapsort: Sorts array, prints output, retrieves amount of sort swaps and comparisons 
	public static void heapsort(int [] heap) {
		HeapSort <Integer> sort = new HeapSort<Integer>();
		// Create a heap using array contents
		for(int i = 0; i < heap.length; i++) {
			sort.add(heap[i]);
		}
		// Sort heap by removing elements and adding them to a new list
		for(int i = sort.getSize() - 1; i >= 0; i--) {
			sort.list2.addFirst(sort.remove());
		}
		sort.printHeap();
		heapSwaps = sort.getSwaps();
		heapComparisons = sort.getComparisons();
		System.out.println("Swaps: " + sort.getSwaps());
		System.out.println("Comparisons: " + sort.getComparisons());
		emptyLine();
		compareSorts();
	}
	
	// compareSorts: Checks and prints which sorts has the most, medium, and least amount of swaps and comparisons
	public static void compareSorts() {
		if(bubbleSwaps > quickSwaps && bubbleSwaps > heapSwaps) {
			System.out.println("Bubble Sort has the most swaps.");
			if(quickSwaps > heapSwaps) {
				System.out.println("Quick Sort has a medium amount of swaps.");
				System.out.println("Heap Sort has the fewest swaps.");
			} else {
				System.out.println("Heap Sort has a medium amount of swaps.");
				System.out.println("Quick Sort has the fewest swaps.");
			}
		} else if(quickSwaps > bubbleSwaps && quickSwaps > heapSwaps) {
			System.out.println("QuickSort has the most swaps.");
			if(bubbleSwaps > heapSwaps) {
				System.out.println("Bubble Sort has a medium amount of swaps.");
				System.out.println("Heap Sort has the fewest swaps.");	
			} else {
				System.out.println("Heap Sort has a medium amount of swaps.");
				System.out.println("Quick Sort has the fewest swaps.");
			}
		} else if(heapSwaps > bubbleSwaps && heapSwaps > quickSwaps) {
			System.out.println("Heap Sort has the most comparisons.");
			if(bubbleSwaps > quickSwaps) {
				System.out.println("Bubble Sort has a medium amount of comparisons.");
				System.out.println("Quick Sort has the fewest swaps.");
			} else { 
				System.out.println("Quick Sort has a medium amount of comparisons.");
				System.out.println("Bubble Sort has the fewest comparisons.");
			}
		}
		
		if(bubbleComparisons > quickComparisons && bubbleComparisons > heapComparisons) {
			System.out.println("Bubble Sort has the most swaps.");
			if(quickComparisons > heapComparisons) {
				System.out.println("Quick Sort has a medium amount of comparisons.");
				System.out.println("Heap Sort has the fewest comparisons.");
				return;
			} else {
				System.out.println("Heap Sort has a medium amount of comparisons.");
				System.out.println("Quick Sort has the fewest comparisons.");
				return;
			}
		} else if(quickComparisons > bubbleComparisons && quickComparisons > heapComparisons) {
			System.out.println("QuickSort has the most comparisons.");
			if(bubbleComparisons > heapComparisons) {
				System.out.println("Bubble Sort has a medium amount of comparisons.");
				System.out.println("Heap Sort has the fewest comparisons.");
				return;
			} else {
				System.out.println("Heap Sort has a medium amount of comparisons.");
				System.out.println("Quick Sort has the fewest comparisons.");
				return;
			}
		} else if(heapComparisons > bubbleComparisons && heapComparisons > quickComparisons) {
			System.out.println("Heap Sort has the most comparisons.");
			if(bubbleComparisons > quickComparisons) {
				System.out.println("Bubble Sort has a medium amount of comparisons.");
				System.out.println("Quick Sort has the fewest comparisons.");
				return;
			} else {
				System.out.println("Quick Sort has a medium amount of comparisons.");
				System.out.println("Bubble Sort has the fewest comparisons.");
				return;
			}
		}
			
			
	}
	
	// emptyLine: Prints a empty line to the console
	public static void emptyLine() {
		System.out.println();
	}
	

	
}
