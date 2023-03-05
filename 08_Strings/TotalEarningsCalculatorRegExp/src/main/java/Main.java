import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  private static final Pattern PATTERN = Pattern.compile("(\\d+)");

  public static void main(String[] args) {
    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    int sum = calculateSalarySum(text);
    System.out.println(sum);
  }

  public static int calculateSalarySum(String text) {
    //TODO: реализуйте метод

    int sum = 0;
    Matcher matcher = PATTERN.matcher(text);
    while (matcher.find()) {
      sum += Integer.parseInt((matcher.group()));
    }
    return sum;
  }

}