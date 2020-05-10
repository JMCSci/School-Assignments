/* Heap Class */

package assignment6;

public class HeapSort <E extends Comparable<E>>{
	public java.util.ArrayList<E> list = new java.util.ArrayList<>();
	public java.util.LinkedList<Integer> list2 = new java.util.LinkedList<>();
	int comparison;
	int swaps;
	
	public HeapSort() {
		
	}
	
	public HeapSort(E[] objects) {
		for(int i = 0; i < objects.length; i++) {
			add(objects[i]);
		}
	}
	
	// add: Adds object to heap
	public void add(E newObject) {
		list.add(newObject);
		int currentIndex = list.size() - 1;
		
		while(currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			// Swap if he object is greater than its parent
			if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {
				E temp = list.get(currentIndex);
				list.set(currentIndex,  list.get(parentIndex));
				list.set(parentIndex, temp);
			}
			else
				break;
			
			currentIndex = parentIndex;
		}		
	}
	
	// remove: Removes root from heap
	public E remove() {
		if(list.size() == 0) return null;
		
		E removedObject = list.get(0);
		list.set(0,list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while(currentIndex < list.size()) {
			
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
			// Find the maximum between two children
			comparison++;
			if(leftChildIndex >= list.size()) break;
			int maxIndex = leftChildIndex;
			if(rightChildIndex < list.size()) {
				if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
					maxIndex = rightChildIndex;
				}
			}
			
			// Swap if the current node is less than the maximum
			if(list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
				swaps++;
				E temp = list.get(maxIndex);
				list.set(maxIndex, list.get(currentIndex));
				list.set(currentIndex,  temp);
				currentIndex = maxIndex;
			}
			else 
				break;
		}
		return removedObject;
	}
	
	// getSize: Returns the size of the heap
	public int getSize() {
		return list.size();
	}
	
	// getSwaps: Returns the amount of element swaps made within heap sort algorithm
	public int getSwaps() {
		return swaps;
	}
	
	// getComparison: Returns the amount of value comparisons made with heap sort algorithm
	public int getComparisons() {
		return comparison;
	}
	
	// printHeap: Prints heap contents
	public void printHeap() {
		System.out.println("\n*** Heap Sort Array ***");
		for(Integer temp: list2) {
			System.out.println(temp);
		}
	}
	
	public void print(int[] heap) {
		System.out.println();
		System.out.println("*** copyHeap NEEDS TO BE FIXED*** ");
		for(int i = 0; i < heap.length; i++) {
			System.out.println(heap[i]);
		}
		
	}
	
	public Integer[] copyHeap(int[] heap) {
		Integer[] copy = new Integer[heap.length];
		for(int i = 0; i < list.size(); i++) {
			copy[i] = list2.pop();
		}
		return copy;
		
	}

}
