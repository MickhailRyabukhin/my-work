import java.time.LocalDate;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;

    @Override
    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount += amountToPut;
            this.lastIncome = LocalDate.now();
        }
    }

    @Override
    public void take(double amountToTake) {
        if (amountToTake < amount && LocalDate.now().isAfter(this.lastIncome.plusMonths(1))) {
            amount -= amountToTake;
        }
    }
}
