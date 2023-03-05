import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            String goodString = getGoodString(input);
            System.out.println(getFormString(goodString));

        }

    }

    public static String getFormString(String input) {

        StringBuilder clearString = new StringBuilder();
        if (!allRight(input)) {
            return "Введенная строка не является ФИО";
        } else {
            /*
             * II. Формируем выходную строку:
             *      1. Убираем возможные двойные пробелы (.substring() + .trim())
             *      2. формируем итог (.append())
             */

            int start = 0;
            int end = input.indexOf(' ', start);
            clearString.append("Фамилия: ").append(input, start, end).append(System.lineSeparator());
            start = end+1;
            end = input.indexOf(' ', start);
            clearString.append("Имя: ").append(input, start, end).append(System.lineSeparator());
            clearString.append("Отчество: ").append(input.substring(end+1));
        }
        return clearString.toString();
    }

    //      I. Проверка на соответствие:
//           1. Не должно быть ничего кроме кириллицы, дефиса и пробелов
//           2. Должно быть три слова (ровно два пробела между ними)
    public static boolean allRight(String input) {

        for (int i = 0; i < input.length(); i++) {
            char simbol = input.charAt(i);
            if ((simbol == 'ё')              //1. Допустимые символы. Если не подходит ни одно условие
                    || (simbol == 'Ё')                      // - возвращаем false
                    || (simbol == ' ')
                    || (simbol == '-')
                    || ((simbol >= 'а') && (simbol <= 'я'))
                    || ((simbol >= 'А') && (simbol <= 'Я'))) {
                continue;
            } else{ return false;}
        }
        int pos = input.indexOf(' ');         //2. два пробела. Если ноль, один, или более двух - возвращаем false
        if (pos == -1) {                                     // - ПРОБЕЛОВ НОЛЬ- false
            return false;
        } else {                                              // - первый пробел есть
            pos = input.indexOf(' ', pos+1);
        }
        if (pos == -1) {                                       // - ПРОБЕЛ ТОЛЬКО ОДИН  - false
            return false;
        } else {                                                // - второй есть
            pos = input.indexOf(' ', pos+1);
        }

        // - ПРОБЕЛОВ БОЛЕЕ ДВУХ - false
        return pos <= 0;// Раз нет возражений -все в порядке
    }

    public static String getGoodString(String input) {

        String goodString = input.trim();
        StringBuilder clearString = new StringBuilder(goodString);
        int end = 0;
        while (end >= 0) {
            end = goodString.indexOf("  ",0);
            if (end < 0) {break;}
            goodString=clearString.deleteCharAt(end).toString();
        }
        return goodString;
    }

}