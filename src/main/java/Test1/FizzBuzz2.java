package Test1;

import java.util.Scanner;

public class FizzBuzz2 {
    public static void main(String[] args) {
        Numbers numbers = new Numbers();

        Scanner in = new Scanner(System.in);
        System.out.print("Введите число: ");
        try {
            System.out.println(numbers.fizzBuzz(in.nextInt()));
        } catch (Exception ex) {
            System.out.println("Некорректный ввод данных");
        }
    }
}
