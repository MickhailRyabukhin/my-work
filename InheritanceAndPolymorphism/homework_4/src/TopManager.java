package src;

public class TopManager implements Employee {

    private static final int SALARY_HARD = 50000;
    private static final double BONUS_RATE = 1.5;
    private static final int MIN_BONUS_INCOME = 10000000;
    Company company;

    public TopManager(Company company) {
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        company.hireall("Operator",200);
        return (company.getIncome() > MIN_BONUS_INCOME) ? SALARY_HARD +
                (int) (SALARY_HARD * BONUS_RATE):SALARY_HARD ;
    }
}
