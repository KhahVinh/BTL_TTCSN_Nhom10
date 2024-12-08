
package prim_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import prim_java.exception.*;

public class PrimAlgorithm {
    private static final int INF = Integer.MAX_VALUE;

    // Thực hiện thuật toán Prim
    public List<int[]> xuLiThuatToan(Graph graph) {
        int V = graph.laySoDinh();
        int[][] maTranTrongSo = graph.layMaTranTrongSo();

        Set<Integer> C = new HashSet<>(); // Tập đỉnh trong MST
        Set<Integer> dinhChuaXet = new HashSet<>(); // Đỉnh chưa thăm
        List<int[]> T = new ArrayList<>(); // Danh sách các cạnh trong MST

        // Khởi tạo tập đỉnh ban đầu
        for (int i = 0; i < V; i++) {
            dinhChuaXet.add(i);
        }

        // Bắt đầu từ đỉnh 0
        int startVertex = 0;
        C.add(startVertex);
        dinhChuaXet.remove(startVertex);

        // Điều kiện dừng: Khi tất cả các đỉnh đã nằm trong cây khung
        while (C.size() < V && !dinhChuaXet.isEmpty()) {
            int[] canhNho = canhNhoNhat(C, dinhChuaXet, maTranTrongSo);
            if (canhNho == null) {
                throw new DisconnectedGraphException(
                    "Do thi khong lien thong. Khong the tao cay khung nho nhat."
                );
            }
            T.add(canhNho); // Thêm cạnh vào cây khung
            C.add(canhNho[1]); // Thêm đỉnh mới vào tập đã thăm
            dinhChuaXet.remove(canhNho[1]); // Loại bỏ đỉnh khỏi tập chưa thăm
        }

        return T;
    }
    
    // Tìm cạnh nhỏ nhất nối giữa tập C và đỉnh chưa xét
    private int[] canhNhoNhat(Set<Integer> C, Set<Integer> dinhChuaXet, int[][] maTranTrongSo) {
        int[] canhNho = null;
        int trongSoNho = INF;

        for (int u : C) {
            for (int v : dinhChuaXet) {
                if (maTranTrongSo[u][v] < trongSoNho) {
                    trongSoNho = maTranTrongSo[u][v];
                    canhNho = new int[]{u, v, maTranTrongSo[u][v]};
                }
            }
        }
        return canhNho;
    }
      public void printMST(List<int[]> T) {
        System.out.println("Cay khung nho nhat (MST):");
        System.out.println("Canh \tTrong so");
        for (int[] edge : T) {
            System.out.println(edge[0] + " - " + edge[1] + "\t" + edge[2]);
        }
    }
}

    
