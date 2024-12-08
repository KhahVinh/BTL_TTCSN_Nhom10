package johnson_java;


import static johnson_java.JohnsonAlgorithm.johnson;

public class TestGraphWithNegativeCycle {
    public static void main(String[] args) {
        Graph g = new Graph(3);
        g.addEdge(0, 1, 1);
        g.addEdge(1, 2, -1);
        g.addEdge(2, 0, -1);  // Chu trình âm

        // Chạy thuật toán Johnson
        if (johnson(g)) {
            System.out.println("Johnson's algorithm completed successfully.");
        } else {
            System.out.println("Graph contains a negative weight cycle.");
        }
    }
}
