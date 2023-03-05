package ru.skillbox;

public class Dogs {
    private String name;
    private int age;
    private int weight;
    private String color;
    private boolean isMale;

    public Dogs(String name,boolean isMale) {
        this.name = name;
        this.isMale = isMale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        this.isMale = male;
    }

    public String toString(){
        return "\n Кличка          " + name +
               "\n Окрас           " + color +
               "\n Возраст,лет     " + age +
               "\n Вес, кг         " + weight +
               "\n Пол: кобель?    " + isMale;

    }

}
