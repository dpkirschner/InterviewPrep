package com.kirscd.dynamicProgramming;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *  Triangle
 *  By starting at the top of the triangle and moving to adjacent numbers on the row below,
 *   the maximum total from top to bottom is 27.
 *          5
 *        9  6
 *      4   6  8
 *    0   7  1   5
 * I.e. 5 + 9 + 6 + 7 = 27.
 * Write a program in a language of your choice to find the maximum total 
 * from top to bottom in triangle.txt, a text file containing a triangle with 100 rows.
 * 
 * This program makes several assumptions
 * 1) All values are positive and single digit
 * 2) Levels do not have to be increasing in length, but they will be filled
 * in from right to left.
 * 3) The depth of the tree must be short enough to avoid a stack overflow.
 * 4) the runtime is garbage because we will be constantly reworking past solutions.
 *
 */
public class Triangles {
	public static String[] readFile(String fileName) throws IOException {
		Stream<String> stream = Files.lines(Paths.get(fileName));

		String[] values = stream.toArray(size -> new String[size]);
		stream.close();
		return values;
	}
	
	public static int recursiveHighestTotal(String[] values) {
		if(values == null || values.length == 0) {
			return 0;
		}

		return recursive(values, 1, 0, charToInt(values[0].charAt(0)));
	}
	
	private static int recursive(String[] values, int depth, int index, int total) {
		if(depth >= values.length) {
			return total;
		}
		
		String level = values[depth];
		int left = 0;
		if(level.length() > index) {
			left = recursive(values, depth+1, index, total + charToInt(level.charAt(index)));
		}
		int right = 0;
		if(level.length() > index+1) {
			right = recursive(values, depth+1, index+1, total + charToInt(level.charAt(index+1)));
		}
		
		return Math.max(left, right);
	}
	
	private static int charToInt(char c) {
		return Integer.valueOf(Character.toString(c));
	}
	
	public static void main(String args[]) {
		String[] values = null;
		try {
			values = readFile("/Users/kirscd/Documents/workspace/InterviewPrep/src/com/kirscd/dynamicProgramming/triangle.txt");
		} catch (IOException e) {
			System.out.println("could not read file");
			e.printStackTrace();
		}
		
		//String[] values = {"5", "96", "468", "0715"};  
		System.out.println(recursiveHighestTotal(values));
	}
}
