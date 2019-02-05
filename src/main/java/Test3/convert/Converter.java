package Test3.convert;

import Test3.model.Rule;
import Test3.model.Task;

import static Test3.utils.Constants.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс содержит метод решения задачи в зависимости от списка правил.
 */
public class Converter {
    private DecimalFormat format = new DecimalFormat("0.#");
    private List<Rule> rules;

    /**
     * Метод решения задачи.
     *
     * @param task задача, чтобы найти значение in.
     * @return полную пропорцию в строковом представлении или
     * предупреждении если конвертация невозможна.
     */
    public String calculate(Task task) {

        List<Rule> ruleList = new ArrayList<>();
        ruleList.addAll(rules);

        Task primaryTask = task;

        if (ruleList.isEmpty()) {
            return FAIL;
        }

        Rule result = null;
        Rule used = null;
        Task bufferTask = null;
        while (true) {
            for (Rule rule : ruleList) {
                result = process(rule, task);
                if (result != null) {
                    break;
                }
            }

            if (result == null) {
                for (Rule rule : ruleList) {
                    bufferTask = deepProcess(rule, task);
                    if (bufferTask != null) {
                        task = bufferTask;
                        used = rule;
                        break;
                    }
                }
                if (bufferTask == null) {
                    return FAIL;
                }
            }

            if (result != null && (result.getTypeA().equals(task.getTypeB())
                    || result.getTypeB().equals(task.getTypeB()))) {
                break;
            }
            ruleList.remove(used);
        }

        StringBuilder builder = new StringBuilder();
        builder.append(format.format(primaryTask.getNumberA()));
        builder.append(SPACE);
        builder.append(primaryTask.getTypeA());
        builder.append(SPACE);
        builder.append(EQUAL);
        builder.append(SPACE);
        builder.append(format.format((result.getTypeA().equals(task.getTypeB()))
                ? (result.getNumberA()) : (result.getNumberB())));
        builder.append(SPACE);
        builder.append(task.getTypeB());

        return builder.toString();
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    /**
     * Рассчитывает всю пропорцию.
     *
     * @param rule правило.
     * @param task задача.
     * @return вся пропорция - правило.
     */
    private Rule process(Rule rule, Task task) {
        Rule result = null;

        if (rule.getTypeA().equals(task.getTypeA())
                && rule.getTypeB().equals(task.getTypeB())) {
            result = new Rule(
                    task.getNumberA(),
                    task.getTypeA(),
                    rule.getNumberB() * task.getNumberA() / rule.getNumberA(),
                    task.getTypeB()
            );
        } else if (rule.getTypeA().equals(task.getTypeB())
                && rule.getTypeB().equals(task.getTypeA())) {
            result = new Rule(
                    task.getNumberA(),
                    task.getTypeA(),
                    rule.getNumberA() * task.getNumberA() / rule.getNumberB(),
                    task.getTypeB()
            );
        }
        return result;
    }

    /**
     * Метод для подбора задачи по существующему правилу на случай, если мы не можем получить результат сейчас.
     * @param rule правило.
     * @param task задача.
     * @return выполнение задачи по заданным правилам.
     */
    private Task deepProcess(Rule rule, Task task) {
        Task result = null;
        if (rule.getTypeA().equals(task.getTypeA())) {
            double coefficient = task.getNumberA() / rule.getNumberA();
            result = new Task(
                    rule.getNumberB() * coefficient,
                    rule.getTypeB(),
                    task.getTypeB()
            );
        } else if (rule.getTypeB().equals(task.getTypeA())) {
            double coefficient = task.getNumberA() / rule.getNumberB();
            result = new Task(
                    rule.getNumberA() * coefficient,
                    rule.getTypeA(),
                    task.getTypeB()
            );
        }
        return result;
    }
}
