package com.kirscd.tree.algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

import com.kirscd.tree.BinarySearchTree;
import com.kirscd.tree.Node;
import com.kirscd.tree.TreeUtils;

public class Neighbors {
	public static void solve(Node head) {
		Queue<Node> queue = new ArrayDeque<Node>();
		queue.add(head);
		
		while(queue.size() > 0) {
			Node node = queue.remove();
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
			//prevents us from having neighbors across levels
			if(queue.peek() != null && queue.peek().value > node.value && queue.peek() != node.right) {
				node.neighbor = queue.peek();
			}
		}
	}
	
	public static void printNodes(Node node) {
		if(node == null) {
			return;
		}
		if(node.neighbor == null) {
			System.out.println(node.value + " -> null");
		} else {
			System.out.println(node.value + " -> " + node.neighbor.value);
		}
		
		printNodes(node.left);
		printNodes(node.right);
	}
	
	public static void main(String args[]) {
		System.out.println("BST");
		BinarySearchTree bst = TreeUtils.balancedTree();
		solve(bst.head);
		printNodes(bst.head);
		
		System.out.println("LST");
		BinarySearchTree lst = TreeUtils.leftWeightedTree();
		solve(lst.head);
		printNodes(lst.head);
		
		System.out.println("RST");
		BinarySearchTree rst = TreeUtils.rightWeightedTree();
		solve(rst.head);
		printNodes(rst.head);
	}
}
