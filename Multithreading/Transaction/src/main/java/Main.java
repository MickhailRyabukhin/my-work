import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static Bank bank = new Bank();
    private static Random random = new Random();
    private static Map<String, Account> accounts = new HashMap<>();
    
    public static void main(String[] args) throws InterruptedException {
        
        //заполняем карту счетов
        fillBankMap(50);
        //начинаем обмен переводами
        
        int accountsSize = accounts.size();
        for (int i = 0; i < accountsSize; i++) {
            //готовим исходные значения
            String fromAccount = "account #" + i;
            
            for (int j = 0; j < accountsSize; j++) {
                if (i == j) {
                    continue;
                }
                long amount = random.nextLong(1000L, 50100L);
                String toAccount = "account #" + j;
                // передаем банку
                bank.setToAccountNum(toAccount);
                bank.setFromAccountNum(fromAccount);
                bank.setAmount(amount);
                bank.run();
                Thread thread;
                thread = new Thread(bank::run);
                thread.start();
                
            }
        }
    }
    
    public static void fillBankMap(int bankSize) {
        //заполняем карту счетов
        for (int i = 0; i < bankSize; i++) {
            // даем каждому номер
            String accNum = "account #" + i;
            // определяем сумму (случайную)
            long money = random.nextLong(500000L, 1000000L);
            // открываем счет
            Account account = new Account(money, accNum);
            // заносим в карту счетов
            accounts.put(accNum, account);
        }
        bank.setAccounts(accounts);
    }
}
