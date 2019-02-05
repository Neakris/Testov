package Test3.model;

/**
 * Абстрактный класс пропорций для входных значений.
 */
public abstract class Proportion {
    private final double numberA;
    private final String typeA;

    private final double numberB;
    private final String typeB;

    public Proportion(double numberA, String typeA, double numberB, String typeB) {
        if (numberA == 0 || numberA == Double.NaN || typeA == null || typeB == null) {
            throw new IllegalArgumentException();
        }
        this.numberA = numberA;
        this.typeA = typeA;
        this.numberB = numberB;
        this.typeB = typeB;
    }

    public double getNumberA() {
        return numberA;
    }

    public String getTypeA() {
        return typeA;
    }

    public double getNumberB() {
        return numberB;
    }

    public String getTypeB() {
        return typeB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Proportion that = (Proportion) o;

        return (Double.compare(that.numberA, numberA) != 0)
                && typeA.equals(that.typeA) && typeB.equals(that.typeB);
    }

    @Override
    public int hashCode() {
        return (int) (numberA * numberB);
    }
}
