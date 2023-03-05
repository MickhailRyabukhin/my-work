import java.util.*;

public class EmailList {
    TreeSet<String> input = new TreeSet<>();
    ArrayList<String> output = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        if (email.contains("@") && email.contains(".")
                && email.indexOf("@") < email.indexOf(".")
                && email.indexOf(".") < email.length() - 1) {
            input.add(email.toLowerCase());
        } else {System.out.println(Main.WRONG_EMAIL_ANSWER);}
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        output.addAll(input);
        return output;
    }

}
