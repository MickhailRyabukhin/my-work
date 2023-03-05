import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {


    public static void main(String[] args) {

        final String ls = System.lineSeparator();

        String input;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            System.out.println(goodName(input));
        }

    }

    //TODO:напишите ваш код тут, результат вывести в консоль.
    //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО

    public static String goodName(String input) {
        final String ls = System.lineSeparator();
        final String regex = "([а-яА-ЯёЁ-]+)\\s+([а-яА-ЯёЁ-]+)\\s+([а-яА-ЯёЁ-]+)|.+";
        String control = "";
        String family = "Фамилия: ";
        String name = "Имя: ";
        String fatherName = "Отчество: ";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);
        int end, end1 = 0;
        if (matcher.find()) {
            family += matcher.group(1);
            name += matcher.group(2);
            fatherName += matcher.group(3);
            end = matcher.end(3);
            end1 = matcher.regionEnd();
            if (end < end1) {
                return "Введенная строка не является ФИО ";
            }

        } else {
            return "Введенная строка не является ФИО ";
        }
        return family + ls + name + ls + fatherName;
    }

}







