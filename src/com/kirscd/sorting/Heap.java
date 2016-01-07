package com.kirscd.sorting;

import com.kirscd.utilities.Utils;

public class Heap {
	private static Integer[] values;

	public static void sort() {
		buildMaxHeap();
		System.out.println("Heapified -> ");
		Utils.printArray(values);
		sortMaxHeap();
	}
	
	private static void buildMaxHeap() {
		for(int i = (values.length-1)/2; i >= 1; i--) {
			maxHeapify(i, values.length);
		}
	}
	
	private static void maxHeapify(int i, int heapSize) {
		int largestIndex = findLargestIndex(i, heapSize);
		if(largestIndex != i) {
			Utils.swapIndex(values, i, largestIndex);
			maxHeapify(largestIndex, heapSize);
		}
	}
	
	private static int findLargestIndex(int original, int heapSize) {
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
	
	private static void sortMaxHeap() {
		int heapSize = values.length - 1; //-1 since we ignore 0;
		
		for(int i = heapSize; i >= 1; i--) {
			Utils.swapIndex(values, i, 1);
			maxHeapify(1, i);
		}
	}
	
	public static void main(String args[]) throws Exception {
		values = Utils.buildRandomArray(11, -100, 100);
		values[0] = Integer.MIN_VALUE; //we ignore the 0 spot
		Utils.printArray(values);
		Heap.sort();
		System.out.println("Sorted -> ");
		Utils.printArray(values);
		
		int check = Integer.MIN_VALUE;
		for(Integer i : values) {
			if(i < check) {
				throw new Exception("Something is fucky");
			}
			check = i;
		}
	}
}
