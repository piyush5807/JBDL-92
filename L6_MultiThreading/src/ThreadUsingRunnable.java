public class ThreadUsingRunnable {

    public static void main(String[] args) {

        Thread[] threads = new Thread[10];
        for(int i = 0; i < threads.length; i++){
            threads[i] = new Thread(() -> System.out.println("Inside MyThread... thread - " + Thread.currentThread()));
            threads[i].start();
        }

//        Runnable runnable = () -> System.out.println("Inside MyThread... thread - " + Thread.currentThread());
//        Thread t = new Thread(runnable);
//        t.start();

    }

//    private static class MyThread implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println("Inside MyThread... thread - " + Thread.currentThread());
//        }
//    }
}
