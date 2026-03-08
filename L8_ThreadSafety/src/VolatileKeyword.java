public class VolatileKeyword extends Thread{

    /**
     * Synchronized keyword ensures consistency by making the code sequential (Critical section)
     * Volatile keyword ensure threads always read and write from/to main memory, so different threads can see the changes
     * done by any other thread instantly but it does not ensure consistency because multiple threads can still run parallely
     */

    private boolean flag = true;

    @Override
    public void run() {
        while(flag){
            System.out.println("Inside run function... " + Thread.currentThread());
//            try {
//                Thread.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileKeyword obj = new VolatileKeyword();
        obj.start();

        Thread.sleep(1000);

        obj.flag = false;
        System.out.println("after making flag as false....");

    }

}
