public class ArithmeticCalculator {

    private int first;
    private int second;

    public ArithmeticCalculator(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public void calculate(Operation operation) {
        switch (operation) {
            case ADD -> {
                System.out.println(operation.getDescription()
                        + ": " + first + " + " + second + " = " + (first + second));
            }
            case SUBTRACT -> {
                System.out.println(operation.getDescription()
                + ": "+first+" - "+second + " = " + (first-second));

            }
            case MULTIPLY -> {
                System.out.println(operation.getDescription()
                +": "+first+" * "+second+ " = "+(first*second));

            }
        };return;

    }

    }
