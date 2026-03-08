public class BankAccount {

    private String accountNumber;
    private Long balance;

    public BankAccount(String accountNumber, Long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    /**
     * Critical section is a hypothesis that is used to explain the race conditions and inconsistencies that might arise if multiple threads work on shared resource
     * but the actual implementation of critical section is achieved using synchronized keyword in java
     */

    public synchronized void deposit(Long amount) throws InterruptedException {
        System.out.println("Inside deposit function, amount - " + amount + ", thread - " + Thread.currentThread());
//        synchronized (this) {
            System.out.println("Inside deposit function's critical section....");
            Thread.sleep(20000);
            Long temp = this.balance + amount;
            this.balance = temp;
            System.out.println("Exiting deposit function's critical section....");
//        }
        System.out.println("Exiting deposit function, amount - " + amount + ", thread - " + Thread.currentThread());
    }

    public synchronized void withdraw(Long amount) throws InterruptedException {
        System.out.println("Inside withdraw function, amount - " + amount + ", thread - " + Thread.currentThread());
//        synchronized (this) { // thread takes a lock on a specific section of the code (critical section)
            System.out.println("Inside withdraw function's critical section....");
            Thread.sleep(10000);
            Long temp = this.balance - amount;
            this.balance = temp;
            System.out.println("Exiting withdraw function's critical section....");
//        } // thread releases the lock
        System.out.println("Exiting withdraw function, amount - " + amount + ", thread - " + Thread.currentThread());
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
