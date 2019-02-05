package Test1;

import java.util.Arrays;
import java.util.Scanner;

class FizzBuzz3 {
    public static void main(String[] args) {
            int[] x = new int[100];
            Arrays.setAll(x, j -> j++);
            Arrays.stream(x).forEach(i -> {
                if (i == 0) return;
                String output = "";
                if (i % 3 == 0) output += "Fizz";
                if (i % 5 == 0) output += "Buzz";
                if (output.equals("")) output += i;
                System.out.println(output);
            });
    }
}
