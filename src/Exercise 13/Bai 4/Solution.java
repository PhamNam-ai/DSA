import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    // ✅ Lớp Edge để lưu thông tin 1 cạnh (u, v, w)
    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        // So sánh theo trọng số (dùng cho sort)
        public int compareTo(Edge other) {
            return Integer.compare(this.w, other.w);
        }
    }

    // ✅ Cấu trúc Union-Find (Disjoint Set Union - DSU)
    static class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) parent[i] = i;
        }

        // Tìm gốc của 1 tập hợp (có nén đường đi)
        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        // Hợp nhất 2 tập hợp (union by rank)
        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false; // cùng tập -> bỏ qua (tránh chu trình)

            if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
            else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
            else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    /*
     * ✅ Hàm chính: Thuật toán Kruskal
     * Bước:
     * 1️⃣ Gộp các cạnh (u,v,w) vào danh sách.
     * 2️⃣ Sắp xếp các cạnh tăng dần theo w.
     * 3️⃣ Duyệt qua từng cạnh, nếu 2 đỉnh chưa nối -> nối vào MST.
     * 4️⃣ Tính tổng trọng số các cạnh trong MST.
     */
    public static int kruskals(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
        List<Edge> edges = new ArrayList<>();

        // Gộp dữ liệu thành danh sách cạnh
        for (int i = 0; i < gFrom.size(); i++) {
            edges.add(new Edge(gFrom.get(i), gTo.get(i), gWeight.get(i)));
        }

        // ✅ Bước 1: Sắp xếp cạnh theo trọng số tăng dần
        Collections.sort(edges);

        // ✅ Bước 2: Tạo DSU và tổng trọng số ban đầu = 0
        DSU dsu = new DSU(gNodes);
        int totalWeight = 0;

        // ✅ Bước 3: Duyệt từng cạnh
        for (Edge e : edges) {
            if (dsu.union(e.u, e.v)) {
                totalWeight += e.w; // thêm vào MST nếu không tạo chu trình
            }
        }

        return totalWeight; // ✅ Tổng trọng số MST
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] gNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int gNodes = Integer.parseInt(gNodesEdges[0]);
        int gEdges = Integer.parseInt(gNodesEdges[1]);

        List<Integer> gFrom = new ArrayList<>();
        List<Integer> gTo = new ArrayList<>();
        List<Integer> gWeight = new ArrayList<>();

        // Nhập danh sách cạnh
        IntStream.range(0, gEdges).forEach(i -> {
            try {
                String[] parts = bufferedReader.readLine().trim().split(" ");
                gFrom.add(Integer.parseInt(parts[0]));
                gTo.add(Integer.parseInt(parts[1]));
                gWeight.add(Integer.parseInt(parts[2]));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int res = Result.kruskals(gNodes, gFrom, gTo, gWeight);

        // ✅ In ra tổng trọng số của cây bao trùm nhỏ nhất
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
