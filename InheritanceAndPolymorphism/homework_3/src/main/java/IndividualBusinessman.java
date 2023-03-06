public class IndividualBusinessman extends Client {
    private static final double MAX_PUT_PRICE = 0.01;
    private static final double MIN_PUT_PRICE = 0.005;

    @Override
    public void put(double amountToPut) {
        if (amountToPut < 1000) {
            amountToPut -= amountToPut * MAX_PUT_PRICE;
        } else {
            amountToPut -= amountToPut * MIN_PUT_PRICE;
        }
        super.put(amountToPut);
    }

    public String report() {
        return "Пополнение счета производится с комиссией \n" +
                "\t- до 1000 р - 1%\n" +
                "\t- 1000 р и выше - 0,5% \n" +
                "Снятие производится без комиссии \n" +
                "Остаток на счете: " + super.getAmount();
    }
}
