package Test2;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Action {

    /*
        Запись в файл
     */
    public void write(int number) throws Exception {
        PrintWriter writer = new PrintWriter("out.txt", "UTF-8");
        writer.println(number);
        writer.close();
    }

    /*
        Чтение из файла
     */
    public String read() throws Exception {
        FileReader fr = new FileReader("out.txt");
        Scanner scan = new Scanner(fr);
        String word = null;
        while (scan.hasNext()) {
            word = scan.nextLine();
        }
        fr.close();
        return word;
    }
}

