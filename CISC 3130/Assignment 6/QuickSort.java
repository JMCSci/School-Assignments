/* QuickSort class */

package assignment6;

public class QuickSort {
	int comparison;
	int swaps;
	
	QuickSort() {
		
	}
	
	// quickSort: Used to sort array 
	public void quickSort(int[] list) {
		quickSort(list, 0, list.length - 1);
	}
	
	// quickSort: Helper method, sorts partial array within a specific range
	public void quickSort(int [] list, int first, int last) {
		if(last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex - 1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	// partition: Partitions array using the pivot
	public int partition(int[] list, int first, int last) {
		int pivot = list[first];
		int low = first + 1;
		int high = last;
		
		while(high > low) {
			// Search forward from left
			while(low <= high && list[low] <= pivot) {
				swaps++;
				low++;
			}
			
			// Search backward from right
			while(low <= high && list[high] > pivot) {
				swaps++;
				high--;
			}
			
			// Swap two elements in the list
			if(high > low) {
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
				comparison++;
				swaps++;
			}
			
		}
		
		while(high > first && list[high] >= pivot) {
			comparison++;
			high--;
		}
		
		// Swap pivot with list[high]
		if(pivot > list[high]) {
			list[first] = list[high];
			list[high] = pivot;
			comparison++;
			return high;
		} else {
			comparison++;
			return first;
		}
		
	}
	
	// getSwaps: Returns the amount of element swaps made within quicksort sort algorithm
	public int getSwaps() {
		return swaps;
	}
	
	// getComparison: Returns the amount of value comparisons made with quicksort algorithm
	public int getComparisons() {
		return comparison;
	}
	
	// print: Prints array contents 
	public void print(int [] set) {
		System.out.println();
		System.out.println("*** QuickSort Array *** ");
		for(int i = 0; i < set.length; i++) {
			System.out.println(set[i]);
		}
		
	}
	
}
