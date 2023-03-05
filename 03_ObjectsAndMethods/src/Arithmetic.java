import java.util.Scanner;


public class Arithmetic {
    private int first;
    private int second;


    public int  getFirst (){
        System.out.println("Введите первый операнд");
        return new Scanner(System.in).nextInt();
    }
    public int getSecond(){
        System.out.println("Введите второй операнд");
        return new Scanner(System.in).nextInt();
    }

    public int  GetSum(){
        return  first + second;
    }

    public int GetMult() {
        return first * second;
    }

    public int GetMax(){
        int max;
        if (first > second){
            max = first;
        }else max = second;
        return max;
    }

    public int GetMin(){
        int min;
        if (first<second){
            min = first;
        }else min = second;
        return min;
    }

}
