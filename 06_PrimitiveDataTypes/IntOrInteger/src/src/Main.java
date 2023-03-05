public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.
        int a = 'Ё';
        int b = 'ё';
        System.out.println(" Kоды для Ё " + a + " и ё " + b);
        for (int i = 'А'; i <= 'я'; i++) {
            System.out.println(i + "\t" + (char) i);
            if (i == 'Е') {
                System.out.println(a + "\t" + (char) a);
            } else if (i == 'е') {
                System.out.println(b + "\t" + (char) b);
            }
        }
    }
}
