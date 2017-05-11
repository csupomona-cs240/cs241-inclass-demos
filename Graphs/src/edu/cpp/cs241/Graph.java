package edu.cpp.cs241;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph<T> {

	private boolean[][] edges;
	private T[] labels;

	public Graph(int n) {
		edges = new boolean[n][n];
		labels = (T[]) new Object[n];
	}

	public boolean isEdge(int src, int trg) {
		return edges[src][trg];
	}

	public void addEdge(int src, int trg) {
		edges[src][trg] = true;
	}

	public void removeEdge(int src, int trg) {
		edges[src][trg] = false;
	}

	public T getLabel(int vertex) {
		return labels[vertex];
	}

	public int[] neightbors(int vertex) {
		int count = 0;
		for(int i = 0; i < edges.length; i++) {
			if (edges[vertex][i]) {
				count++;
			}
		}
		int[] nei = new int[count];
		int index = 0;
		for(int i = 0; i < edges.length; i++) {
			if (edges[vertex][i]) {
				nei[index++] = i;
			}
		}
		return nei;
	}

	public void setLabel(int vertex, T label) {
		labels[vertex] = label;
	}

	public int size() {
		return labels.length;
	}

	public void BFS(int vertex) {
		Set<Integer> visitedVertex = new HashSet<Integer>();
		Queue<Integer> vertexQueue = new LinkedList<Integer>();
		System.out.println(getLabel(vertex));
		visitedVertex.add(vertex);
		vertexQueue.add(vertex);

		while(!vertexQueue.isEmpty()) {
			int frontVertex = vertexQueue.poll();
			int[] children = neightbors(frontVertex);
			for(int child : children) {
				if (!visitedVertex.contains(child)) {
					System.out.println(getLabel(child));
					visitedVertex.add(child);
					vertexQueue.add(child);
				}
			}
		}
	}

	public void DFS(int vertex) {
		Set<Integer> visitedVertex = new HashSet<Integer>();
		Stack<Integer> vertexStack = new Stack<Integer>();
		System.out.println(getLabel(vertex));
		visitedVertex.add(vertex);
		vertexStack.push(vertex);

		while(!vertexStack.isEmpty()) {
			int frontVertex = vertexStack.peek();
			int[] children = neightbors(frontVertex);

			boolean foundValidChild = false;
			for(int child : children) {
				if (!visitedVertex.contains(child)) {
					System.out.println(getLabel(child));
					visitedVertex.add(child);
					vertexStack.push(child);
					foundValidChild = true;
					break;
				}
			}

			if (!foundValidChild) {
				vertexStack.pop();
			}
		}
	}



}
