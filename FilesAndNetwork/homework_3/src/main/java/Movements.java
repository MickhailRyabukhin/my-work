import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Movements {

    private final String PATH_MOVEMENTS_CSV;
    public static ArrayList<Count> counts;


    public Movements(String pathMovementsCsv) {
        this.PATH_MOVEMENTS_CSV = pathMovementsCsv;
        movements();
    }

    public void movements() {

        counts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(PATH_MOVEMENTS_CSV))) {

            String line;
            while ((line = reader.readLine()) != null) {
                Count count = new Count();
                count.countFill(line);
                counts.add(count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public double getExpenseSum() {
        double result = 0;
        for (Count count : counts) {
            result += count.countDecrement;
        }
        return result;
    }

    public ArrayList<String> getExpenseDetails() {
        Pattern pat = Pattern.compile("^(\\S+)\\s+(\\S+)");
        Matcher matcher;
        ArrayList<String> result = new ArrayList<>();
        for (Count count : counts) {
            if (count.countDecrement > 0.0) {
                matcher = pat.matcher(count.operationDetails);
                if (matcher.find()) {
                    result.add(matcher.group(2) + "\t" + count.date.toString() + "\t" + count.countDecrement);
                } else {
                    result.add(count.operationDetails);
                }
            }
        }
        return result;
    }

    public ArrayList<String> getIncomeDetails() {
        Pattern pat = Pattern.compile("^(\\S+)\\s+(\\S+\\s+\\S+)");
        Matcher matcher;
        ArrayList<String> result = new ArrayList<>();
        for (Count count : counts) {
            if (count.countIncrement > 0.0) {
                matcher = pat.matcher(count.operationDetails);
                if (matcher.find()) {
                    result.add(matcher.group(2) + "\t" + count.date.toString() + "\t" + count.countIncrement);
                } else {
                    result.add(count.operationDetails);
                }
            }
        }
        return result;
    }

    public double getIncomeSum() {
        double result = 0;
        for (Count count : counts) {
            result += count.countIncrement;
        }
        return result;
    }
}
