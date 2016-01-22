package com.kirscd.tree;

public class BinarySearchTree {
	public Node head;
	
	public BinarySearchTree() {
		head = null;
	}
	
	public void add(int value) {
		if(head == null) {
			head = new Node(value);
			return;
		}
		
		add(head, value);
	}
	
	private Node add(Node node, int value) {
		if(node == null) {
			return new Node(value);
		}
		
		if(node.value == value) {
			return node;
		}
		
		if(node.value > value) {
			node.left = add(node.left, value);
		} else {
			node.right = add(node.right, value);
		}
		return node;
	}
	
	public void remove(int value) {
		head = remove(head, value);
	}
	
	private Node remove(Node node, int value) {
		if(node == null) {
			throw new IllegalArgumentException("Requested value to remove doesn't exist");
		}
		
		if(node.value == value) {
			return swap(node);
		} else if(node.value > value) {
			node.left = remove(node.left, value);
		} else {
			node.right = remove(node.right, value);
		}
		
		return node;
	}

	private Node swap(Node node) {
		//replace with right childs farthest left node
		
		//no right child
		if(node.right == null) {
			Node toReturn = node.left;
			node = null;
			return toReturn;
		}
		Node trailing = node;
		Node current = node.right;
		while(current.left != null) {
			trailing = current;
			current = current.left;
		}
		
		//right child of original node has no left child
		if(trailing == node) {
			current.left = node.left;
			node = null;
			return current;
		}
		
		//right child had at least one left child
		trailing.left = current.right;
		current.left = node.left;
		current.right = node.right;
		return current;
	}
	
	public boolean contains(int value) {
		return contains(head, value);
	}
	
	private boolean contains(Node node, int value) {
		if(node == null) {
			return false;
		}
		if(node.value == value) {
			return true;
		} else if(node.value > value) {
			return contains(node.left, value);
		} else {
			return contains(node.right, value);
		}
		
	}
	
	public void printInorder(Node node) {
		if(node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.value + ":");
		printInorder(node.right);
	}
	
	public void printPostorder(Node node) {
		if(node == null) {
			return;
		}
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.value + ":");
	}
	
	public void printPreorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.value + ":");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public void dumpEverything() {
		System.out.println("Preorder:");
		printPreorder(head);
		System.out.println();
		System.out.println("inorder:");
		printInorder(head);
		System.out.println();
		System.out.println("Postorder:");
		printPostorder(head);
		System.out.println();
	}
	
	public static void main(String args[]) {
		BinarySearchTree bst = TreeUtils.balancedTree();
		bst.dumpEverything();
	}
}
