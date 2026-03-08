//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        // This obj will become our shared resource that will be shared across multiple threads
//        BankAccount obj = new BankAccount("a1", 50000l);
//        BankAccount obj2 = new BankAccount("a2", 50000l);

//        long start = System.currentTimeMillis();
//
//        MyThread t1 = new MyThread(obj, true, 1000l);
//        MyThread t2 = new MyThread(obj, false, 2000l);
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        long end = System.currentTimeMillis();
//        System.out.println("obj = " + obj + ", time  = " + (end - start));


        DBConnection obj1 = new DBConnection();
        DBConnectionThread t1 = new DBConnectionThread("abc.com", obj1);
        DBConnectionThread t2 = new DBConnectionThread("xyz.com", obj1);
        DBConnectionThread t3 = new DBConnectionThread("pqr.com", obj1);
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
        System.out.println("connection - " + DBConnection.getConnection());

        /**
         * You should only use synchronized keyword at places where you want to restrict parallelism to
         * achieve consistency and avoid any race conditions
         */

    }

    private static class MyThread extends Thread {

        private BankAccount account;
        private boolean isDeposit;
        private Long amountToTransact;

        public MyThread(BankAccount account, boolean isDeposit, Long amountToTransact) {
            this.account = account;
            this.isDeposit = isDeposit;
            this.amountToTransact = amountToTransact;
        }

        @Override
        public void run() {
            System.out.println("Inside run function, isDeposit " + isDeposit + " thread - " +  currentThread());
            if(this.isDeposit){
                try {
                    this.account.deposit(this.amountToTransact);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    this.account.withdraw(this.amountToTransact);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}