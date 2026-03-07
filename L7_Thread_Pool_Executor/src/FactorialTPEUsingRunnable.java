import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FactorialTPEUsingRunnable {

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<?>> futures = new ArrayList<>();
        for(Integer number : numbers) {
            futures.add(executor.submit(() -> {
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

//                factorial(200000);
                System.out.println("Inside runnable " + number + ", thread - " + Thread.currentThread());
            }));
        }

//        for(Future<?> future : futures) {
//            Object result = future.get();
//            System.out.println(result);
//        }

        System.out.println("Tasks are submitted and we are going to shutdown soon...");
//        Thread.sleep(2000);

        List<Runnable> pendingTasks = executor.shutdownNow();



        System.out.println("Submitting a new task...");
//        executor.submit(() -> System.out.println("Submitting a task after shutting down..."));

        // A : It won't be
        // B : It will be
        // C : May or may not
    }
}
