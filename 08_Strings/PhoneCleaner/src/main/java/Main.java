import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    //    String phoneNumber = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.

            System.out.println(phoneNumberTest(input));
        }
    }

    public static String phoneNumberTest(String input) {

        String phoneCleaned = input.replaceAll("\\D", "");
        if (phoneCleaned.length() == 10) {
            phoneCleaned = "7" + phoneCleaned;
        }
        if (phoneCleaned.charAt(0) == '8') {
            phoneCleaned = "7" + phoneCleaned.substring(1);
        }
        if (phoneCleaned.charAt(0) != '7') {
            return "Неверный формат номера";
        }
        if (phoneCleaned.length() != 11) {
            return "Неверный формат номера";
        }

        return " " + phoneCleaned;
    }
}
