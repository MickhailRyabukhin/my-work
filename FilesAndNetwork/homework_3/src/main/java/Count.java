import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {

    public String countType;
    public String countNumber;
    public String currency;
    public LocalDate date;                       //31.05.17
    public String operationReference;            //CRD_1U34U7
    public String operationDetails;             //548673++++++1028    809216  /RU/CARD2CARD ALFA_MOBILE>MOSCOW          31.05.17 31.05.17 1500.00       RUR MCC6536
    public double countIncrement;                   //1500
    public double countDecrement;                   //0
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");

    public void countFill(String summary) {
        String regex = "([^,]+),(\\d+),(\\w+),(\\d+.\\d+.\\d+),([^,]+),([^,]+),(\\d+.?\\d*|\"\\d+,\\d+\"),(\\d+.?\\d*|\"\\d+,\\d+\")";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(summary);
        if (matcher.find()) {
            countType = matcher.group(1);
            countNumber = matcher.group(2);
            currency = matcher.group(3);
            date = LocalDate.parse(matcher.group(4), formatter);
            operationReference = matcher.group(5);
            operationDetails = matcher.group(6);
            countIncrement = digCorrect(matcher.group(7));
            countDecrement = digCorrect(matcher.group(8));
        }
    }

    public double digCorrect(String input) {
        String result;
        if (input.contains(",")) {
            result = input.replace(",", ".");
            input = result;
        }
        result = input.replaceAll("[^0-9^.]*", "");
        if (result.equals("")) {
            return 0.0;
        }
        try {
            return Double.parseDouble(result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0.0;
        }
    }
}
