import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    // ✅ Lớp Cost dùng để lưu thông tin cạnh: (khoảng cách, đỉnh kề)
    // implements Comparable để dùng được trong PriorityQueue (xếp theo khoảng cách nhỏ nhất)
    static class Cost implements Comparable<Cost> {
        public int r; // trọng số hoặc tổng chi phí
        public int v; // đỉnh kề

        public Cost(int cost, int vertex) {
            r = cost;
            v = vertex;
        }

        @Override
        public int compareTo(Cost c) {
            // Sắp xếp theo chi phí nhỏ nhất
            int cmp = Integer.compare(this.r, c.r);
            if (cmp != 0) return cmp;
            return Integer.compare(this.v, c.v);
        }
    }

    /*
     * Dijkstra - tìm đường đi ngắn nhất từ 1 đỉnh s tới các đỉnh còn lại
     * n: số đỉnh
     * edges: danh sách cạnh (u, v, w)
     * s: đỉnh bắt đầu
     */
    public static List<Integer> shortestReach(int n, List<List<Integer>> edges, int s) {

        // ✅ 1. Tạo danh sách kề có trọng số
        List<List<Cost>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        // Thêm cạnh 2 chiều (vì đồ thị vô hướng)
        for (List<Integer> e : edges) {
            int u = e.get(0);
            int v = e.get(1);
            int w = e.get(2);
            graph.get(u).add(new Cost(w, v));
            graph.get(v).add(new Cost(w, u));
        }

        // ✅ 2. Khởi tạo mảng khoảng cách ban đầu
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE); // mọi đỉnh ban đầu vô cực
        boolean[] visited = new boolean[n + 1]; // mảng đánh dấu đỉnh đã được chọn

        // ✅ 3. Dùng PriorityQueue để luôn lấy đỉnh có khoảng cách nhỏ nhất
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        dist[s] = 0;                 // đỉnh xuất phát có khoảng cách = 0
        pq.add(new Cost(0, s));      // đưa vào hàng đợi

        // ✅ 4. Bắt đầu thuật toán Dijkstra
        while (!pq.isEmpty()) {
            Cost cur = pq.poll();    // lấy đỉnh có khoảng cách nhỏ nhất
            int u = cur.v;

            if (visited[u]) continue; // nếu đỉnh này đã xử lý rồi thì bỏ qua
            visited[u] = true;

            // Duyệt tất cả các đỉnh kề của u
            for (Cost nei : graph.get(u)) {
                // Nếu chưa thăm và có đường ngắn hơn qua u → cập nhật
                if (!visited[nei.v] && dist[u] + nei.r < dist[nei.v]) {
                    dist[nei.v] = dist[u] + nei.r;
                    pq.add(new Cost(dist[nei.v], nei.v)); // thêm vào hàng đợi
                }
            }
        }

        // ✅ 5. Tạo danh sách kết quả: bỏ đỉnh xuất phát, thay vô cực bằng -1
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            res.add(dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }

        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(br.readLine().trim()); // số bộ test

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] nm = br.readLine().trim().split(" ");
                int n = Integer.parseInt(nm[0]); // số đỉnh
                int m = Integer.parseInt(nm[1]); // số cạnh

                // Nhập danh sách cạnh
                List<List<Integer>> edges = new ArrayList<>();
                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(Stream.of(br.readLine().trim().split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
                    } catch (IOException ex) { throw new RuntimeException(ex); }
                });

                int s = Integer.parseInt(br.readLine().trim()); // đỉnh xuất phát

                // Gọi hàm Dijkstra
                List<Integer> result = Result.shortestReach(n, edges, s);

                // In kết quả ra file/output
                try {
                    bw.write(result.stream().map(Object::toString)
                            .collect(Collectors.joining(" ")) + "\n");
                } catch (IOException ex) { throw new RuntimeException(ex); }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        br.close();
        bw.close();
    }
}
