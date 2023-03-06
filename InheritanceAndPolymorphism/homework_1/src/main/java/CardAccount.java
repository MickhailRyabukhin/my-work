public class CardAccount extends BankAccount {

    @Override
    public void take(double amountToTake) {
        amount = (amountToTake * 1.01 < amount) ? (amount - amountToTake * 1.01) : amount;
    }
}
