import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int q = sc.nextInt();
        while (q-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                s1.push(sc.nextInt());
            } else if (type == 2) {
                if (s2.isEmpty()) while (!s1.isEmpty()) s2.push(s1.pop());
                if (!s2.isEmpty()) s2.pop();
            } else if (type == 3) {
                if (s2.isEmpty()) while (!s1.isEmpty()) s2.push(s1.pop());
                if (!s2.isEmpty()) System.out.println(s2.peek());
            }
        }
        sc.close();
    }
}
