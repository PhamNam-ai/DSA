import java.io.*;
import java.util.*;

class Result {

    static class Node implements Comparable<Node> {
        int value;
        int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int compareTo(Node other) {
            if (this.value != other.value) return Integer.compare(this.value, other.value);
            return Integer.compare(this.index, other.index);
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> res = new ArrayList<>();
        TreeSet<Node> tree = new TreeSet<>();
        Node mid = null;

        for (int i = 0; i < a.size(); i++) {
            Node node = new Node(a.get(i), i);
            tree.add(node);

            if (mid == null) {
                mid = node;
            } else if (a.get(i) < mid.value || (a.get(i) == mid.value && i < mid.index)) {
                if (tree.headSet(mid).size() > tree.tailSet(mid, false).size())
                    mid = tree.lower(mid);
            } else {
                if (tree.tailSet(mid, false).size() > tree.headSet(mid).size())
                    mid = tree.higher(mid);
            }

            int size = tree.size();
            if (size % 2 == 1) {
                res.add((double) mid.value);
            } else {
                Node left = mid;
                Node right = tree.higher(mid);
                res.add((left.value + right.value) / 2.0);
            }
        }

        return res;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);
        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));
            if (i != result.size() - 1) bufferedWriter.write("\n");
        }
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


Ex : a = [5, 15, 1, 3]