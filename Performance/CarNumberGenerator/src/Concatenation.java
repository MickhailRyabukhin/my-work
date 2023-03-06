public class Concatenation {

    public static void main(String[] args) {
        System.out.println();
        long start = System.currentTimeMillis();
         //Сборка строки StringBuilder. Время 4 ms
        StringBuilder builder =new StringBuilder();
        for (int i = 0; i < 20_000; i++) {
            builder.append("some text some text some text") ;
        }
        System.out.print("Сборка строки StringBuilder, время  ");
        System.out.println((System.currentTimeMillis() - start) + " ms");
        System.out.println();
        // сборка конкатенацией строк
        start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 20_000; i++) {
            str+="some text some text some text" ;
        }
        System.out.print("Сборка конкатенацией строк, время ");

        System.out.println((System.currentTimeMillis() - start) + " ms");
    }
}
