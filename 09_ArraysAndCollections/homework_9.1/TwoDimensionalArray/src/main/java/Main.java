public class Main {
    public static void main(String[] args) {
        //Распечатайте сгенерированный в классе TwoDimensionalArray.java двумерный массив
        int size = 7;
        char[][] table = TwoDimensionalArray.getTwoDimensionalArray(size);

        for (int row = 0; row < size; row++) {
            System.out.println(table[row]);
        }
    }
}
