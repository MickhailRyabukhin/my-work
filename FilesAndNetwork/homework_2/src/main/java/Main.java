import java.util.Scanner;

public class Main {

    public static String sourceDirectory;
    public static String destinationDirectory;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        String inputLine;
        do {
            System.out.println("Введите путь к папке - источнику");
            sourceDirectory = SCANNER.nextLine();
            System.out.println("Введите путь к папке - копии \n");
            destinationDirectory = SCANNER.nextLine();
            System.out.println("Продолжить? Y или N");
            inputLine = SCANNER.nextLine();
        } while (!inputLine.equals("N") && !inputLine.equals("n"));
        FileUtils.copyFolder(sourceDirectory, destinationDirectory);
    }
}
