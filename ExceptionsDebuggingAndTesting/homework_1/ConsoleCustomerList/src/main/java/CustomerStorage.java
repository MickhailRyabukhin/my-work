import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws IndexOutOfBoundsException,
            IllegalArgumentException {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;


        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IndexOutOfBoundsException();
        }else if (!components[INDEX_EMAIL].matches("\\w+@\\w+[.]\\w+")){
            throw new IllegalArgumentException("Неправильный формат e-mail.\n " +
                    "Правильный формат ??????@????.???");

        } else if (!components[INDEX_PHONE].matches("^[+]?[78]?9\\d{9}$")) {
            throw new IllegalArgumentException("Неправильный формат телефона.\n " +
                    "Правильный формат +79_________(9 цифр) или 89_________(9 цифр)");

        }

        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE],
                components[INDEX_EMAIL]));


    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}