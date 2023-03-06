package main;

import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;


public class ImgScal implements Runnable {
    public File[] files;
    public String dstFolder;
    public int newWidth;
    public long start;
    private long finish;

    public ImgScal(File[] files, String dstFolder, int newWidth, long start) {
        this.files = files;
        this.dstFolder = dstFolder;
        this.newWidth = newWidth;
        this.start = start;
    }

    @Override
    public void run() {
        try {
            for (File file : files) {
                BufferedImage image = ImageIO.read(file);
                if (image == null) {
                    continue;
                }
                if (image.getWidth() <= newWidth) {
                    File newFile = new File(dstFolder + "\\" + file.getName());
                    ImageIO.write(image, "jpg", newFile);
                    continue;
                }
                int newHeight = (int) Math.round(
                        image.getHeight() / (image.getWidth() / (double) newWidth)
                );
                BufferedImage newImage = resizeImage(image, newWidth, newHeight);
                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        finish = System.currentTimeMillis() - start;
        System.out.println("Work time (**) was " + finish);

    }

    public static BufferedImage resizeImage
            (BufferedImage originalImage, int targetWidth, int targetHeight) throws Exception {
        return Scalr.resize(originalImage, Scalr.Method.AUTOMATIC
                , Scalr.Mode.AUTOMATIC, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
    }

}
