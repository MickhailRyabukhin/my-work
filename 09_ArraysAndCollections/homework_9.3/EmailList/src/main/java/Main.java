import java.util.Scanner;

public class Main {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    
    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmailList emailList = new EmailList();
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            String inputUp = input.toUpperCase().trim();
            input = input.trim();
            int i = inputUp.indexOf(" ");
            if (inputUp.substring(0, i).equals("ADD")) {
                emailList.add(input.substring(i).trim());
            }
            if (inputUp.substring(0, i).equals("LIST")) {
                emailList.getSortedEmails();
                for (String email : emailList.output) {
                    System.out.println(email);
                }
            }
        }
    }
}
