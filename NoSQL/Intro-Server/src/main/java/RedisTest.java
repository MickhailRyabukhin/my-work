import java.util.Random;

import static java.lang.System.out;

public class RedisTest {

    public static void main(String[] args) throws InterruptedException {

        // Подключаемся к редису
        RedisStorage redis = new RedisStorage();
        redis.init();
        // создаем 20 пользователей
        for (int i=0; i<20; i++){
            redis.addUser(i);
        }
        /* Эта часть кода использовалась для отладки и проверки работы методов

        // Проверяем создание пользователей
        ArrayList<String>users = new ArrayList<>(redis.getAllUsers(0,20));
        for (int i=0; i<20; i++){
            out.println(users.get(i));
        }
        out.println( "Проверяем вызов пользователя из базы");
        for (int i=0; i<20; i++){
            out.println (redis.getUser(i).get(0));
        }
        out.println("\nОткрываем бесконечный цикл \n");*/

        // Открываем бесконечный цикл
        Random random = new Random();
        int tenthUser = 0;
        for (int i = 0; i < 20; i++) {
            //Задержка вызова очередного пользователя
            Thread.sleep(1000);
            // Один из 10 пользователей оплачивает услугу "показать вне очереди"
            if (tenthUser==10){
                int rand = random.nextInt(1,20);
                out.println ("\t\t"+redis.getUser(rand).get(0)+" оплатил услугу ");
                tenthUser=0;
            }
            tenthUser++;
            // Остальные выводятся в цикле по очереди
                out.println (redis.getUser(i).get(0));
            // По достижении конца очереди начинаем сначала
            if (i==19){i=-1;}
        }

        // Выход из бесконечного цикла не предусмотрен, поэтому следующую строку можно удалить
        redis.shutdown();
    }
}
