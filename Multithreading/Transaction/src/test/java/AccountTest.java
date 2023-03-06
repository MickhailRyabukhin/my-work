import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

class AccountTest {
    
    public static Account accountSender;
    public static Account accountGetter;
    private static Random random = new Random();
    public long count = random.nextLong(1000L, 3000L);
    public static long sumCount;
    
    @BeforeAll
    
    public static void filData() {
        accountSender = new Account(random.nextLong(5000L, 6000L), "accountSender");
        accountGetter = new Account((random.nextLong(1000L, 3000L)), "accountGetter");
        sumCount = accountSender.getMoney() + accountGetter.getMoney();
    }
    
    @Test
    void sendTest() {
        long sender = accountSender.getMoney() - count;
        long taker = accountGetter.getMoney() + count;
        try {
            accountSender.send(accountGetter, count);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(sender, accountSender.getMoney(), "Проверка счета - отправителя");
        Assertions.assertEquals(taker, accountGetter.getMoney(), "Проверка счета - получателя");
        Assertions.assertEquals(sumCount, accountGetter.getMoney() + accountSender.getMoney(), "Проверка контрольной суммы");
    }
    
}