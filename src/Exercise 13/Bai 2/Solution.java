import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    static class Cost implements Comparable<Cost> {
        public int r, v;
        public Cost(int cost, int vertex) { r = cost; v = vertex; }
        @Override
        public int compareTo(Cost c) {
            int cmp = Integer.compare(this.r, c.r);
            if (cmp != 0) return cmp;
            return Integer.compare(this.v, c.v);
        }
    }

    public static int prims(int n, List<List<Integer>> edges, int start) {
        List<List<Cost>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (List<Integer> e : edges) {
            int u = e.get(0), v = e.get(1), w = e.get(2);
            graph.get(u).add(new Cost(w, v));
            graph.get(v).add(new Cost(w, u));
        }

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Cost> pq = new PriorityQueue<>();
        pq.add(new Cost(0, start));
        int totalCost = 0, count = 0;

        while (!pq.isEmpty() && count < n) {
            Cost cur = pq.poll();
            int u = cur.v;
            if (visited[u]) continue;
            visited[u] = true;
            totalCost += cur.r;
            count++;
            for (Cost nei : graph.get(u))
                if (!visited[nei.v]) pq.add(new Cost(nei.r, nei.v));
        }
        return totalCost;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw;
        String outPath = System.getenv("OUTPUT_PATH");
        if (outPath == null || outPath.isEmpty())
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        else
            bw = new BufferedWriter(new FileWriter(outPath));

        String[] nm = br.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        List<List<Integer>> edges = new ArrayList<>();
        IntStream.range(0, m).forEach(i -> {
            try {
                edges.add(Stream.of(br.readLine().trim().split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) { throw new RuntimeException(ex); }
        });

        int start = Integer.parseInt(br.readLine().trim());
        int result = Result.prims(n, edges, start);
        bw.write(String.valueOf(result));
        bw.newLine();
        br.close();
        bw.close();
    }
}
