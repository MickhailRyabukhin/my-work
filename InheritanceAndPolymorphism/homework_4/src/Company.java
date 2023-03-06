package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    public static final String OPERATOR = "Operator";
    public static final String MANAGER = "Manager";
    public static final String TOP_MANAGER = "TopManager";
    public Company company;
//============================================================
    private List<Employee> staff = new ArrayList<>();


    List<Employee> getTopSalaryStaff(int count) {
        List<Employee> staffCopy = new ArrayList<>(staff);
        Collections.sort(staffCopy);
        Collections.reverse(staffCopy);
        return staffCopy.subList(0, count);
    }

    List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> staffCopy = new ArrayList<>(staff);
        Collections.sort(staffCopy);
        return staffCopy.subList(0, count);
    }

    public int getIncome() {
        int income = 0;
        for (Employee employee : staff) {
            if (employee instanceof Manager) {
                income += ((Manager) employee).getIncome();
            }
        }
      return income;
    }

    public void hire(String role,Company company) {

        switch (role) {
            case OPERATOR -> staff.add(new Operator());
            case MANAGER -> staff.add(new Manager());
            case TOP_MANAGER -> staff.add(new TopManager(company));
        }
    }
//=========================================================================
    public void hireall(String role, int numbers,Company company) {
        for (int i = 0; i < numbers; i++) {
            hire(role,company);
        }
    }

    public void fire(Employee employee) {
        staff.remove(employee);
    }

    public List<Employee> getStaff() {
        return new ArrayList<>(staff);
    }
}
