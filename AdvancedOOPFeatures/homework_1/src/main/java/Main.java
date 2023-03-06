import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        List<Employee> staff1 = new ArrayList<Employee>(staff);
        for (Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println("\n ===============ОТСОРТИРОВАНО==================\n");
        sortBySalaryAndAlphabet(staff);
        for (Employee employee : staff) {
            System.out.println(employee);
        }

    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.

        // ИСПОЛЬЗУЕМ ЛЯМБДА ВЫРАЖЕНИЕ
        Collections.sort(staff, (e1, e2) -> {
            int result = e1.getSalary().compareTo(e2.getSalary());
            if (result == 0) {
                result = e1.getName().compareTo(e2.getName());
            }
            return result;});

    }

}