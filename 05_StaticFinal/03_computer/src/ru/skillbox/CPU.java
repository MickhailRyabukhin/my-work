package ru.skillbox;
/**
 * 1.   Процессор:
 * частота,
 * количество ядер,
 * производитель,
 * вес.
 */
public class CPU {

    private final int frequency;
    private final int coreCount;
    private final String vendor;
    private final double weight;

    public CPU(int frequency, int coreCount, String vendor, double weght) {
        this.frequency = frequency;
        this.coreCount = coreCount;
        this.vendor = vendor;
        this.weight = weght;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getCoreCount() {
        return coreCount;
    }

    public String getVendor() {
        return vendor;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "\n  CPU" +
                "\n     frequency = " + frequency +
                ", coreCount = " + coreCount +
                ", vendor = '" + vendor +
                "', weght = " + weight;
    }
}
