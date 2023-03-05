public class Main {

    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "aa", "bb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};

        StringBuilder string = new StringBuilder();

        for (String s : strings) {
            string.append(" ").append(s);
        }
        System.out.println(string);
        string.delete(0, string.length());

        ReverseArray.reverse(strings);

        System.out.println();
        for (String s : strings) {
            string.append(" ").append(s);
        }
        System.out.println(string);
    }
}
