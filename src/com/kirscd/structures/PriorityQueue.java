package com.kirscd.structures;


/**
 * PriorityQueue implementation using a heap. Does not handle negative numbers, although it
 * could be extended trivially.
 */
public class PriorityQueue {
	private int[] values;
	private int heapSize;
	
	public PriorityQueue(int size) {
		values = new int[size+1];
		heapSize = 0;
	}
	
	public void insert(int value) throws Exception {
		if(heapSize == values.length-1) {
			throw new Exception("heap is full");
		}
		
		heapSize++;
		values[heapSize] = value;
		
		int i = heapSize;
		while( i > 1 && values[i] > values[i/2]) {
			swapValues(i, i/2);
			i = i/2;
		}
	}
	
	public int max() {
		return values[1];
	}
	
	public int removeMax() throws Exception {
		if(heapSize == 0) {
			throw new Exception("heap underflow");
		}
		
		int toReturn = values[1];
		swapValues(1, heapSize);
		values[heapSize] = 0;
		heapSize--;
		maxHeapify(1);
		
		return toReturn;
	}
	
	private void maxHeapify(int i) {
		int largestIndex = findLargestIndex(i);
		if(largestIndex != i) {
			swapValues(i, largestIndex);

			maxHeapify(largestIndex);
		}
	}

	private void swapValues(int a, int b) {
		int temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}
	
	private int findLargestIndex(int original) {
		int largestIndex = original;
		int left = 2*original;
		int right = 2*original+1;
		
		if(left < heapSize && values[left] > values[original]) {
			largestIndex = left;
		}
		if(right < heapSize && values[right] > values[largestIndex]) {
			largestIndex = right;
		}
		
		return largestIndex;
	}
	
	public void printQueue() {
		for(Integer i : values) {
			System.out.print(i + " : ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) throws Exception {
		PriorityQueue pq = new PriorityQueue(5);
		pq.printQueue();
		pq.insert(10);
		pq.printQueue();
		pq.insert(20);
		pq.printQueue();
		pq.insert(5);
		pq.printQueue();
		pq.insert(50);
		pq.printQueue();
		System.out.println(pq.max());
		pq.removeMax();
		pq.printQueue();
	}
}
