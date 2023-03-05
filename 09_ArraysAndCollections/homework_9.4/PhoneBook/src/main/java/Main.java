import java.util.Scanner;
import java.util.Set;

public class Main {

    public static PhoneBook phoneBook = new PhoneBook();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//        Workers workers = new Workers();
        while (true) {
            System.out.println("Введите номер, имя или команду (для выхода - \"0\")");
            String input = scanner.nextLine();
            if (input.equals("0")) {
                System.out.println("Завершение программы");
                break;
            } else if (input.equalsIgnoreCase("LIST")
                    || input.equals("ЛИСТ")) {
                Set<String> allContacts = phoneBook.getAllContacts();
                System.out.println(allContacts);
            }else if(phoneBook.isName(input)) {
                String phone = phoneBook.getPhone(input);
                if (!phone.equals("")) {
                    System.out.println(input + " - " + phone);
                } else {
                    phone = addPhoneInput();
                    phoneBook.addContact(phone, input);
                    System.out.println(phoneBook.addAnswer);
                }
            }else if(phoneBook.isPhone(input)){
                String name = phoneBook.getName(input);
                if (!name.equals("")) {
                    System.out.println(name + " - " + input);
                } else {
                    name = addNameInput();
                    phoneBook.addContact(input, name);
                    System.out.println(phoneBook.addAnswer);
                }
            } else {
                System.out.println("Неверный формат ввода. Имя - русские буквы, " +
                        "телефон - \"89\" или \"79\" и еще 9 цифр, команда -\"ЛИСТ\" или \"LIST\"");
            }
        }
    }
    public static String addPhoneInput(){
        while (true){
            System.out.println("введите номер телефона");
            String phone = scanner.nextLine();
            if (phoneBook.isPhone(phone)){
                return phone;
            }
        }
    }
    public static String addNameInput(){
        while (true){
            System.out.println("введите имя");
            String name = scanner.nextLine();
            if (phoneBook.isName(name)){
                return name;
            }
        }
    }


}
