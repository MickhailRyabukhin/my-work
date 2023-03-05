package ru.skillbox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Elevator elevator = new Elevator(-3, 26);
        Scanner scanner=new Scanner(System.in);
        System.out.println("Секретный выход на -12 этаже...");
        int floor = 0;

        while (floor>-12) {
            System.out.print("Введите номер этажа: ");
            floor = scanner.nextInt();
            elevator.move(floor);
        }
    }
}