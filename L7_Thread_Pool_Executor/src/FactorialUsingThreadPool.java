import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FactorialUsingThreadPool {

    // Cores - 10
    // TP - 9
    // 1 Main Thread

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }

    public static void calculateFactorialsUsingTPE(ExecutorService service, List<Integer> numbers) throws ExecutionException, InterruptedException {

        List<BigInteger> factorials = new ArrayList<>();
        List<Future<BigInteger>> futures = new ArrayList<>();

        long start = System.currentTimeMillis();

        for(Integer number : numbers){
            System.out.println("Calculating Factorial of " + number);
            futures.add(service.submit(() -> {
                    if (number == 10) {
                        throw new InterruptedException("Inside thread - " + Thread.currentThread() + " Factorial of 10 cannot be calculated");
                    }
                    System.out.println("Inside call function " + number + ", thread - " + Thread.currentThread());
                    return factorial(number);

            }));
        }

        for(Future<BigInteger> future: futures){
//            try {
                future.get(); // Internally calls thread.join / thread.yield | blocking call
//            }catch (ExecutionException | InterruptedException e){
//                System.out.println("Interrupted due to exception");
//                e.printStackTrace();
//            }
        }

        // Our code is not reaching this point if there's as an exception that is why executor service is not shut down and our application keeps on running
        service.shutdown();

        long end = System.currentTimeMillis();


        System.out.println("Time taken " + (end - start));
    }

    public static void calculateFactorialsUsingFJP(List<Integer> numbers) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newWorkStealingPool();
        List<BigInteger> factorials = new ArrayList<>();
        List<Future<BigInteger>> futures = new ArrayList<>();

        long start = System.currentTimeMillis();

        for(Integer number : numbers){
            System.out.println("Calculating Factorial of " + number);
            futures.add(service.submit(new Callable<BigInteger>() {

                public BigInteger call(){
                    System.out.println("Inside call function " + number + ", thread - " + Thread.currentThread());
                    return factorial(number);
                }
            }));
        }

        for(Future<BigInteger> future: futures){
            factorials.add(future.get()); // Internally calls thread.join / thread.yield | blocking call
        }

        service.shutdown();

        long end = System.currentTimeMillis();


        System.out.println("Time taken " + (end - start));
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println(Runtime.getRuntime().availableProcessors());
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
//        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 35000, 25000, 45000, 55000, 7500, 8000);

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try {
            calculateFactorialsUsingTPE(service, numbers);
        }catch (Exception e){
//            System.out.println("Inside catch");
//            e.printStackTrace();
            throw e;
        } finally {
//            System.out.println("Inside finally");
            service.shutdown();
        }
        System.out.println("*******************************************");
//        calculateFactorialsUsingFJP(numbers);

        
    }
}
