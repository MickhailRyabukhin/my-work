public enum Operation {
    ADD(" ПЛЮС "), SUBTRACT(" МИНУС "), MULTIPLY(" УМНОЖИТЬ ");
    private final static String PART1 = "Выполняется расчет операции ";
    private final static String PART2 = ", математическое действие ";
    private String description = "";
    private String sign = "";

    Operation(String sign) {
        this.sign = sign;
        this.description = PART1 + name() + PART2 + sign;
    }

    public String getSign() {
        return sign;
    }

    public String getDescription() {
        return description;
    }
}
