import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder();
        Deque<String> hist = new ArrayDeque<>();
        StringBuilder out = new StringBuilder();
        int q = Integer.parseInt(br.readLine().trim());
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            if (t == 1) {
                hist.push(s.toString());
                s.append(st.nextToken());
            } else if (t == 2) {
                hist.push(s.toString());
                int k = Integer.parseInt(st.nextToken());
                s.delete(s.length() - k, s.length());
            } else if (t == 3) {
                int k = Integer.parseInt(st.nextToken());
                out.append(s.charAt(k - 1)).append('\n');
            } else if (t == 4) {
                if (!hist.isEmpty()) s = new StringBuilder(hist.pop());
            }
        }
        System.out.print(out.toString());
        br.close();
    }
}
