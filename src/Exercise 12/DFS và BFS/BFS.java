import java.util.*;

public class BFSExample {
    static int[][] grid = {
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 0},
            {1, 0, 0, 0}
    };
    static boolean[][] visited;
    static int n = grid.length;
    static int m = grid[0].length;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        visited = new boolean[n][m];
        int maxRegion = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        System.out.println("Largest region size: " + maxRegion);
    }

    static int bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int k = 0; k < 8; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    count++;
                }
            }
        }
        return count;
    }
}
