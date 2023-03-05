import java.util.*;
import java.util.regex.Pattern;

public class PhoneBook {

    public String addAnswer;
    public TreeMap<String, String> phoneBook = new TreeMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        addAnswer="";
        String oldName = getName(phone);
        String oldphone = getPhone(name);
        String newContact = name + " - " + phone;
        if (!isPhone(phone)) {
            addAnswer = "Неверный формат номера";
        } else if (!isName(name)) {
            addAnswer = "Неверный формат имени";
        } else if (!oldName.equals(name)&&!oldName.equals("")){
            phoneBook.remove(oldName);
            phoneBook.put(name, phone);
            addAnswer = newContact + "\nКонтакт изменен!";
        }else if (!oldphone.equals(phone)&&!oldphone.equals("")) {
            phoneBook.put(name, oldphone + ", " + phone);
            addAnswer = newContact+"\nКонтакт изменен!";
        } else {
            phoneBook.put(name, phone);
            addAnswer = newContact + "\nКонтакт сохранен!";
        }
    }



    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();                                    // получение ключа (имя)
            if (phone.equals(entry.getValue())) {                             // проверка по номеру
                return key + " - " + phone;
            }
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> stringTreeSet = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();                                    // получение ключа (имя)
            String value = entry.getValue();                                // получение номера
            if (name.equals(key) && stringTreeSet.isEmpty()) {              // построение вывода
                stringTreeSet.add(name + " - " + value);
            } else if (name.equals(key)) {
                stringTreeSet.add(value);
            }
        }
        return stringTreeSet;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> stringTreeSet = new TreeSet<>();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String key = entry.getKey();                                        // получение ключа (имя)
            String value = entry.getValue();                                    // получения номера
            stringTreeSet.add(key + " - " + value);
        }
        return stringTreeSet;
    }
    /**++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * Добавленные вспомогательные методы
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     *
     *   Определение имени по номеру телефона (если есть в phoneBook)
     */
    public String getName(String phone) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                return entry.getKey();
            }
        }
        return "";
    }

    /**
     *   Определение номера по имени (если есть в phoneBook)
     */
    public String getPhone(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().contains(name)) {
                return entry.getValue();
            }
        }
        return "";
    }


    /**
     * Распознавание номера телефона
     */

    public boolean isPhone(String input) {
        if (input.equals("")) {return false;}
        Pattern phoneIs = Pattern.compile("[78]?9\\d{9}");
        String phoneCleaned = phoneClean(input);
        return phoneIs.matcher(phoneCleaned).find();
    }

    /**
     * Очистка номера телефона от пробелов, скобок и т.д
     */

    public String phoneClean(String input) {
        Pattern cleanPat = Pattern.compile("\\D");
        return cleanPat.matcher(input).replaceAll("");
    }

    /**
     * Распознавание имени владельца. исключим имя Лист :)
     */

    public boolean isName(String input) {
        if (input.equals("")) {
            return false;
        }
        if (input.equalsIgnoreCase("LIST")
                || input.equals("ЛИСТ")) {
            return false;
        }
        Pattern notName = Pattern.compile("[^А-Яа-яёЁ]+");
        return !notName.matcher(input).find();
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
}
