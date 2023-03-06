import org.jetbrains.annotations.NotNull;

public class Account {
    
    private long money;
    private String accNumber;
    
    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }
    
    public synchronized void send(@NotNull Account account, long amount) throws InterruptedException {
        //wait();
        
        if (this.accNumber.equals(account.getAccNumber())) {
            return;
        }
        long newSender = this.money - amount;
        long newGetter = account.getMoney() + amount;
        synchronized (this) {
            account.setMoney(newGetter);
            this.setMoney(newSender);
            
        }
        
        System.out.printf("%s => %s \t %d \n", this.accNumber, account.accNumber, amount);
        notify();
    }
    
    
    public long getMoney() {
        return money;
    }
    
    public void setMoney(long money) {
        this.money = money;
    }
    
    public String getAccNumber() {
        return accNumber;
    }
    
    
}


