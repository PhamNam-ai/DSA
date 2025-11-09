import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

// -------------------------
// Lớp Result chứa hàm prims()
// -------------------------
class Result {

    // ---- Lớp Cost: Lưu thông tin 1 cạnh (chi phí, đỉnh kề) ----
    // implements Comparable để sắp xếp theo trọng số nhỏ nhất trong PriorityQueue
    static class Cost implements Comparable<Cost> {
        public int r;  // r = cost (trọng số cạnh)
        public int v;  // v = đỉnh kề

        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }

        // So sánh 2 Cost theo trọng số (ưu tiên nhỏ nhất)
        @Override
        public int compareTo(Cost c) {
            int cmp = Integer.compare(this.r, c.r);
            if (cmp != 0) return cmp;
            return Integer.compare(this.v, c.v);
        }
    }

    // -------------------------------------------
    // Thuật toán Prim: tìm tổng trọng số của MST
    // -------------------------------------------
    public static int prims(int n, List<List<Integer>> edges, int start) {
        // Tạo đồ thị dưới dạng danh sách kề
        // Mỗi phần tử graph[u] là 1 danh sách các cạnh (Cost) từ u đến các đỉnh kề
        List<List<Cost>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        // Duyệt qua toàn bộ danh sách cạnh để xây dựng graph
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            // Vì đồ thị vô hướng → thêm 2 chiều
            graph.get(u).add(new Cost(w, v));
            graph.get(v).add(new Cost(w, u));
        }

        // Mảng visited đánh dấu đỉnh đã nằm trong cây MST hay chưa
        boolean[] visited = new boolean[n + 1];

        // Hàng đợi ưu tiên (min-heap) lưu các cạnh theo trọng số nhỏ nhất
        PriorityQueue<Cost> pq = new PriorityQueue<>();

        // Bắt đầu từ đỉnh start
        pq.add(new Cost(0, start));

        int totalCost = 0;  // Tổng trọng số của MST
        int count = 0;      // Số đỉnh đã chọn

        // Lặp cho đến khi hàng đợi rỗng hoặc đã chọn đủ n đỉnh
        while (!pq.isEmpty() && count < n) {
            Cost cur = pq.poll(); // Lấy cạnh có trọng số nhỏ nhất ra

            int u = cur.v;
            if (visited[u]) continue; // Nếu đỉnh đã có trong MST → bỏ qua

            visited[u] = true;  // Đánh dấu đỉnh này đã được chọn
            totalCost += cur.r; // Cộng trọng số cạnh vào tổng chi phí MST
            count++;            // Tăng số đỉnh trong MST

            // Duyệt các cạnh kề của u
            for (Cost nei : graph.get(u)) {
                // Nếu đỉnh kề chưa được chọn → thêm vào hàng đợi
                if (!visited[nei.v])
                    pq.add(new Cost(nei.r, nei.v));
            }
        }

        // Trả về tổng trọng số của cây bao trùm nhỏ nhất
        return totalCost;
    }
}


// -------------------------
// Lớp Solution: Hàm main()
// -------------------------
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Ghi ra file nếu có OUTPUT_PATH, còn không thì in ra màn hình
        BufferedWriter bw;
        String outPath = System.getenv("OUTPUT_PATH");
        if (outPath == null || outPath.isEmpty())
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        else
            bw = new BufferedWriter(new FileWriter(outPath));

        // Đọc số đỉnh (n) và số cạnh (m)
        String[] nm = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // Đọc danh sách các cạnh
        List<List<Integer>> edges = new ArrayList<>();
        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(Stream.of(br.readLine().trim().split(" "))
                        .map(Integer::parseInt)
                        .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        // Đọc đỉnh bắt đầu (start)
        int start = Integer.parseInt(br.readLine().trim());

        // Gọi hàm Prim để tính MST
        int result = Result.prims(n, edges, start);

        // In kết quả
        bw.write(String.valueOf(result));
        bw.newLine();

        // Đóng file
        br.close();
        bw.close();
    }
}
