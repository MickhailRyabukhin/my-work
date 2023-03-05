public class Main {

    public static void main(String[] args) {

        String lS = System.lineSeparator(); // Так удобнее, правда?
        int first = 12;
        int second = 6;

        ArithmeticCalculator calculator = new ArithmeticCalculator(first, second);

        System.out.println(first + " + " + second + " = " + (first + second));
        System.out.println("Или c классом Enum");
        calculator.calculate (Operation.ADD);

        System.out.println(lS);
        System.out.println(first + " - " + second + " = " + (first - second));
        System.out.println("Или");
        calculator.calculate(Operation.SUBTRACT);
        System.out.println(lS);

        System.out.println(first + " * " + second + " = " + (first * second));
        System.out.println("Или");
        calculator.calculate(Operation.MULTIPLY);

    }
}
