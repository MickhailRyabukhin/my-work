public class Main {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль
        System.out.println(getSum(text));


    }

    public static int getSum(String text) {
        int start;
        int end;
        int sum = 0;
        String digits;
        for (int i = 0; i < text.length(); i++) {

            if ('0' <= text.charAt(i) && text.charAt(i) <= '9') {
                start = i;
                end = i;
                while ('0' <= text.charAt(end) && text.charAt(end) <= '9') {
                    end++;
                }
                i=end;
                digits = text.substring(start, end);
                sum = sum + Integer.parseInt(digits);
            }
        }
        return sum;
    }
}