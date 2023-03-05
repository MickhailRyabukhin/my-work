package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Book book = new Book("Аэродинамика и динамика полета",
                "Ништ М.И.", 520, "123-456-78");
        System.out.println(book.toString());
        System.out.println();
        Product product = new Product(" Апельсин", 2345);
        product.setPrice(125);
        System.out.println(product.toString());
        System.out.println();
        System.out.println("Поменяем цену\n\n");
        product.setPrice(12345);
        System.out.println(product.toString());
    }


}
