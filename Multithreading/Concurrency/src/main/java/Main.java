import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static final String URL = "https://smotrim.ru/";

    public static void main(String[] args) {

        int threads = Runtime.getRuntime().availableProcessors(); // Определение возмоджного числа потоков
        ForkJoinPool forkJoinPool = new ForkJoinPool(); // Совпадает с чилом процессоров, проверил
        // Вызов класса RecursiveTask
        List<String> siteMap = new ArrayList<>(forkJoinPool.invoke(new SiteParser(URL)));

        // Закомментированный вызов для однопоточного варимнта  решения
//        List<String> siteMap = new SiteParser1(URL).compute(URL);
        // Вывод найденных страниц
        for (String address : siteMap) {
            System.out.println(address);
        }

        // Вывод числа найденных ссылок
        System.out.println(siteMap.size());
    }
}
