package com.kirscd.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.interviewcake.com/question/java/largest-stack
 *
 */
public class MaxStack {
	private Deque<Integer> stack;
	private Deque<Integer> maxStack;
	
	public MaxStack() {
		stack = new ArrayDeque<Integer>();
		maxStack = new ArrayDeque<Integer>();
	}
	
	public void push(int value) {
		if(maxStack.isEmpty() || maxStack.peek() <= value) {
			maxStack.push(value);
		}
		stack.push(value);
	}
	
	public int pop() {
		if(stack.isEmpty()) {
			throw new RuntimeException("Stack is empty!");
		}
		
		int value = stack.pop();
		if(maxStack.peek() == value) {
			maxStack.pop();
		}
		
		return value;
	}
	
	public int getMax() {
		return maxStack.peek();
	}
	
	
	public static void main(String args[]) {
		MaxStack ms = new MaxStack();
		
		ms.push(1);
		System.out.println(ms.getMax());
		ms.push(1);
		System.out.println(ms.getMax());
		ms.push(1);
		System.out.println(ms.getMax());
		ms.push(1);
		System.out.println(ms.getMax());
		ms.pop();
		System.out.println(ms.getMax());
		
	}
}
