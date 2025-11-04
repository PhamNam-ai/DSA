import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'connectedCell' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int connectedCell(List<List<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        boolean[][] visited = new boolean[n][m];
        int maxRegion = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix.get(i).get(j) == 1 && !visited[i][j]){
                    int size = dfs(matrix, visited, i, j, n, m);
                    maxRegion = Math.max(maxRegion, size);
                }
            }
        }
        return maxRegion;
        // Write your code here

    }
    private static int dfs(List<List<Integer>> matrix, boolean[][] visited, int row, int col, int n, int m) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        visited[row][col] = true;
        int count = 1;
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0];
            int c = cell[1];
            for (int k = 0; k < 8; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        matrix.get(nr).get(nc) == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    count++;
                    stack.push(new int[]{nr, nc});
                }
            }
        }

        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> matrix = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                matrix.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.connectedCell(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
