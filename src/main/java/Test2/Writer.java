package Test2;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Writer {

    static TwoThreads mAnotherOpinion1;    //Побочный поток
    static TwoThreads mAnotherOpinion2;    //Побочный поток 2
    static String message = "Неверный ввод данных";

    static AtomicInteger value = new AtomicInteger(0);

    public static void main(String[] args) {
        Action action = new Action();
        System.out.println("Введите число: ");
        mAnotherOpinion1 = new TwoThreads(value);    //Создание потока 1
        mAnotherOpinion2 = new TwoThreads(value);    //Создание потока 2
        try {
            Scanner in = new Scanner(System.in);
            int number = in.nextInt();
            value.set(number);
            if (number % 2 == 0 && number != 0) {
                action.write(0);
                mAnotherOpinion1.start();
                mAnotherOpinion2.start();
            } else {
                System.out.println(message + ", число должно быть целое, кратное 2 и больше 0");
            }
        } catch (Exception e) {
            System.out.println(message + " " + e.getLocalizedMessage());
        }
    }
}