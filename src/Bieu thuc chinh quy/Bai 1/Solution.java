import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder html = new StringBuilder();

        while (sc.hasNextLine()) {
            html.append(sc.nextLine());
        }
        sc.close();

        Pattern p = Pattern.compile("<a\\s+[^>]*href\\s*=\\s*\"([^\"]*)\"[^>]*>(.*?)</a>");
        Matcher m = p.matcher(html.toString());

        while (m.find()) {
            String href = m.group(1);
            String text = m.group(2).replaceAll("<[^>]*>", "");
            text = text.trim();
            System.out.println(href + "," + text);
        }
    }
}
