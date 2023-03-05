package ru.skillbox;

/**
 * Что нужно сделать
 * <p>
 * 1. Создайте класс Computer с иммутабельными свойствами-комплектующими. Другими словами,
 * Computer имеет возможность менять комплектующие с помощью сеттеров:
 * процессор, оперативную память и так далее.
 * 2 Для каждого такого свойства создайте классы с перечисленными полями
 * (имена классов и полей, а также типы полей придумайте самостоятельно).
 */
public class Computer {

    private final String name;
    private final String vendor;
    public CPU cpu;
    public Memory memory;
    public Storage storage;
    public Display display;
    public KeyBoard keyBoard;

    public Computer(String name, String vendor) {
        this.name = name;
        this.vendor = vendor;
    }

    public double getTotalWeight() {
        return cpu.getWeight()
                + storage.getWeight()
                + display.getWeight()
                + memory.getWeight()
                + keyBoard.getWeight()
                ;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Memory getMemory() {
        return memory;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public KeyBoard getKeyBoard() {
        return keyBoard;
    }

    public void setKeyBoard(KeyBoard keyBoard) {
        this.keyBoard = keyBoard;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String toString() {
        return "Computer" +
                "\n name = '" + name + '\'' +
                ", vendor = '" + vendor + '\'' +
                cpu + memory + storage + display + keyBoard;
    }


}
