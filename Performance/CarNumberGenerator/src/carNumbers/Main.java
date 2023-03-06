package carNumbers;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int threads = Runtime.getRuntime().availableProcessors(); // Определение возмоджного числа потоков
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool(threads); // Совпадает с чиcлом процессоров, проверил
        int resultsize = 0;
        for (int i = 0; i < 1000; i += 50) {
            long start0 = System.currentTimeMillis();
            List<String> result = forkJoinPool.invoke(new Loader(i, i + 49));
            System.out.println("С " + i + " по " + (i + 49));
            System.out.println("Этап  выполнен за " + (System.currentTimeMillis() - start0) + " ms");
            start0 = System.currentTimeMillis();
            int div = result.size() / 10;
            for (int j = 0; j < 10; j++) {
                List<String> res;
                if (j == 9) {
                    res = result.subList(j * div, result.size() - 1);
                } else {
                    res = result.subList(j * div, (j + 1) * div);
                }
                String name = "res/numbers" + j + ".txt";
                FileFill fileFill = new FileFill(name, res);
                fileFill.start();
                fileFill.join();
            }
            System.out.println("Запись в 10 файлов проведена за " + (System.currentTimeMillis() - start0) + " ms");
            System.out.println("Всего затрачено  " + (System.currentTimeMillis() - start) + " ms");
            System.out.println("Собрано " + result.size() + " номера, всего " + (resultsize += result.size()));
            System.out.println();
        }
    }

}