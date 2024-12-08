package johnson_java;

import static johnson_java.JohnsonAlgorithm.johnson;

public class TestGraphNoNegativeEdges {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 2, 3);
        g.addEdge(2, 3, 1);
        g.addEdge(1, 3, 2);

        // Chạy thuật toán Johnson
        if (johnson(g)) {
            System.out.println("Johnson's algorithm completed successfully.");
        } else {
            System.out.println("Graph contains a negative weight cycle.");
        }
    }
}
