package ru.skillbox;

public class Country {

    private String name;
    private int peoplesCount;
    private int square;
    private String capitalName;
    private boolean hasSeaCost;

    public Country(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPeoplesCount() {
        return peoplesCount;
    }

    public void setPeoplesCount(int peoplesCount) {
        this.peoplesCount = peoplesCount;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean hasSeaCost() {
        return hasSeaCost;
    }

    public void setSeaCost(boolean hasSeaCost) {
        this.hasSeaCost = hasSeaCost;
    }

    public String toString() {
        return "\n Чтение данных из класса Country           \n" +
               "\n"+"Название страны             " + name + "\n" +
                "Население                   " + peoplesCount + " человек\n" +
                "Площадь территории          " + square + " кв. км \n" +
                "Столица                     " + capitalName + "\n" +
                "Имеет выход к морю          " + hasSeaCost;
    }

}