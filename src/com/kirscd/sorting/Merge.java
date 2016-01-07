package com.kirscd.sorting;

import com.kirscd.utilities.Utils;

public class Merge {
	private static Integer[] values;
	private static Integer[] excess;

	public static void sort(int lower, int upper) {
		if(lower == upper) {
			return;
		}
		
		int mid = (lower + upper) / 2;
		sort(lower, mid);
		sort(mid + 1, upper);
		merge(lower, mid, upper);
	}
	
	private static void merge(int lower, int mid, int upper) {
		for(int i = lower; i <= mid; i++) {
			excess[i] = values[i];
		}
		for(int j = mid+1; j <= upper; j++) {
			excess[j] = values[j];
		}
		
		int pointerA = lower;
		int pointerB = mid+1;
		
		for(int offset = 0; offset <= upper-lower; offset++) {
			if((pointerB > upper) || (excess[pointerA] <= excess[pointerB] && pointerA < mid+1)) {
				values[lower + offset] = excess[pointerA];
				pointerA++;
			} else {
				values[lower + offset] = excess[pointerB];
				pointerB++;
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		values = Utils.buildRandomArray(10, -100, 100);
		excess = new Integer[values.length];
		Utils.printArray(values);
		Merge.sort(0, values.length - 1);
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
