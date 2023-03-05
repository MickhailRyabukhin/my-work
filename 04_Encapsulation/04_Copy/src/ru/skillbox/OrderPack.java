package ru.skillbox;

/**
 * Задача
 * <p>
 * Что нужно сделать
 * <p>
 * Создайте иммутабельный класс для хранения информации о грузах, передаваемых в курьерскую службу.
 * Название класса придумайте самостоятельно.
 * Создайте у класса следующие поля:
 * - габариты;
 * - масса;
 * - адрес доставки;
 * - свойство — можно ли переворачивать;
 * - регистрационный номер (может содержать буквы);
 * - является ли груз хрупким.
 * Названия полей придумайте самостоятельно.
 * Типы полей задайте в соответствии с данными, которые в них содержатся.
 * Габариты — ширина, высота и длина — должны храниться в отдельном иммутабельном классе Dimensions.
 * Создайте класс Dimensions с соответствующими полями и реализуйте в нём метод вычисления объёма груза
 * (название метода придумайте самостоятельно).
 * Реализуйте в классе методы, дающие возможность изменять адрес доставки, габариты и массу груза
 * без изменения исходного объекта путём создания его копии.
 */
public class OrderPack {

    private final Dimensions dimension;
    private final double weight;
    private final String adressToSend;
    private final boolean isRotable;
    private final String regNumber;
    private final boolean isCrackable;

    public OrderPack(Dimensions dimension, double weight,
                     String adressToSend, boolean isRotable,
                     String regNumber, boolean isCrackable) {

        this.dimension = dimension;
        this.weight = weight;
        this.adressToSend = adressToSend;
        this.isRotable = isRotable;
        this.regNumber = regNumber;
        this.isCrackable = isCrackable;
    }


    public Dimensions getDimehsion() {
        return dimension;
    }

    public OrderPack withDimension(Dimensions dimension){
        return new OrderPack(dimension,weight,adressToSend,isRotable,regNumber,isCrackable);
    }

    public double getLength() {
        return dimension.getLenth();
    }

    public double getWidth() {
        return dimension.getWidth();
    }

    public double getHeight() {
        return dimension.getHeight();
    }

    public double getWeight() {
        return weight;
    }

    public OrderPack withLength(double length) {
        return new OrderPack(dimension.withLenth(length), weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public OrderPack withWidth(double width) {
        return new OrderPack(dimension.withWidth(width), weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public OrderPack withHeight(double height) {
        return new OrderPack(dimension.withHeight(height), weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public OrderPack withWeight(double weight) {
        return new OrderPack(dimension, weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public String getAdressToSend() {
        return adressToSend;
    }

    public OrderPack withAdressToSend(String adressToSend) {
        return new OrderPack(dimension, weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public boolean isRotable() {
        return isRotable;
    }

    public OrderPack withRotable(boolean rotable) {
        return new OrderPack(dimension, weight,
                adressToSend, rotable, regNumber, isCrackable
        );
    }

    public String getRegNumber() {
        return regNumber;
    }

    public OrderPack withRegNumber(String regNumber) {
        return new OrderPack(dimension, weight,
                adressToSend, isRotable, regNumber, isCrackable
        );
    }

    public boolean isCrackable() {
        return isCrackable;
    }

    public OrderPack withCrackable(boolean crackable) {
        return new OrderPack(dimension, weight,
                adressToSend, isRotable, regNumber, crackable
        );
    }

    public String toString() {
        return "\n" +
                "Вес                    " + weight + "\n" +
                "Адрес отправки         " + adressToSend + "\n" +
                "Можно переворачивать   " + isRotable + "\n" +
                "Регистрационный номер  " + regNumber + "\n" +
                "Хрупкое                " + isCrackable + "\n" +
                dimension
                ;

    }
}
