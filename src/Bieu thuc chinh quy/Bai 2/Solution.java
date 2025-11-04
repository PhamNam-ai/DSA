import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder text = new StringBuilder();

        while (sc.hasNextLine()) {
            text.append(sc.nextLine()).append(" ");
        }
        sc.close();

        Pattern p = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher m = p.matcher(text.toString());

        Set<String> emails = new TreeSet<>();

        while (m.find()) {
            emails.add(m.group());
        }

        boolean first = true;
        for (String email : emails) {
            if (!first) System.out.print(";");
            System.out.print(email);
            first = false;
        }
    }
}
