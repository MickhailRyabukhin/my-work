import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.net.SocketException;
import java.util.*;
import java.util.concurrent.RecursiveTask;

public class SiteParser extends RecursiveTask<Set<String>> {
    public String url;
    private final String baseURL = Main.URL;
    TreeSet<String> result = new TreeSet<>();
    private volatile static int thousands = 0;

    public SiteParser(String url) {
        this.url = url;

    }


    @Override
    protected Set<String> compute() {                  // метод с автозапуском при создании класса SiteParser
        List<String> urlList = new ArrayList<>(Utils.getSiteMap(url));
        List<SiteParser> taskList = new ArrayList<>();
//        tabs+="\t";
        for (String child : urlList) {
            SiteParser task = new SiteParser(child);
            taskList.add(task);
            task.fork();
        }
        for (SiteParser task : taskList) {
            Utils.noDoubles.addAll(task.join());
        }
        return Utils.noDoubles;
    }

    public TreeSet<String> getSiteMap(String url) {
        result.clear();
        String newUrl;
        try {
            Thread.sleep(100);
            Document doc = Jsoup.connect(url)   //Подключаемся к сайту, получаем документ jsoup
                    .maxBodySize(0)
                    .userAgent("Mozilla/5.0")
                    .referrer("http://www.google.com")
                    .ignoreContentType(true)
                    .ignoreHttpErrors(true)
                    .get();
            Elements links = doc.select("a");//Отфильтровываем классы со ссылками
            for (Element link : links) {
                //String
                newUrl = link.attr("abs:href"); // из классов выделяем только ссылки
//                if (!newUrl.endsWith("/")) {
//                    //проверяем ссылки на правильность, неверные пропускаем
//                    continue;
//                }
                if (!newUrl.startsWith(baseURL)) {
                    //Пресекаем выход за границы сайта
                    continue;
                }

                if (Utils.noDoubles.add(newUrl)) {
                    result.add(newUrl);
//                    System.out.println(tabs+newUrl);
                    thousands++;
                    if (thousands == 1000) {
                        System.out.println("\t всего\t " + (Utils.noDoubles.size() - 1) + "\t ссылок");
                        thousands = 0;
                    }

                }
            }
            result.remove(url); //Ведущую ссылку удаляем, чтобы не возвращаться к ней повторно
        } catch (SSLHandshakeException she) {
            System.out.println(she.getLocalizedMessage());
        } catch (SocketException se) {        // Исключение ошибки соединения
            System.out.println(se.getLocalizedMessage());
        } catch (HttpStatusException hse) { //Исключение битых ссылок (с ошибкой типа 404)
            result.remove(url);
        } catch (IOException e) {           // Исключение ошибок ввода-вывода
            System.out.println(e.getLocalizedMessage());
        } catch (InterruptedException e) {
            System.out.println("Ошибка прерывания");
        }
    //    Utils.resultView(result);         // Подключение вывода
        return result;                      // возвращаем список ссылок с данного URL, отфильтрованный
    }

}
