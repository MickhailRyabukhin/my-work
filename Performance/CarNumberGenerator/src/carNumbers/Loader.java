package carNumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Loader extends RecursiveTask<List<String>> {

    private int begin;
    private int end;
    private final int limit = 2;

    private long start = System.currentTimeMillis();

    public Loader(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    public static char[] letters = {'У', 'К', 'Е', 'Н', 'Х', 'В', 'А', 'Р', 'О', 'С', 'М', 'Т'};

    @Override
    public List<String> compute() {
        List<String> result = new ArrayList<>();
        List<Loader> taskList = new ArrayList<>();
        if (begin - end > limit) {
            taskList = createSubtask(limit);
        } else result = generator(begin, end);

        for (Loader task : taskList) {
            task.fork();
            result.addAll(task.join());
        }
        return result;
    }

    public List<String> generator(int begin, int end) {
        long from = System.currentTimeMillis();
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        //int regionCode = 199;
        for (char firstLetter : letters) {
            for (int number = begin; number < end; number++) {
                for (char secondLetter : letters) {
                    for (char thirdLetter : letters) {
                        for (int regionCode = 1; regionCode < 200; regionCode++) {
                            builder.append(firstLetter).append(padNumber(number, 3))
                                    .append(secondLetter).append(thirdLetter)
                                    .append(padNumber(regionCode, 3)).append("\n");
                            result.add(builder.toString());
                            builder.delete(0, builder.length());
                        }
                    }
                }
            }
        }
        return result;
    }

    private List<Loader> createSubtask(int limit) {
        List<Loader> result = new ArrayList<>();
        if (begin - end > limit) {
            for (int i = begin; i < end; i += limit) {
                result.add(new Loader(i, i + limit - 1));
            }
        }
        return result;
    }

    private static String padNumber(int number, int numberLength) {
        StringBuilder builder = new StringBuilder(Integer.toString(number));
        int padSize = numberLength - builder.length();
        for (int i = 0; i < padSize; i++) {
            builder.insert(0, '0');
        }
        return builder.toString();
        // Вывод: оптимизация метода padNumber на суммарную производительность ПРАКТИЧЕСКИ НЕ ВЛИЯЕТ
        // слишком маленький объем метода, тратить время нецелесообразно
    }


}
