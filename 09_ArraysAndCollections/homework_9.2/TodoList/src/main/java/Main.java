import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Что нужно сделать
 * <p>
 * Задание выполняйте в проекте "09_ArraysAndCollections/homework_9.2/TodoList".
 * <p>
 * Разработайте программу — список дел, который управляется командами в консоли.
 * Команды: LIST, ADD, EDIT, DELETE.
 * Для работы с данными списка дел в проекте находится класс TodoList,
 * который должен отвечать за хранение и работу со списком дел.
 * Реализуйте все методы и проверьте класс с помощью существующих тестов.
 * В классе Main напишите код для реализации взаимодействия с пользователем через ввод команд в консоль.
 * <p>
 * Принцип работы команд:
 * <p>
 * LIST — выводит дела с их порядковыми номерами;
 * ADD — добавляет дело в конец списка или дело на определённое место,
 * сдвигая остальные дела вперёд, если указать номер;
 * если указан несуществующий индекс - добавить в конец списка.
 * EDIT — заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
 * DELETE — удаляет; если указан несуществующий индекс - ничего не делать.
 * <p>
 * Команды вводятся пользователем в консоль одной строкой.
 */
public class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        int index = -1;
        String input = "";
        while (!input.equalsIgnoreCase("STOP")) {
            System.out.println(help());
            input = new Scanner(System.in).nextLine();
            if (input.equalsIgnoreCase("STOP")) {
                break;
            }
            System.out.println(commandLine(input, index) + "ED\n");
        }
    }

    public static String commandLine(String input, int index) {
        String regex = "(ADD)\\s*(\\d*)|(EDIT)\\s*(\\d*)|(DELETE)\\s*(\\d*)|(LIST)";
        Pattern pattern = Pattern.compile(regex);
        String command = "";
        String todo = "";
        Matcher matcher = pattern.matcher(input.toUpperCase());
        if (matcher.find()) {
            int i = 1;
            while (i <= matcher.groupCount()) {
                if (matcher.group(i) == null) {
                    i += 2;
                    continue;
                } else {
                    command = matcher.group(i).toUpperCase();
                }
                if (i == matcher.groupCount()) {
                    i += 2;
                    continue;
                }
                if (matcher.group(i + 1) == null
                        || matcher.group(i + 1).equalsIgnoreCase("")) {
                    todo = input.substring(matcher.end(i)).trim();
                    i += 2;
                    continue;
                } else {
                    index = Integer.parseInt(matcher.group(i + 1));
                    todo = input.substring(matcher.end(i + 1)).trim();
                }
                i += 2;
            }
        }
        switches(command, index, todo);
        return todo + "  " + command;
    }

    private  static void switches(String command, int index, String todo) {

        switch (command) {
            case "ADD":
                add0(index, todo);
                break;
            case "EDIT":
                todoList.edit(index, todo);
                break;
            case "DELETE":
                todoList.delete(index);
                break;
            case "LIST":
                list0();
                break;
        }
    }


    private static void add0(int index, String todo) {
        if (index < 0) {
            todoList.add(todo);
        } else {
            todoList.add(index, todo);
        }
    }

    private static String help() {
        return "Введите команду (для выхода STOP) :\n" +
                "ADD (index) строка записи | EDIT (index) строка записи | DELETE index| LIST \n" +
                "Регистр ввода не имеет значения, параметры в скобках необязательны ";
    }


    private static void list0() {
        ArrayList<String> jobList = todoList.getTodos();
        int size = jobList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(i + "\t" + jobList.get(i));
        }
    }
}
