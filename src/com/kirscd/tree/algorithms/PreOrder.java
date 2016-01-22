package com.kirscd.tree.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import com.kirscd.tree.Node;
import com.kirscd.tree.TreeUtils;

public class PreOrder {
	public static void solve(Node head) {
		if(head == null) {
			return;
		}
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(head);
		
		while(!stack.isEmpty()) {
			Node node = stack.remove();
			System.out.print(node.value + ":");	
			if(node.right != null) {
				stack.push(node.right);
			}
			if(node.left != null) {
				stack.push(node.left);
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		solve(TreeUtils.balancedTree().head);
		solve(TreeUtils.rightWeightedTree().head);
		solve(TreeUtils.leftWeightedTree().head);
	}
}
