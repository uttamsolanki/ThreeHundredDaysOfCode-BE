package count_sorted_vowel_strings.Java;

import java.io.*;
import java.util.*;

public class Driver {

    private static List<String> method(String filePath) {
        ArrayList<String> al = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(
                new FileReader(filePath))) {

            String str;
            while ((str = buffer.readLine()) != null) {
                al.add(str);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
        return al;
    }

    public static void main(String[] args) {
        System.out.println(drivercode() ? "Accepted" : "Wrong Answer");
    }

    static boolean drivercode() {
        String filePath = "src/count_sorted_vowel_strings/testcases.txt";
        List<String> al = method(filePath);
        al.remove(0);
        int input1 = 0;
        int output;
        boolean b = true;
        for (int i = 0; i < al.size(); i++) {
            if (i % 2 == 0) {
                input1 = Integer.parseInt(al.get(i));
            } else {
                output = Integer.parseInt(al.get(i));
                int user_output = count(input1);
                b = b & output == user_output ? true : false;
                if (b == false) {
                    System.out.println("Expected answer " + output);
                    System.out.println("Your answer " + user_output);
                    return b;
                }
            }
        }
        return b;
    }

    public static int count(int n) {
        Solution sol = new Solution();
        return sol.countVowelStrings(n);
    }
}
