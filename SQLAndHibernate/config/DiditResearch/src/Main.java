/**
 * Задача: вывести на печать все числа от 0 то 1000,
 * кратные 3,
 * не кратные 5,
 * сумма цифр которых меньше 10
 */

public class Main {
    public static int myValue;
    public static int[] valDigigts = new int[4];

    public static void main(String[] args) {
        // разбивка на цифры
        for (myValue = 0; myValue <= 1000; myValue++) {
            digits();
            // Проверка и вывод результата
            if (isOK()) {
                System.out.println(myValue);
            }
        }
    }

    public static void digits() {
        int rest;
        // Разбивка на цифры
        valDigigts[0] = myValue / 1000;
        rest = myValue % 1000;
        valDigigts[1] = rest / 100;
        rest %= 100;
        valDigigts[2] = rest / 10;
        valDigigts[3] = rest % 10;
    }

    public static boolean isOK() {
        // сумма цифр
        int digSum = 0;
        int[] digits = valDigigts;
        for (int digit : digits) {
            digSum += digit;
        }
        if (digSum >= 10) return false;
        // кратность 3
        if (myValue % 3 != 0) return false;
        // не кратность 5
        return myValue % 5 != 0;
    }
}
