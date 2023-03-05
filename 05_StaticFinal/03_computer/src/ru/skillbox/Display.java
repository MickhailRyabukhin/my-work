package ru.skillbox;

/**
 * Экран:
 * <p>
 * диагональ,
 * тип (IPS, TN, VA),
 * вес.
 */
public class Display {
    private final int diagonal;
    private final
    Type type;
    private final double weight;

    public enum Type {
        IPS,
        TN,
        VA
    }


    public Display(int diagonal, Type type, double weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public Type getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\n  Display" +
                "\n     diagonal = " + diagonal +
                ", type = '" + type +
                "', weight = " + weight;
    }
}
