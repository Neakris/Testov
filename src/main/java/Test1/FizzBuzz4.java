package Test1;

import java.util.Scanner;

public class FizzBuzz4 {
    public static void main(String[] args) {
        try {
            Numbers numbers = new Numbers();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите значение для fizz");
            int fizz = scanner.nextInt();
            System.out.println("Введите значение для buzz");
            int buzz = scanner.nextInt();
            System.out.println("Введите лимит для fizzbuzz");
            int limit = scanner.nextInt();

            System.out.println(numbers.buildFizzBuzz(fizz, buzz, limit));
        } catch (Exception exception) {
            System.out.println("Неверное введённое значение" + " " + exception.toString());
        }

    }
}
