package com.kirscd.tree.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

import com.kirscd.tree.Node;
import com.kirscd.tree.TreeUtils;

/**
 * Complete a post-order traversal iteratively on a N-ary tree
 *
 * We do this by maintaining two stacks, a moveStack and a printStack.
 * The moveStack is used just like a traditional DFS on a N-ary tree.
 * The printStack keeps track of the order we have visited the nodes in.
 * Since DFS is a reverse postOrder traversal, reversing the direction of the
 * visited nodes (by use of the printStack) will give us a correct postOrder traversal.
 */
public class PostOrder {
	public static void solve(Node head) {
		if(head == null) {
			return;
		}
		Deque<Node> moveStack = new ArrayDeque<Node>();
		Deque<Node> printStack = new ArrayDeque<Node>();
		moveStack.push(head);
		
		while(!moveStack.isEmpty()) {
			Node node = moveStack.pop();
			printStack.push(node);
			if(node.left != null) {
				moveStack.push(node.left);
			}
			
			if(node.right != null) {
				moveStack.push(node.right);
			}
		}

		while(!printStack.isEmpty()) {
			Node node = printStack.pop();
			System.out.print(node.value + ":");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		solve(TreeUtils.balancedTree().head);
		solve(TreeUtils.rightWeightedTree().head);
		solve(TreeUtils.leftWeightedTree().head);
	}
}
