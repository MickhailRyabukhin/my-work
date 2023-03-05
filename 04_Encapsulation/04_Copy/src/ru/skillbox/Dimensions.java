package ru.skillbox;

/**
 * Габариты — ширина, высота и длина — должны храниться в отдельном иммутабельном классе Dimensions.
 * Создайте класс Dimensions с соответствующими полями и реализуйте в нём метод вычисления объёма груза
 *  (название метода придумайте самостоятельно).
 */
public class Dimensions {
    private final double length;
    private final double width;
    private final double height;

    public Dimensions(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLenth() {
        return length;
    }

    public Dimensions withLenth(double length) {
        return new Dimensions( length,  width,  height);
    }

    public double getWidth() {
        return width;
    }

    public Dimensions withWidth(double width) {
        return new Dimensions(length,width,height);
    }

    public double getHeight() {
        return height;
    }

    public Dimensions withHeight(double height ) {
        return new Dimensions(length,width,height);
    }

    public double getVolume(){
        return length * width * height;
    }
    public String toString (){
        return "Длина "+length+", ширина "+width+",высота "+height;
    }
}
