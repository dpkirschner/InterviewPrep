package com.kirscd.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.interviewcake.com/question/java/queue-two-stacks
 *
 */
public class TwoStacks {
	private Deque<Integer> in;
	private Deque<Integer> out;
	
	public TwoStacks() {
		in = new ArrayDeque<Integer>();
		out = new ArrayDeque<Integer>();
	}
	
	public void enqueue(int value) {
		in.push(value);
	}
	
	public int dequeue() {
		if(in.isEmpty() && out.isEmpty()) {
			throw new RuntimeException("Queue is empty.");
		}
		
		if(out.isEmpty()) {
			while(!in.isEmpty()) {
				out.push(in.pop());
			}
		}
		
		return out.pop();
	}
	
	public static void main(String args[]) {
		TwoStacks ts = new TwoStacks();
		
		ts.enqueue(1);
		ts.enqueue(2);
		ts.enqueue(3);
		ts.enqueue(4);
		System.out.println(ts.dequeue());
		ts.enqueue(5);
		ts.enqueue(6);
		ts.enqueue(7);
		System.out.println(ts.dequeue());
		System.out.println(ts.dequeue());
		System.out.println(ts.dequeue());
		System.out.println(ts.dequeue());
		System.out.println(ts.dequeue());
		System.out.println(ts.dequeue());
	}
}
