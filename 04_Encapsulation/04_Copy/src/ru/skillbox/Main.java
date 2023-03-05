package ru.skillbox;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(0.5, 0.25, 0.3);
        OrderPack orderPack = new OrderPack(dimensions,
                1.5,
                "London,city...",
                true,
                "123N456D",
                false
        );

        System.out.println("       Характеристики груза: было");
        System.out.println(orderPack+"\n");
        System.out.println(dimensions);

        System.out.println("       Характеристики груза: стало");
        orderPack = orderPack.withWeight(5);
        orderPack=orderPack.withAdressToSend("Ne Vashe Delo");
        dimensions = dimensions.withWidth(1.5);
        dimensions = dimensions.withHeight(0.8);
        System.out.println(orderPack.withDimension(dimensions)+"\n");
        System.out.println("При копироваании можно изменить параметры в копии объекта !");
//Вроде работа принята, а новая не открывается...

    }
}
