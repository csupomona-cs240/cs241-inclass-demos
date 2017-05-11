package edu.cpp.cs241;

public class GraphTest {

	public static void main(String[] args) {
		Graph<String> graph1 = new Graph<String>(9);
		graph1.setLabel(0, "A");
		graph1.setLabel(1, "B");
		graph1.setLabel(2, "C");
		graph1.setLabel(3, "D");
		graph1.setLabel(4, "E");
		graph1.setLabel(5, "F");
		graph1.setLabel(6, "G");
		graph1.setLabel(7, "H");
		graph1.setLabel(8, "I");

		graph1.addEdge(0, 1);
		graph1.addEdge(0, 4);
		graph1.addEdge(0, 3);
		graph1.addEdge(1, 4);
		graph1.addEdge(2, 1);
		graph1.addEdge(3, 6);
		graph1.addEdge(4, 5);
		graph1.addEdge(4, 7);
		graph1.addEdge(5, 2);
		graph1.addEdge(6, 7);
		graph1.addEdge(7, 8);
		graph1.addEdge(8, 5);
		graph1.addEdge(5, 7);

		graph1.BFS(0);
		System.out.println();
		graph1.DFS(0);
	}

}
