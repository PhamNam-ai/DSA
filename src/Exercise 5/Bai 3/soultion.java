import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int d = in.nextInt();
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < d; j++) {
                row.add(in.nextInt());
            }
            data.add(row);
        }

        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int x = in.nextInt();
            int y = in.nextInt();

            if (x >= 1 && x <= data.size()) {
                ArrayList<Integer> row = data.get(x - 1);
                if (y >= 1 && y <= row.size()) {
                    System.out.println(row.get(y - 1));
                } else {
                    System.out.println("ERROR!");
                }
            } else {
                System.out.println("ERROR!");
            }
        }

        in.close(); //
    }
}
