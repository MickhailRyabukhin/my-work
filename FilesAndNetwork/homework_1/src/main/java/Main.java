import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static String pathName = "";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        while (!pathName.equals("0")) {
            System.out.println("Введите путь к папке, например C:/games\n");
            pathName = scanner.nextLine();
            FileUtils.folderSize = 0;
            long size = FileUtils.calculateFolderSize(pathName);
            System.out.println("Размер папки \"" + pathName + "\" = " + size / 1024 / 1024 + "  Mb \n");
        }
    }
}
