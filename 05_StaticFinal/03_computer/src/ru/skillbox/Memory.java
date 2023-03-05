package ru.skillbox;
/**
 * Оперативная память:
 * <p>
 * тип,
 * объём,
 * вес.
 */
public class Memory {

    private final Type type;
    private final int capacity;
    private final double weight;


    public enum Type {
        DDR,
        DDR2,
        DDR3,
        DDR4,
        DDR5
    }

    public Memory(Type type, int capacity, double weight) {
        this.type = type;
        this.capacity = capacity;
        this.weight = weight;
    }

    public Type getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\n  Memory" +
                "\n     type = '" + type +
                "', capacity = " + capacity +
                ", weight = " + weight;
    }
}
