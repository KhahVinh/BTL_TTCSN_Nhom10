
package prim_java;

import java.util.Arrays;
import prim_java.exception.*;

public class Graph {
    private int V; // Số đỉnh
    private int[][] maTranTrongSo; // Ma trận trọng số

    // Constructor
    public Graph(int V) {
        this.V = V;
        this.maTranTrongSo = new int[V][V];
        for (int[] row : maTranTrongSo) {
            Arrays.fill(row, Integer.MAX_VALUE); // Gán giá trị INF
        }
    }

    // Thêm cạnh
    // Đỉnh u, đỉnh v, trọng số weight
    public void themCanh(int u, int v, int trongSo) {
        if (u < 0 || u >= v || v < 0 || v >= V) {
            throw new InvalidGraphException("Chi so dinh khong hop le!");
        }
        if (trongSo <= 0) {
            throw new InvalidGraphException("Trong so canh phai la so duong!");
        }
        if (maTranTrongSo[u][v] != Integer.MAX_VALUE) {
            throw new DuplicateEdgeException(
                "Canh giua " + u + " va " + v + " da ton tai."
            );
        }
        maTranTrongSo[u][v] = trongSo;
        maTranTrongSo[v][u] = trongSo; // Đồ thị vô hướng
    }

    // Trả về số đỉnh
    public int laySoDinh() {
        return V;
    }

    // Trả về ma trận trọng số
    public int[][] layMaTranTrongSo() {
        return maTranTrongSo;
    }
}

