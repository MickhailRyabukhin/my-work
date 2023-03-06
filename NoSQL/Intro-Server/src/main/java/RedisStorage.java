import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.round;
import static java.lang.System.out;

public class RedisStorage {

    // Объект для работы с Redis
    private RedissonClient redisson;

    // Объект для работы с Sorted Set'ом
    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "ONLINE_USERS";

    /* Остатки "рыбы"

    private double getTs() {
        return new Date().getTime() / 1000.;
    }


    // Пример вывода всех ключей
    public void listKeys() {
        String string = "564";

        Iterable<String> keys = rKeys.getKeys();
        for (String key : keys) {
            out.println("KEY: " + key + ", type:" + rKeys.getType(key));
        }
    }

     */
    // Подключение к редису
    void init() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        // Объект для работы с ключами
        RKeys rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }

    void addUser(double v) {
        onlineUsers.add(v, "Пользователь " + (round(v) + 1));
    }

    List<String> getUser(int userNum) {
        return new ArrayList<>(onlineUsers.valueRange(userNum, userNum));
    }

    //Метод использовался для отладки кода, больше не используется.
    List<String> getAllUsers(int start, int end) {
        return new ArrayList<>(onlineUsers.valueRange(start, end));
    }

    // не используется, т.к. по заданию выход из цикла не предусмотрен
    void shutdown() {
        redisson.shutdown();
    }
}
