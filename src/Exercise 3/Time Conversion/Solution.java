import java.io.*;
import java.util.*;

class Result {

    public static String timeConversion(String s) {
        String ampm = s.substring(8, 10);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);

        if (ampm.equals("AM")) {
            if (hour == 12) hour = 0;
        } else {
            if (hour != 12) hour += 12;
        }

        return String.format("%02d%s", hour, rest);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();
        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
