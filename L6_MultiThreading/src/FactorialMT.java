import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class FactorialMT {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Runtime.getRuntime().availableProcessors());

        /**
         * Given a list of numbers, we need to calculate the factorial of each number
         * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
         * [1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 ]
         *
         * [10000, 20000, 30000, 40000, 50000, 60000, 35000, 25000, 45000, 55000]
         */

        // Instead of creating 50 threads, what if I create 10 threads only and assign tasks to these threads
        // Whenever a thread is done executing a task, assign them a new task

        // Cores - 8 / 10
        // At a time, I can run only 8 / 10 parallel threads
        // Ex: 1000 elements in my list
        // Threads - 1000

        // Time = Time for the thread to execute + Time spent in context switching
        // Time spent in context switching <<< Time for the thread to execute

        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 35000, 25000, 45000, 55000, 75000, 80000);
        MyThread[] threads = new MyThread[numbers.size()];
        long start = System.currentTimeMillis();
        for(int i = 0; i < numbers.size(); i++){
            threads[i] = new MyThread(numbers.get(i));
            threads[i].start();
        }

        for(int i = 0; i < numbers.size(); i++){
            threads[i].join();
//            System.out.println("i = " + i + ", result = " + threads[i].result);
        }

        long end = System.currentTimeMillis();
        System.out.println("time spent - " + (end - start));
    }


    private static class MyThread extends Thread{

        private Integer number;
        private BigInteger result;
        MyThread(Integer number){
            this.number = number;
            this.result = BigInteger.ONE;
        }

        @Override
        public void run() {
            // logic to calculate factorial
            System.out.println("Inside thread - " + currentThread());
            compute();
        }

        private BigInteger compute(){
            for(int i = 2; i <= number; i++){
                result = result.multiply(BigInteger.valueOf(i));
            }

            return result;
        }
    }
}
