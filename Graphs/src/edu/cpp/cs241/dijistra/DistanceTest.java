package edu.cpp.cs241.dijistra;

public class DistanceTest {

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

		graph1.addEdge(0, 1, 2);
		graph1.addEdge(0, 4, 5);
		graph1.addEdge(0, 3, 4);
		graph1.addEdge(1, 4, 1);
		graph1.addEdge(2, 1, 3);
		graph1.addEdge(3, 6, 2);
		graph1.addEdge(4, 5, 3);
		graph1.addEdge(4, 7, 6);
		graph1.addEdge(5, 2, 4);
		graph1.addEdge(6, 7, 1);
		graph1.addEdge(7, 8, 1);
		graph1.addEdge(8, 5, 1);
		graph1.addEdge(5, 7, 3);

		graph1.dijistra(0, 2);
	}

}
