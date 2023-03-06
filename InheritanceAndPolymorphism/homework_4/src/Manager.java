package src;

public class Manager implements Employee {

    private static final int MIN_INCOME = 115000;
    private static final int MAX_INCOME = 140000;
    private static final int SALARY_HARD = 40000;
    private static final double BONUS_RATE = 0.05;
    public int income = MIN_INCOME + (int) (Math.random() * (MAX_INCOME - MIN_INCOME));

    @Override
    public int getMonthSalary() {
        return (int) (SALARY_HARD + Math.round(income * BONUS_RATE));
    }
    public int getIncome() {
        return income;
    }


}
