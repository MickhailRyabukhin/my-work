import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String imgName;
        String imageUrl;
        // По заданию читаем из https://lenta.ru/
        String urlFirst = "https://lenta.ru/";
        // Задаем имя файла для записи источников (URL) файлов
        File output = new File("images/imagePaths.txt");
        try {
            OutputStream fos = new FileOutputStream(output);
            // получаем документ html, подключаемся
            Document doc = Jsoup.connect(urlFirst).get();
            // Отбираем только изображения (select .....png|jpe?g)
            Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g)]");
            for (Element image : images) {
                // находим URL файла
                imageUrl = image.absUrl("src");
                // Задаем имя файла для записи (вырезаем из URL)
                imgName = "images/" + imageUrl.substring(imageUrl.lastIndexOf('_') + 1);
                // Копирование изображений
                saveImage(imageUrl, imgName);
                // Вывод имени файла в консоль
                System.out.println(imgName + "\n");
                // Запись в файл найденных URL изображений
                imageUrl = imageUrl + '\n';
                byte[] inp_b = imageUrl.getBytes();
                fos.write(inp_b);
            }
            // убираем за собой
            fos.flush();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);

        byte[] b = new byte[2048];
        int length;

        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }

        is.close();
        os.close();
    }
}
