package com.kirscd.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the longest consecutive sequence which uses only 
 * two characters.
 * 
 * Ex: "aabb" is 4
 * "abab" is 4
 * "abcab" is 2
 * "ababcccc" is 5.
 *
 */
public class LongestSubstringWithTwoCharacters {
	public static String value = "abababaccccccebbb";
	
	public static int solve() {
		HashMap<Character, Integer> lastSeen = new HashMap<Character, Integer>(); 
		Set<Character> thisRun = new HashSet<Character>();
		
		int totalMax = 0;
		int currentMax = 0;
		
		for(int i = 0; i < value.length(); i++) {
			if(thisRun.size() < 2) {
				thisRun.add(value.charAt(i));
				lastSeen.put(value.charAt(i), i);
				currentMax = currentMax + 1;
				continue;
			}
			
			if(thisRun.contains(value.charAt(i))) {
				currentMax = currentMax + 1;
				lastSeen.put(value.charAt(i), i);
			} else {
				Character earliest = findEarliestCharacter(lastSeen, thisRun);
				if(currentMax > totalMax) {
					totalMax = currentMax;
				}
				//we don't need to add one here for the current character because this line doesn't take into account
				//the fact the indices of the string are 0 based. To fix this we would need to remove 1 to make the
				//old length correct, then add one to the length for this character
				currentMax = i - lastSeen.get(earliest);
				thisRun.remove(earliest);
				thisRun.add(value.charAt(i));
				lastSeen.put(value.charAt(i), i);
			}
		}
		
		if(currentMax > totalMax) {
			totalMax = currentMax;
		}
		
		return totalMax;
	}
	
	public static Character findEarliestCharacter(Map<Character, Integer> lastSeen, Set<Character> thisRun) {
		Character earliest = null;
		Integer lastPos = Integer.MAX_VALUE;
		for(Character ch : thisRun) {
			if(lastSeen.get(ch) < lastPos) {
				earliest = ch;
				lastPos = lastSeen.get(ch);
			}
		}
		
		return earliest;
	}
	
	public static void main(String args[]) {
		System.out.println(solve());
	}
}
