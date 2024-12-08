package johnson_java;

import java.util.Arrays;

public class JohnsonAlgorithm {

    public static final int INF = Integer.MAX_VALUE;

    public static boolean johnson(Graph g) {
        try {
            if (g.V == 0 || g.edges.isEmpty()) {
                throw new InvalidGraphException("Graph is empty or invalid.");
            }

            // Thêm đỉnh s vào đồ thị
            int s = g.V;
            g.V++;
            Graph newGraph = new Graph(g.V);
            for (Edge edge : g.edges) {
                newGraph.addEdge(edge.u, edge.v, edge.weight);
            }
            for (int i = 0; i < g.V - 1; i++) {
                newGraph.addEdge(s, i, 0);
            }

            // Chạy thuật toán Bellman-Ford
            int[] dist = new int[g.V];
            Arrays.fill(dist, INF);
            newGraph.bellmanFord(s, dist);

            // Cập nhật trọng số cạnh
            for (Edge edge : g.edges) {
                if (edge.u < 0 || edge.v < 0 || edge.u >= g.V || edge.v >= g.V) {
                    throw new WeightUpdateException("Invalid vertex during weight update.");
                }
                edge.weight += dist[edge.u] - dist[edge.v];
            }

            // Chạy Dijkstra từ mỗi đỉnh
            for (int i = 0; i < g.V - 1; i++) {
                int[] dists = new int[g.V];
                Arrays.fill(dists, INF);
                newGraph.dijkstra(i, dists);
                System.out.println("Shortest paths from vertex " + i + ":");
                for (int j = 0; j < g.V - 1; j++) {
                    if (dists[j] == INF) {
                        System.out.println("To " + j + ": No path");
                    } else {
                        System.out.println("To " + j + ": " + dists[j]);
                    }
                }
            }

            return true;
        } catch (InvalidGraphException | NegativeCycleException | WeightUpdateException | DijkstraException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);

        // Thêm các cạnh vào đồ thị
        g.addEdge(0, 1, -1);
        g.addEdge(0, 2, 4);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 2);
        g.addEdge(1, 4, 2);
        g.addEdge(3, 2, 5);
        g.addEdge(3, 1, 1);
        g.addEdge(4, 3, -3);

        // Chạy thuật toán Johnson
        if (johnson(g)) {
            System.out.println("Johnson's algorithm completed successfully.");
        } else {
            System.out.println("Johnson's algorithm failed.");
        }


    }
}
