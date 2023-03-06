public class BankAccount {

  protected double amount;

  public double getAmount() {
    return amount;
  }

  public void put(double amountToPut) {
    amount = (amountToPut > 0) ? (amount + amountToPut) : amount;
  }

  public void take(double amountToTake) {
    amount = (amountToTake < amount) ? (amount - amountToTake) : amount;
  }
}
