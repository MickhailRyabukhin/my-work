package ru.skillbox;

/**
 * Задание 2
 * Что нужно сделать
 * Модифицируйте класс Product, разобранный в видеоуроке, следующим образом:
 * добавьте в класс неизменяемое поле barCode (штрихкод);
 * поле price сделайте изменяемым и уберите его из конструктора, класс при этом перестанет быть иммутабельным.
 */
public class Product {

    private final String name;
    private int price;
    private final int barCode;

    public Product(String name, int barCode) {
        this.name = name;
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getBarCode() {
        return barCode;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return  "Product Name    " + name +"\n"+
                "Product Price   " + price +"\n"+
                "Product BarCodo " + barCode;

    }
}
