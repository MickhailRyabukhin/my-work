import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class Bank implements Runnable {
    
    private String fromAccountNum;
    private String toAccountNum;
    private long amount;
    private static Map<String, Account> accounts;
    public static ArrayList<String> blocked = new ArrayList<>(); // перечень заблокированных счетов.
    private static final Random random = new Random();
    
    public static synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        System.out.println("идет проверка");
        Thread.sleep(1000);
        return random.nextBoolean();
    }
    
    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    
    public static void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        
        // Если ни один из счетов не заблокирован
        if (blocked.contains(fromAccountNum) || blocked.contains(toAccountNum)) {
            System.out.printf("%s and %s \t are blocked \n", fromAccountNum, toAccountNum);
            return;
        }
        
        //и остаток на счете - отправителе достаточен
        if (getBalance(fromAccountNum) >= amount) {
            
            accounts.get(fromAccountNum).send(accounts.get(toAccountNum), amount);
            
        } else {
            //Если денег недостаточно, уведомить и выйти
            System.out.println(fromAccountNum + "  ==> "
                    + toAccountNum + " No money");
            return;
        }
        // Если перевод > 50000, проверяем службой безопасности
        if (amount > 50000) {
            System.out.println("Safety Checking");
            // Если проверка не прошла, блокируем оба счета
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {
                    System.out.println(fromAccountNum + " и " + toAccountNum + " блокируются");
                    blocked.add(fromAccountNum);
                    blocked.add(toAccountNum);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public static long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }
    
    public static long getSumAllAccounts() {
        long result = 0L;
        for (Account account : accounts.values()) {
            result += account.getMoney();
        }
        return result;
    }
    
    public void setAccounts(Map<String, Account> accounts) {
        Bank.accounts = accounts;
    }
    
    public void setFromAccountNum(String fromAccountNum) {
        this.fromAccountNum = fromAccountNum;
    }
    
    public void setToAccountNum(String toAccountNum) {
        this.toAccountNum = toAccountNum;
    }
    
    public void setAmount(long amount) {
        this.amount = amount;
    }
    
    @Override
    public void run() {
        try {
            
            transfer(fromAccountNum, toAccountNum, amount);
            System.out.println(getSumAllAccounts());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}




