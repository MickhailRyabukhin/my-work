package src;

public class Operator implements Employee {

    private static final int SALARY_HARD = 30000;

    @Override
    public int getMonthSalary() {
        return SALARY_HARD;
    }

}

