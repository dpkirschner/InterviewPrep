package com.kirscd.utilities;

import java.util.HashSet;
import java.util.Random;

public class Utils {
	public static String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
	
	public static int[] buildIntArray(int size, int lowBound, int highBound) {
		int[] values = new int[size];
		Random r = new Random();
		for(int i = 0; i < size; i++) {
			values[i] = r.nextInt(highBound - lowBound) + lowBound;
		}

		return values;
	}
	
	public static void printIntArray(int[] values) {
		for(int value : values) {
			System.out.print(value + " : ");
		}
		System.out.println();
	}
	
	public static String buildRandomString(int size) {
		Random r = new Random();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < size; i++) {
			sb.append(lowerCaseChars.charAt(r.nextInt(26)));
		}
		
		return sb.toString();
	}
	
	public static Integer[] buildRandomArray(int size, int lowBound, int highBound) {
		Random r = new Random();
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < size) {
			set.add(r.nextInt(highBound - lowBound) + lowBound);
		}

		return set.toArray(new Integer[set.size()]);
	}
	
	public static void printArray(Integer[] values) {
		for(int value : values) {
			System.out.print(value + " : ");
		}
		System.out.println();
	}
	
	public static Integer[] deepCopy(Integer[] values) {
		Integer[] copy = new Integer[values.length];
		for(int i = 0; i < values.length; i++) {
			copy[i] = values[i];
		}
		return copy;
	}
	
	public static void swapIndex(Integer[] values, int a, int b) {
		Integer temp = values[a];
		values[a] = values[b];
		values[b] = temp;
	}
}
