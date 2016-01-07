package com.kirscd.questions;

public class AdjacentArray {
	public static int[] values =  {4, 5, 6, 5, 6, 7, 8, 9, 10, 9};
	
	public static int naive(int value) {
		
		for(int i = 0; i < values.length; i++) {
			if(value == values[i]) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static int recursive(int value, int index) {
		if(index >= values.length) {
			return -1;
		}
		
		if(values[index] == value) {
			return index;
		}
		
		return recursive(value, index+Math.abs(value-values[index]));
	}
	
	public static int iterative(int value) {
		int index = 0;
		
		while(index < values.length) {
			if(values[index] == value) {
				return index;
			}
			index = index + Math.abs(value - values[index]);
		}
		return -1;
	}
	
	public static void main(String args[]) {
		for(int i : values) {
			System.out.print(i + " : ");
		}
		System.out.println();
		
		System.out.println(naive(9));
		System.out.println(recursive(9, 0));
		System.out.println(iterative(9));
	}
}
