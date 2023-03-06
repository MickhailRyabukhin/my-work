import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileUtils {

    public static Path destPath;
    public static Path sourcePath;
    public static String destDir = "";

    public static void copyFolder(String sourceDirectory, String destinationDirectory) {

        sourcePath = Paths.get(sourceDirectory);
        destPath = Paths.get(destinationDirectory);

        // TODO: write code copy content of sourceDirectory to destinationDirectory

        File sourceFile = new File(sourcePath.toString());// Создаем файл для проверок

        if (sourceFile.exists()) {                         // Определяем, существует ли файл
            if (sourceFile.isDirectory()) {                // Если это каталог,
                try {                                      // создаем новую папку (директорию),
                    Files.deleteIfExists(destPath);        // уничтожая старую (если есть),
                    Files.createDirectory(destPath);       // в папке назначения
                    destDir = destPath.toString();         // и наращиваем путь
                } catch (IOException e) {
                    System.out.println("It's impossible to create dir " + destPath.toString());
                    e.printStackTrace();
                }
                File[] fileList = sourceFile.listFiles();   // Если каталог не пустой,
                if (fileList != null) {                     // а содержащий fileList (список файлов),
                    for (File file : fileList) {            //  выбираем очередной файл
                        sourcePath = file.toPath();         // и рекурсивно вызываем copyFolder
                        destPath = Paths.get(destDir + "\\" + file.getName());
                        copyFolder(sourcePath.toString(), destPath.toString());
                    }
                }
            } else {
                byte[] fileArray;
                try {
                    fileArray = Files.readAllBytes(sourcePath);  // если это файл, читаем его по байтам
                    Files.deleteIfExists(destPath);
                    Files.createFile(destPath);
                    Files.write(destPath, fileArray);            //  и пишем в новый файл
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



