package ru.skillbox;

public class Main {

    public static void main(String[] args) {
//================================= З А Д А Н И Е № 1 ===============================================
        System.out.println("1.  Создание класса Country и заполнение его данными");
        Country pakistan = new Country("Пакистан");
        pakistan.setPeoplesCount(218066558);
        pakistan.setCapitalName("Исламабад");
        pakistan.setSeaCost(true);
        pakistan.setSquare(880254);
        System.out.println(pakistan.toString());
        System.out.println();
//================================= З А Д А Н И Е № 2 ===============================================
        System.out.println("2. Cоздание класса с информацией о реальном объекте (собаке)");
        Dogs myDog = new Dogs("Рида",false);
        myDog.setAge(1);
        myDog.setColor("Чепрачный окрас");
        myDog.setWeight(35);
        System.out.println("\n"+"Чтение данных из класса myDog");
        System.out.println(myDog.toString());





    }



}
