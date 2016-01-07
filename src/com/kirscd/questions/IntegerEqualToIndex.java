package com.kirscd.questions;

public class IntegerEqualToIndex {
	public static int[] values = {-3, -1, 1, 3, 5};
	
	public static int naive() {
		for(int i = 0; i < values.length; i++) {
			if(values[i] == i) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int recursive(int low, int high) {
		if(low >= high) {
			return -1;
		}
		int mid = (low + high) / 2;
		
		if(values[mid] == mid) {
			return mid;
		} else if(values[mid] > mid) {
			return recursive(low, mid-1);
		}
		return recursive(mid+1, high);
	}
	
	public static int iterative() {
		int low = 0;
		int high = values.length-1;
		int mid = 0;
		
		while(low<high) {
			mid = (low + high) / 2;
			if(values[mid] == mid) {
				return mid;
			} else if(values[mid] > mid) {
				high = mid-1;
			} else {
				low = mid+1;
			}
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		System.out.println(naive());
		System.out.println(recursive(0, values.length-1));
		System.out.println(iterative());
	}
}
