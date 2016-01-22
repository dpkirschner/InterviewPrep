package com.kirscd.tree.algorithms;

import com.kirscd.tree.BinarySearchTree;
import com.kirscd.tree.Node;
import com.kirscd.tree.TreeUtils;

public class NextIncreasingValue {
	public static Node solve(Node head, int value) {
		return find(head, null, value);
	}
	
	private static Node find(Node node, Node parent, int value) {
		if(node == null) {
			return null;
		}
		if(node.value == value) {
			if(node.right == null) {
				return parent;
			} else {
				node = node.right;
				while(node.left != null) {
					node = node.left;
				}
				return node;
			}
		} else if(node.value > value) {
			return find(node.left, node, value);
		} else {
			return find(node.right, node, value);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = TreeUtils.balancedTree();
		Node next = solve(bst.head, 6);
		if(next == null) {
			System.out.println("next value is null");
		} else {
			System.out.println("next value is " + next.value);
		}
	}

}
