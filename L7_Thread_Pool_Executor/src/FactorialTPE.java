import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FactorialTPE {

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() - 1);
        List<Future<BigInteger>> futures = new ArrayList<>();
        for(Integer number : numbers) {
            Callable<BigInteger> task = () -> factorial(number);
            futures.add(executor.submit(task));
        }

        for(Future<BigInteger> future : futures) {
            System.out.println(future.get());
        }

        executor.shutdown();

        // JVM will continue to run until even one non daemon thread has not terminated

    }
}
