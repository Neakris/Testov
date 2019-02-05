package Test3.utils;

import Test3.model.Proportion;
import Test3.model.Rule;
import Test3.model.Task;

import java.util.ArrayList;
import java.util.List;

import static Test3.utils.Constants.*;

/**
 * Содержит методы для анализа текста.
 */
public class Parser {

    /**
     * Метод анализирует текст в списке пропорций.
     *
     * @param text текст для разбора.
     * @return список пропорций из текста.
     */
    public List<Proportion> parse(String text) {
        List<Proportion> proportions = new ArrayList<>();
        if (text == null || text.isEmpty()) {
            return proportions;
        }

        String[] lines = text.split(NEXT_LINE);
        if (lines.length == 0) {
            return proportions;
        }
        String[] items;
        for (String line : lines) {
            if (line == null) {
                continue;
            }
            items = line.split(SPACE);
            if (items.length != 5 || !items[2].equals(EQUAL)) {
                continue;
            }
            try {
                if (items[3].equals(UNKNOWN)) {
                    proportions.add(new Task(
                            Double.parseDouble(items[0]),
                            items[1],
                            items[4]
                    ));
                } else {
                    proportions.add(new Rule(
                            Double.parseDouble(items[0]),
                            items[1],
                            Double.parseDouble(items[3]),
                            items[4]
                    ));
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }

        return proportions;
    }
}
