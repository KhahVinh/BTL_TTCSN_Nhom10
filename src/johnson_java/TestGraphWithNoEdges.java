package johnson_java;

import static johnson_java.JohnsonAlgorithm.johnson;

public class TestGraphWithNoEdges {
    public static void main(String[] args) {
        Graph g = new Graph(3); // Đồ thị có 3 đỉnh, không có cạnh nào

        // Chạy thuật toán Johnson
        if (johnson(g)) {
            System.out.println("Johnson's algorithm completed successfully.");
        } else {
            System.out.println("Graph contains a negative weight cycle.");
        }
    }
}
