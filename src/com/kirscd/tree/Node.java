package com.kirscd.tree;

public class Node {
	public int value;
	public Node left;
	public Node right;
	public Node neighbor;
	
	public Node(int value) {
		this.value = value;
	}
	
	public String toString() {
		return "node:" + value;
	}
}
