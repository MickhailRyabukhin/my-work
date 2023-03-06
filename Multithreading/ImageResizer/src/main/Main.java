package main;

import java.io.File;

public class Main {
    private static final int NEW_WIDTH = 300;
    // Для разделения на потоки определим количество ядер процессора:
    private static final int CORE_COUNT = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        String srcFolder = "C:\\Users\\MIR\\Pictures\\ImgSrc";
        String dstFolder = "C:\\Users/MIR\\Pictures\\Dest";
        String dstFolderNew = "C:\\Users/MIR\\Pictures\\DestNew";
        System.out.println("Число ядер процессора " + CORE_COUNT);

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int threadCount = files.length / CORE_COUNT;
        // используем расширение класса Thread
        Resizer[] resizers = new Resizer[CORE_COUNT];
        for (int i = 0; i < CORE_COUNT; i++) {
            File[] files1 = new File[threadCount];
            if (i < (CORE_COUNT - 1)) {
                System.arraycopy(files, i * threadCount, files1, 0, threadCount);
                resizers[i] = new Resizer(NEW_WIDTH, dstFolder, files1, start);
            } else {
                File[] files2 = new File[files.length - i * threadCount];
                System.arraycopy(files, i * threadCount, files2,
                        0, files.length - i * threadCount);
                resizers[i] = new Resizer(NEW_WIDTH, dstFolder, files2, start);
            }
            resizers[i].start();
        }
        start = System.currentTimeMillis();
        ImgScal[] imgScals = new ImgScal[CORE_COUNT];
        for (int i = 0; i < CORE_COUNT; i++) {
            File[] files1 = new File[threadCount];
            if (i < (CORE_COUNT - 1)) {
                System.arraycopy(files, i * threadCount, files1, 0, threadCount);
                imgScals[i] = new ImgScal(files, dstFolderNew, NEW_WIDTH, start);
            } else {
                File[] files2 = new File[files.length - i * threadCount];
                System.arraycopy(files, i * threadCount, files2,
                        0, files.length - i * threadCount);
                imgScals[i] = new ImgScal(files, dstFolderNew, NEW_WIDTH, start);
            }
            imgScals[i].run();
        }

    }
}

