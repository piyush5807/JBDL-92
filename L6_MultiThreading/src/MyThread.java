public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Inside run method of thread -- " + Thread.currentThread());
    }
}
