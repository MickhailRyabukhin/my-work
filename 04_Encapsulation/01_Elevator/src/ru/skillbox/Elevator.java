package ru.skillbox;

/**
 * Что нужно сделать
 * <p>
 * - Создайте класс Elevator, эмулирующий работу пассажирского лифта.
 * - В классе создайте:
 * - Переменные currentFloor (текущий этаж), minFloor и maxFloor (минимальный и максимальный этажи).
 * Тип переменных — int.Значение переменной currentFloor изначально должно быть равно 1.
 * - Конструктор с двумя параметрами minFloor и maxFloor, сохраняющий эти параметры в соответствующих переменных класса.
 * - Метод getCurrentFloor, возвращающий текущий этаж, на котором находится лифт.
 * - Метод moveDown, перемещающий лифт на один этаж вниз (уменьшающий значение переменной currentFloor на единицу).
 * - Метод moveUp, перемещающий лифт на один этаж вверх.
 * - Метод move(int floor), перемещающий лифт на заданный в параметре этаж, если он задан верно.
 * Если параметр у метода задан неверно, ничего не делать и выводить в консоль сообщение об ошибке.
 * Этот метод может перемещать лифт только последовательно, по одному этажу, с помощью циклов и
 * методов moveUp и moveDown, и должен выводить в консоль текущий этаж после каждого перемещения между этажами.
 */

public class Elevator {
    private int minFloor;
    private int maxFloor;
    private int currentFloor = 1;


    public Elevator(int minFloor, int maxFloor) {           // конструктор для получения ограничений
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int moveUp() {
        return currentFloor = (currentFloor < maxFloor) ? (currentFloor + 1) : currentFloor;

    }


    public int moveDown() {
        return currentFloor = (currentFloor > minFloor) ? currentFloor - 1 : currentFloor;


    }


    public void move(int destFloor) {
        if (destFloor > maxFloor||destFloor<minFloor) {
            System.out.println("Введен неправильный этаж");
            return;
        }
            for (int i = currentFloor; i > destFloor; i = i - 1) {
                moveDown();
                System.out.println(currentFloor + "  этаж");
            }
            for (int i = currentFloor; i < destFloor; i = i + 1) {
                moveUp();
                System.out.println(currentFloor + "  этаж");
            }
        }
    }
