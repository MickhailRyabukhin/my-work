package ru.skillbox;

/**
 * Накопитель информации:
 * тип — HDD, SSD,
 * объём памяти,
 * вес.
 */
public class Storage {


    private final Type type;
    private final int capacity;
    private final double weight;

    public enum Type {
        HDD,
        SSD
    }

    public Storage(Type type, int capacity, double weight) {
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
        return "\n  Storage" +
                "\n     type = '" + type +
                "', capacity = " + capacity +
                ", weight = " + weight;
    }
}
