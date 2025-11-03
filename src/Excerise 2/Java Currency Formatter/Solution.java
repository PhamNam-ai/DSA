import java.io.*;
import java.util.*;
import java.text.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat us = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        NumberFormat china = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        String usFormatted = us.format(payment);
        String indiaFormatted = india.format(payment);
        String chinaFormatted = china.format(payment);
        String franceFormatted = france.format(payment);

        System.out.println("US: " + usFormatted);
        System.out.println("India: " + indiaFormatted);
        System.out.println("China: " + chinaFormatted);
        System.out.println("France: " + franceFormatted);
    }
}
