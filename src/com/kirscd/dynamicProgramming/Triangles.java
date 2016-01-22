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
 *
 */
public class Triangles {
	public static String[] readFile(String fileName) throws IOException {
		Stream<String> stream = Files.lines(Paths.get(fileName));

		String[] values = stream.toArray(size -> new String[size]);
		stream.close();
		return values;
	}
	
	/**
	 * The runtime for this method will be garbage because we are constantly recalculating 
	 * values we have already seen. For example, choosing between 5-9 and 5-6 requires us to
	 * calculate the path 5-9-6-7 as well as 5-6-6-7. The suffix of this path, 6-7, has already been seen.
	 * If this tree has a depth of 100 for example, we are duplicating a path of length 98, then a path of 97, etc.
	 * 
	 * This also has the disadvantage of having to load the entire file in memory at once.
	 * We can easily stack overflow on even smaller sized trees depending on the amount of RAM etc.
	 * 
	 * @param values
	 * @return
	 */
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
	
	/**
	 * This is a much better solution than the recursive one because we are systematically building
	 * the correct solution one level at a time. This means two things:
	 * 1) We never recalculate values we have already done
	 * 2) We never need to read the whole file into memory (although I have done here to make it easier).
	 * 
	 * The runtime here is number of levels*charactersInEachLevel + charactersInLastLevel.
	 * @param values
	 * @return
	 */
	public static int dynamicProgrammingHighestTotal(String[] values) {
		if(values == null || values.length == 0) {
			return 0;
		}
		
		int[][] totals = new int[values.length][values.length];
		totals[0][0] = charToInt(values[0].charAt(0));
		
		int depth = 1;
		while(depth < values.length) {
			String level = values[depth];
			for(int i = 0; i < level.length(); i++) {
				int thisValue = charToInt(level.charAt(i));
				
				int left = 0;
				if(i > 0) {
					left = thisValue + totals[depth-1][i-1];
				}
				
				int right = 0;
				if(i < totals[depth-1].length - 1) {
					right = thisValue + totals[depth-1][i];
				}
				
				totals[depth][i] = Math.max(left,  right); 
			}
			depth++;
		}
		
		int max = Integer.MIN_VALUE;
		for(int total : totals[values.length-1]) {
			max = total > max ? total : max;
		}
		return max;
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
		System.out.println(dynamicProgrammingHighestTotal(values));
	}
}
