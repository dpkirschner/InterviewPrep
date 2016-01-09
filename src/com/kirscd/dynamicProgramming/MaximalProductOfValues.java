package com.kirscd.dynamicProgramming;

import com.kirscd.utilities.Utils;


/**
 * Given a rope with length n, how to cut the rope into m parts with length n[0], n[1], ..., n[m-1], 
 * in order to get the maximal product of n[0]*n[1]* ... *n[m-1]? 
 * We have to cut once at least. Additionally, the length of the whole length of the rope, 
 * as well as the length of each part, are in integer value. 
 * For example, if the length of the rope is 8, the maximal product of the part lengths is 18. 
 * In order to get the maximal product, the rope is cut into three parts with 
 * lengths 2, 3, and 3 respectively.
 *
 */
public class MaximalProductOfValues {
	public static int value;
	
	public static int dynamic() {
		int[] values = new int[value+1];
		values[0] = 0;
		values[1] = 1;
		values[2] = 2;
		values[3] = 3;
		
		for(int i = 4; i <= value; i++) {
			int max = 0;
			for(int j = 1; j <= i/2; j++) {
				if(values[j]*values[i-j] > max) {
					max = values[j]*values[i-j];
				}
			}
			values[i] = max;
		}
		
		Utils.printIntArray(values);
		return values[value];
	}
	
	public static int tricky() {
		if(value == 0 || value == 1 || value == 2) {
			return value;
		}
		
		int power = value / 3;
		int remainder = value % 3;
		
		return (int) (Math.pow(3, power) * remainder);
	}
	
	public static int recursive(int value) {		
		if(value <= 1) {
			return 1;
		}
		int max = 0;
		for(int i = 1; i <= value; i++) {
			int product = i * recursive(value - i);
			if(max < product) {
				max = product;
			}
		}
		
		return max;
	}
	
	public static void main(String args[]) {
		value = 8;
		System.out.println(recursive(value));
		System.out.println(tricky());
		System.out.println(dynamic());
	}
}
