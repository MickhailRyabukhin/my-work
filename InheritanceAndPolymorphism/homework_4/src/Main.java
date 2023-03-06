package src;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String MANAGER = "Manager";
    private static final String OPERATOR = "Operator";
    private static final String TOP_MANAGER = "TopManager";


    public static void main(String[] args) {

        int operatorsToHire = 180; // комплект необходимых значений.
        int managersToHire = 80;
        int topManagersToHire = 10;
        int countMaxSalary = 15;
        int countMinSalary = 50;

        Company anyCompany = new Company();
        System.out.println("набор сотрудников");
        System.out.println();
        anyCompany.hireall(OPERATOR, operatorsToHire,anyCompany);
        anyCompany.hireall(MANAGER, managersToHire,anyCompany);
        anyCompany.hireall(TOP_MANAGER, topManagersToHire,anyCompany);
        System.out.println("Принято на рaботу  "+anyCompany.getStaff().size());

        anyCompany.getIncome(); // Для получения дохода компании и передачи топменеджерам

        List<Employee> topList = anyCompany.getTopSalaryStaff(countMaxSalary);
        List<Employee> bottomList = anyCompany.getLowestSalaryStaff(countMinSalary);
        System.out.println("Самые высокие зарплаты (по убыванию):");
        printOut(topList, countMaxSalary);
        System.out.println("Самые низкие зарплаты  (по возрастанию): ");
        printOut(bottomList, countMinSalary);
        System.out.println();

        System.out.println("увольнение "+ operatorsToHire+" сотрудников ");
        int fired = (operatorsToHire + managersToHire + topManagersToHire) / 2;
        List<Employee> staffCopy = anyCompany.getStaff();
        for (int i = 0; i < fired; i++) {
            anyCompany.fire(staffCopy.get(i));
        }

        anyCompany.getIncome();                     // компания уменьшилась - доход может измениться.

        System.out.println("Теперь осталось "+anyCompany.getStaff().size()+" !!!!!!!!!!!");
        topList = anyCompany.getTopSalaryStaff(countMaxSalary);
        System.out.println("Самые высокие зарплаты (по убыванию):");
        printOut(topList, countMaxSalary);

        bottomList = anyCompany.getLowestSalaryStaff(countMinSalary);
        System.out.println("Самые низкие зарплаты  (по возрастанию): ");
        printOut(bottomList, countMinSalary);

    }

    private static void printOut(List<Employee> list, int count) {
        ArrayList<Employee> temp = new ArrayList<>(list);
        for (int i = 0; i < count; i++) {
            System.out.println(temp.get(i).getMonthSalary());
        }


    }


}
