package ru.skillbox;
/**
 * Клавиатура:
 *
 *     тип,
 *     наличие подсветки,
 *     вес.
 */
public class KeyBoard {
    private final String type;
    private final boolean hasLight;
    private final double weight;

    public KeyBoard(String type, boolean hasLight, double weight) {
        this.type = type;
        this.hasLight = hasLight;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public boolean hasLight() {
        return hasLight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\n  KeyBoard" +
                "\n     type = '" + type +
                "', hasLight = " + hasLight +
                ", weight = " + weight;
    }
}
