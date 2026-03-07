//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Test {

    // The application will run as long as the main thread runs - absolutely wrong
    // application will run as long as any non-daemon / foreground thread runs whether it is used created or JVM created

    public static void main(String[] args) {
        System.out.println("Inside main function...." + Thread.currentThread());

        // Developer starts writing the code from main thread of main ThreadGroup
        // Whenever you try to create your own group, it will always be under main as the Threadgroup

//        MyThread myThread = new MyThread();
//        myThread.start();

        Thread t = new MyThread();
//        t.setDaemon(true);
        t.start();

//        Thread t2 = new MyThread();
//        t.start();
//        System.out.println("Inside main function... after thread creation... " + Thread.currentThread());

    }

//    private static class MyThread extends Thread{
//
//        @Override
//        public void run() {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            System.out.println("Inside run method of thread -- " + Thread.currentThread());
//        }
//    }
}