public class LegalPerson extends Client {
    private static final double TAKE_PRICE = 0.01;

    @Override
    public void take(double amountToTake) {
        amountToTake += amountToTake * TAKE_PRICE;
        super.take(amountToTake);
    }
    public String report() {
        return "Пополнение счета производится без комиссии\n" +
                "Снятие со счета производится с комиссией 1% \n" +
                "Остаток на счете: " + super.getAmount();
    }
}
