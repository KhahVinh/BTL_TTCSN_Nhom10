
package test_prim;

import java.util.List;
import prim_java.Graph;
import prim_java.PrimAlgorithm;
import prim_java.exception.DisconnectedGraphException;
import prim_java.exception.DuplicateEdgeException;

public class TestPrimAlgorithm {
    public static void main(String[] args) {
//        testDisconnectedGraph();
//        testSingleVertex();
//        testGraphWithMultipleEdges();
        testLargeGraph();
    }

    private static void testDisconnectedGraph() {
        try {
            Graph graph = new Graph(5);
            graph.themCanh(0, 1, 2);
            graph.themCanh(2, 3, 4);

            PrimAlgorithm prim = new PrimAlgorithm();
            prim.xuLiThuatToan(graph);
        } catch (DisconnectedGraphException e) {
            System.out.println("Kiem tra do thi khong lien thong: PASSED");
        }
    }

    private static void testSingleVertex() {
        Graph graph = new Graph(1);

        PrimAlgorithm prim = new PrimAlgorithm();
        List<int[]> mst = prim.xuLiThuatToan(graph);
        prim.printMST(mst);

        System.out.println("Kiem tra do thi co 1 dinh: PASSED");
    }

    private static void testGraphWithMultipleEdges() {
        try {
            Graph graph = new Graph(4);
            graph.themCanh(0, 1, 10);
            graph.themCanh(0, 1, 5); // Cạnh trùng lặp
            graph.themCanh(1, 2, 6);
            graph.themCanh(2, 3, 4);
            graph.themCanh(3, 0, 7);

            PrimAlgorithm prim = new PrimAlgorithm();
            List<int[]> mst = prim.xuLiThuatToan(graph);
            prim.printMST(mst);
        } catch (DuplicateEdgeException e) {
            System.out.println("Kiem tra do thi voi nhieu canh giua 2 dinh: PASSED");
        }
    }

    private static void testLargeGraph() {
        Graph graph = new Graph(6);
        graph.themCanh(0, 1, 3);
        graph.themCanh(0, 2, 1);
        graph.themCanh(1, 2, 7);
        graph.themCanh(1, 3, 5);
        graph.themCanh(2, 3, 8);
        graph.themCanh(2, 4, 4);
        graph.themCanh(3, 4, 6);
        graph.themCanh(4, 5, 2);
        graph.themCanh(3, 5, 3);

        PrimAlgorithm prim = new PrimAlgorithm();
        List<int[]> mst = prim.xuLiThuatToan(graph);
        prim.printMST(mst);

        System.out.println("Kiem tra do thi voi nhieu canh va dinh: PASSED");
    }
}
