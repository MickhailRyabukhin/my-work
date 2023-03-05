import java.util.*;

public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */


    public static void main(String[] args) {

        // Нам понадобятся переменные:
        String number = "О444ЕС30";
        long start;
        long stop;
        boolean isReady;
        long duration;
        String find;

        List<String> coolNums = CoolNumbers.generateCoolNumbers();
        System.out.println("Поиск номера " + number + " в списке из " + CoolNumbers.coolNumbersId + " номеров:");
        start = System.nanoTime();
        isReady = (CoolNumbers.bruteForceSearchInList(coolNums, number));
        stop = System.nanoTime();
        duration = stop - start;
        find = (isReady) ? "найден" : "не найден";
        System.out.println("Поиск перебором: номер " + find + " поиск занял " + duration + " нс");

        List sortedNums = new ArrayList<>(coolNums);
        Collections.sort(sortedNums);
        start = System.nanoTime();
        isReady = (CoolNumbers.binarySearchInList(sortedNums, number));
        stop = System.nanoTime();
        duration = stop - start;
        find = (isReady) ? "найден" : "не найден";
        System.out.println("Бинарный поиск: номер " + find + " поиск занял " + duration + " нс");

        HashSet hashNums = new HashSet(coolNums);
        start = System.nanoTime();
        isReady = (CoolNumbers.searchInHashSet(hashNums, number));
        stop = System.nanoTime();
        duration = stop - start;
        find = (isReady) ? "найден" : "не найден";
        System.out.println("Поиск в HashSet: номер " + find + " поиск занял " + duration + " нс");

        TreeSet treeNums = new TreeSet(coolNums);
        start = System.nanoTime();
        isReady = (CoolNumbers.searchInTreeSet(treeNums, number));
        stop = System.nanoTime();
        duration = stop - start;
        find = (isReady) ? "найден" : "не найден";
        System.out.println("Поиск в TreeSet: номер " + find + " поиск занял " + duration + " нс");
    }
}
