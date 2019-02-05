package Test1;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        if (in.hasNextInt()) {
            int num = in.nextInt();

            for (int i = 1; i <= num; i++) {
                boolean fizzOrBuzz = false;
                if (i != 0 && i % 3 == 0) {
                    System.out.print("Fizz");
                    fizzOrBuzz = true;
                }
                if (i != 0 && i % 5 == 0) {
                    System.out.print("Buzz");
                    fizzOrBuzz = true;
                }

                if (fizzOrBuzz) {
                    System.out.println();
                } else {
                    System.out.println(i);
                }
            }
        } else {
            System.out.println("Некорректный ввод данных");
        }
    }
}
