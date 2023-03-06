import org.jetbrains.annotations.NotNull;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.net.SocketException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    public static StringBuilder tabs=new StringBuilder();
    private static final String baseURL = Main.URL;
    public static Pattern pat = Pattern.compile("/");
    public static Set<String> noDoubles = Collections.synchronizedSet(new LinkedHashSet<>());
    public static TreeSet<String> result=new TreeSet<>();
    public  static int thousands = 0;

    public static String getTabs(@NotNull String url) {
        tabs.setLength(0);
        int level = 0;
        if (!url.endsWith("/")) {
            tabs.append("\t");
        }
        Matcher matcher = pat.matcher(url);
        while (matcher.find()) {
            level++;
            if (level > 3) {
                tabs.append("\t");
            }
        }

        return tabs.toString() + url;
    }

    public static void resultView(TreeSet<String> result) {
        List<String> tempView = new ArrayList<>(result);
        if (tempView.size() > 0) {
            int i = 0;

            System.out.println(getTabs(tempView.get(i)) + "\t\t\t\t   " + tempView.size());
                i++;
                while ((i < 3) && (i < tempView.size())) {

                System.out.println("\t" + tabs + tempView.get(i));
                i++;
            }
            //           System.out.println("---------------------------------------");
        }
    }
    public static TreeSet<String> getSiteMap(String url) {
        result.clear();
        boolean added = false;
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
                synchronized (noDoubles){
                    added=noDoubles.add(newUrl);
                }
                if (added) {
                    result.add(newUrl);
//                    System.out.println(tabs+newUrl);
                    thousands++;
                    if (thousands == 1000) {
                        System.out.println("\t всего\t " + (noDoubles.size() ) + "\t ссылок");
                        thousands = 0;
                    }

                }
            }
           // result.remove(url); //Ведущую ссылку удаляем, чтобы не возвращаться к ней повторно
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
//            Utils.resultView(result);         // Подключение вывода
        return result;                      // возвращаем список ссылок с данного URL, отфильтрованный
    }
    public static List<SiteParser> taskList (Set<String> urls){
        List<SiteParser> taskList = new ArrayList<>();
        for(String url:urls){
            taskList.add(new SiteParser(url));
        }
        return taskList;
    }

}

