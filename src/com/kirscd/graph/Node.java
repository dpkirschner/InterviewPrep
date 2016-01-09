package com.kirscd.graph;

import java.util.ArrayList;

public class Node {
	public ArrayList<Edge> edges;
	public String name;
	
	public Node(String name, ArrayList<Edge> edges) {
		this.name = name;
		this.edges = edges;
	}
}
