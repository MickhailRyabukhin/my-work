package ru.skillbox;

public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer("AnyComp","MadeNoName");
        CPU cpu = new CPU(3600,5,"AnyBody",0.350);
        Memory memory = new Memory(Memory.Type.DDR4,4096,0.025);
        Storage storage = new Storage(Storage.Type.SSD,1024,0.350);
        Display display = new Display(21,Display.Type.TN,1.540);
        KeyBoard keyBoard =new KeyBoard("AXZ",true,0.350);
        computer.setCpu(cpu);
        computer.setMemory(memory);
        computer.setStorage(storage);
        computer.setDisplay(display);
        computer.setKeyBoard(keyBoard);
        System.out.println(computer);
        System.out.println("\n \n Общий вес компьютера " + computer.getTotalWeight() + "кг");

    }


}