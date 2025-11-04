public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Bước 1: Tạo danh sách kề (adjacency list)
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<>());
    }

    for (List<Integer> edge : edges) {
        int u = edge.get(0);
        int v = edge.get(1);
        graph.get(u).add(v);
        graph.get(v).add(u);  // vì đồ thị vô hướng
    }

    // Bước 2: Tạo mảng dist và khởi tạo
    int[] dist = new int[n + 1];
    Arrays.fill(dist, -1);  // chưa thăm
    dist[s] = 0;

    // Bước 3: BFS
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);

    while (!queue.isEmpty()) {
        int u = queue.poll();
        for (int v : graph.get(u)) {
            if (dist[v] == -1) { // chưa thăm
                dist[v] = dist[u] + 6;  // cạnh có trọng số 6
                queue.add(v);
            }
        }
    }

    // Bước 4: Chuẩn bị kết quả (bỏ qua đỉnh start)
    List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        if (i != s) {
            result.add(dist[i]);
        }
    }

    return result;
}
