package com.kirscd.tree;

public class TreeUtils {
	public static BinarySearchTree balancedTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(5);
		bst.add(3);
		bst.add(7);
		bst.add(2);
		bst.add(4);
		bst.add(6);
		bst.add(8);
		return bst;
	}
	
	public static BinarySearchTree rightWeightedTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		bst.add(7);
		bst.add(8);
		return bst;
	}
	
	public static BinarySearchTree leftWeightedTree() {
		BinarySearchTree bst = new BinarySearchTree();
		bst.add(8);
		bst.add(7);
		bst.add(6);
		bst.add(5);
		bst.add(4);
		bst.add(3);
		bst.add(2);
		return bst;
	}
}
