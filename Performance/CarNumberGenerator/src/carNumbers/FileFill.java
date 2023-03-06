package carNumbers;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class FileFill extends Thread {
    public String fName;
    public List<String> feeder;

    public FileFill(String fName, List<String> feeder) {
        this.fName = fName;
        this.feeder = feeder;
    }

    @SuppressWarnings("resource")
    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(fName);
            for (String str : feeder) {
                writer.write(str);
            }
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}
