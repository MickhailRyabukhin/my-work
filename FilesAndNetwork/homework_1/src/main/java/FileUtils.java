import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileUtils {
    public static long folderSize = 0L;

    public static long calculateFolderSize(String path) throws IOException {
        try {
            folderSize = 0;
            File fileForExam = new File(path);

            if (fileForExam.exists()) {                         // Определяем, существует ли файл
                if (fileForExam.isDirectory()) {                // Если это каталог,
                    File[] fileList = fileForExam.listFiles();  // содержащий fileList,
                    if (fileList != null) {
                        for (File f : fileList) {                   //рекурсивно вычисляем
                            folderSize += calculateFolderSize(f.getPath()); //общий размер его содержимого
                        }                                           // возвращаем размер каталога
                    }
                    return folderSize;
                } else {                                        //если это файл, просто
                    folderSize = fileForExam.length();            //возвращаем его размер
                    return folderSize;
                }
            } else {                            //Если файл не существует, выводим сообщение
                System.out.println("Файл или папка не существует, проверьте правильность пути!");
                return 0;
            }
        } catch (Exception exception) {  // Обработка исключений - выводим исключение и трассировку
            System.out.println(exception + Arrays.toString(exception.getStackTrace()));
            return 0;
        }
    }
}



