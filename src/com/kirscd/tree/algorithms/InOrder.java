package com.kirscd.tree.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import com.kirscd.tree.Node;
import com.kirscd.tree.TreeUtils;

/**
 * Complete an in-order traversal iteratively on a N-ary tree
 */
public class InOrder {
	public static void solve(Node head) {
		if(head == null) {
			return;
		}
		Deque<Node> stack = new ArrayDeque<Node>();
		
		Node node = head;
		while(node != null) {
			stack.push(node);
			node = node.left;
		}
		
		while(!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(node.value+":");
			if(node.right != null) {
				node = node.right;
				while(node != null) {
					stack.push(node);
					node = node.left;
				}
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
