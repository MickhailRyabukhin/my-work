public class Main {


    public static void main(String[] args) {

    //==============================  З А Д А Н И Е  1 =================================================================
        System.out.println("З А Д А Н И Е № 1 ");
        System.out.println("");
        String name = "";
        int price = 0;
        int count = 0;
        double weight = 0.0;

        Basket basket1 = new Basket();
        basket1.clear();
        basket1.print("Содержимое корзины после очистки:");
        System.out.println(" Покупки: ");

        name = "Горшок "; price = 200; count = 4; weight = 2.00;
        System.out.println(" 1. " + name + " цена " + price + " руб  вес " + weight +" кг   количество "+count+" шт");
        basket1.add(name,price,count,weight);
        basket1.print("теперь в корзине ");
        System.out.println( "  ИТОГО ");
        System.out.println( " товаров на сумму "+ basket1.getTotalPrice() + " общий вес "+basket1.getTotalWeight());


             name = "Открытка "; price = 20; count = 20; weight = 0.002;
             System.out.println(" 2. " + name + " цена " + price + " руб  вес " + weight +" кг   количество "+count+" шт");
             basket1.add(name,price,count);
             basket1.print("теперь в корзине ");
        System.out.println( "  ИТОГО ");
        System.out.println( " товаров на сумму "+ basket1.getTotalPrice() + " общий вес "+basket1.getTotalWeight());

        //==============================  З А Д А Н И Е  2 =================================================================
        System.out.println("З А Д А Н И Е  2.  Проверка работы класса Arithmetic");
        System.out.println("");
       int first = 0;
       int second = 0;
       int Sum;
        Arithmetic calculator = new Arithmetic();
        first = calculator.getFirst();
        second = calculator.getSecond();
        System.out.println("Сумма " + first + " и " + second + " равна " + calculator.GetSum());
        System.out.println( first + " умножить на " + second + " равно " + calculator.GetMult());
        System.out.println( "Максимальное число из " + first + " и " + second + " равно " + calculator.GetMax());
        System.out.println( "Минимальное число из " + first + " и " + second + " равно " + calculator.GetMin());
//==============================  З А Д А Н И Е  3 =================================================================
        System.out.println("");
        System.out.println("З А Д А Н И Е   3.  Проверка работы класса Printer");
        System.out.println("");

        String queue = "";
        String docName = "";
        String docText = "";
        int docPagesCount =0;
        int pendingPagesCount = 0;
        int totalPagesPrinted = 0;
        Printer outer = new Printer();

        docText = "Только текст документа";
         outer.append(docText);
         outer.print();

        docText = "Теперь документ называется так";
        docName ="сказка";
        outer.append(docText,docName );
        outer.print();

        docText = "А теперь целая тетрадь";
        docName ="тетрадь";
        docPagesCount = 12;
        outer.append(docText,docName,docPagesCount );
        outer.print();
        System.out.println("Всего распечатано " + outer.getTotalPagesPrinted() + "страниц");
        System.out.println("");
                for (int i = 0; i<3;i++){
        docText = "Просто вбиваем документ #"+i+" и называем его так же";
        docName = "документ #"+i;
        docPagesCount = i+10;
        outer.append(docText,docName,docPagesCount );
        }
        System.out.println("");
        System.out.println( "Всего в очереди  " +  outer.getPendingPagesCount() + " страниц");
        outer.print();
        System.out.println("Всего распечатано " + outer.getTotalPagesPrinted() + "страниц");
    }
}
