import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CollectionsExample {

    private HashMap<String, Boolean> map = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {

        CollectionsExample obj = new CollectionsExample();

        List<String> urls = Arrays.asList("abc.com", "def.com", "pqr.com", "xyz.com", "jkl.com", "abc.com", "ghi.com", "pqr.com", "bcd.com");
        MyThread[] threads = new MyThread[urls.size()];
        for (int i = 0; i < threads.length; i++) {
            if(i == 5 || i == 7) {
                threads[i] = new MyThread(urls.get(i), obj, false);
            }else{
                threads[i] = new MyThread(urls.get(i), obj, true);
            }
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("map = " + obj.map);
    }

    private static class MyThread extends Thread {

        private String url;
        private CollectionsExample obj;
        private boolean add;

        MyThread(String url, CollectionsExample obj, boolean add) {
            this.url = url;
            this.obj = obj;
            this.add = add;

        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(add) {
                this.obj.map.put(this.url, true);
            }else{
                this.obj.map.remove(this.url);
            }
            System.out.println("Inside run function, adding url to the map - " + currentThread() + " , url - " + this.url + ", add - " + this.add);
//            map.put(this.url, true);
        }
    }
}
