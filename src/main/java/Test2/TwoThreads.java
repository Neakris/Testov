package Test2;

import java.util.concurrent.atomic.AtomicInteger;

public class TwoThreads extends Thread {
    Action action = new Action();
    AtomicInteger value;
    Integer num;
    String number;

    public TwoThreads(AtomicInteger value) {
        this.value = value;
        num = 0;
    }

    @Override
    public void run() {
        synchronized (value) {
            try {
                while (num < value.get() - 1) {
                    number = action.read();
                    num = Integer.parseInt(number);
                    num++;
                    action.write(num);
                    //        sleep(1000);        //Приостанавливает поток
                    System.out.println("Число в файлике: " + num);
                }
            } catch (Exception ex) {
                System.out.println("Ошибка в побочном потоке " + ex.getLocalizedMessage());
            }
        }
    }
}
