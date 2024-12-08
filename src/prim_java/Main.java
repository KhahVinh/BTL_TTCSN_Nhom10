
package prim_java;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tạo đồ thị
        Graph graph = new Graph(5);
        graph.themCanh(0, 1, 2);
        graph.themCanh(0, 3, 6);
        graph.themCanh(1, 2, 3);
        graph.themCanh(1, 3, 8);
        graph.themCanh(1, 4, 5);
        graph.themCanh(2, 4, 7);
        graph.themCanh(3, 4, 9);

        // Thực hiện thuật toán Prim
        PrimAlgorithm prim = new PrimAlgorithm();
        List<int[]> mst = prim.xuLiThuatToan(graph);

        // In kết quả
        prim.printMST(mst);
    }
}
