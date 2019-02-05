package Test3;

import Test3.convert.Converter;
import Test3.model.Proportion;
import Test3.model.Rule;
import Test3.model.Task;
import Test3.utils.Parser;

import static Test3.utils.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Главный класс запуска приложения.
 */
public class Start {

    /**
     * Точка входа в приложение.
     * Метод читает текст из «стандартного» потока ввода System.in,
     * вычисляет задачи из текста и записывает результат по «стандартному» выходному потоку System.out.
     *
     * @param args аргументы командной строки.
     */
    public static void main(String[] args) {
        Converter converter = new Converter();
        Parser parser = new Parser();
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder;
        List<Proportion> proportions;
        List<Rule> rules = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();

        builder = new StringBuilder();
        String line;
        while ((line = scanner.nextLine()).length() > 0) {
            builder.append(line);
            builder.append(NEXT_LINE);
        }

        proportions = parser.parse(builder.toString().trim());
        if (proportions.size() < 2) {
            System.out.println(FAIL);
            return;
        }

        rules.clear();
        tasks.clear();

        for (Proportion proportion : proportions) {
            if (proportion instanceof Rule) {
                rules.add((Rule) proportion);
            } else if (proportion instanceof Task) {
                tasks.add((Task) proportion);
            }
        }

        if (rules.size() < 1 || tasks.size() < 1) {
            System.out.println(FAIL);
            return;
        }

        converter.setRules(rules);

        for (Task task : tasks) {
            System.out.println(converter.calculate(task));
        }
    }
}

