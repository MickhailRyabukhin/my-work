import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> details;
        Movements movements = new Movements("src/test/resources/movementList.csv");
        System.out.println("Суммарные расходы "+ movements.getExpenseSum()+"\n");
        System.out.println("\n\t\t"+ "Детали операций");
        details = movements.getExpenseDetails();
        for (String string:details){
            System.out.println(string);
        }
        System.out.println("\n");
        System.out.println("Суммарный доход "+movements.getIncomeSum());
        System.out.println("\n\t\t"+ "Детали операций");
        details = movements.getIncomeDetails();
        for (String string:details) {
            System.out.println(string);
        }
    }
}
