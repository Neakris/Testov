package Test3.model;

/**
 * Правила конвертирования значений.
 */
public class Rule extends Proportion {
    public Rule(double numberA, String typeA, double numberB, String typeB) {
        super(numberA, typeA, numberB, typeB);
        if (numberB == Double.NaN) {
            throw new IllegalArgumentException();
        }
    }
}
