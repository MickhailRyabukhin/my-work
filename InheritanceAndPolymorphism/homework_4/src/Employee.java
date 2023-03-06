package src;

public interface Employee extends Comparable<Employee> {
    int getMonthSalary();

    default int compareTo(Employee e) {

        return Integer.compare(getMonthSalary(), e.getMonthSalary());
    }
}
