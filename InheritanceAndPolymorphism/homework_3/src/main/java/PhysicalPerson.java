public class PhysicalPerson extends Client {

    public String report() {
        return "Пополнение и снятие со счета \n" +
                "производится без комиссии \n" +
                "Остаток на счете: " + super.getAmount();
    }
}
