package johnson_java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    int V;
    List<Edge> edges;

    public Graph(int V) {
        this.V = V;
        this.edges = new ArrayList<>();
    }

    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public boolean bellmanFord(int src, int[] dist) throws NegativeCycleException {
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            boolean updated = false;
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                    updated = true;
                }
            }
            if (!updated) break;
        }

        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                throw new NegativeCycleException("Graph contains a negative weight cycle.");
            }
        }
        return true;
    }

    public void dijkstra(int src, int[] dist) throws DijkstraException {
        try {
            dist[src] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            pq.offer(new int[]{src, 0});

            while (!pq.isEmpty()) {
                int u = pq.poll()[0];
                if (dist[u] == Integer.MAX_VALUE) throw new DijkstraException("Unreachable vertex detected.");
                for (Edge edge : edges) {
                    if (edge.u == u) {
                        int v = edge.v;
                        int weight = edge.weight;
                        if (dist[u] + weight < dist[v]) {
                            dist[v] = dist[u] + weight;
                            pq.offer(new int[]{v, dist[v]});
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new DijkstraException("Error occurred during Dijkstra: " + e.getMessage());
        }
    }
}
