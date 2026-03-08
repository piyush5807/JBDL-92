import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ParallelStreams {

    public static Integer getSquaresOfEvenNumbers(List<Integer> numbers) {
        System.out.println("Inside getSquaresOfEvenNumbers");
        return numbers
                .stream()
                .parallel()
                .filter(x -> {
//                    System.out.println("Inside filter of - " + x + ", thread - " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .map(x -> {
//                    System.out.println("Inside map of - " + x + ", thread - " + Thread.currentThread());
                    return x*x;
                })
                .reduce(1, (x, y) -> {
                    System.out.println("Inside map of - " + x + " , y = " + y + ", thread - " + Thread.currentThread());
                    return x + y;
                });
    }

    public static Integer findFirstEvenNumber(List<Integer> numbers) {
        System.out.println("Inside findFirstEvenNumber");
        return numbers.stream().parallel()
                .filter(x -> {
                    System.out.println("Inside filter: x - " + x);
                    return x % 11 == 0;
                })
                .findFirst().get();

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,  26, 27, 28, 29, 30);
//        List<Integer> result = numbers
//                .stream()
//                .parallel()
//                .filter(x -> {
//                    System.out.println("Inside filter of - " + x + ", thread - " + Thread.currentThread());
//                    return x % 2 == 0;
//                })
//                .map(x -> {
//                    System.out.println("Inside map of - " + x + ", thread - " + Thread.currentThread());
//                    return x*x;
//                })
//                .collect(Collectors.toList());


//        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newWorkStealingPool(5);
        Future<Integer> future = executorService.submit(() -> {
            System.out.println("Inside executor service");
            return findFirstEvenNumber(numbers);
        });

        future.get();

        executorService.shutdown();

        // Streams - Result that we get is dependent upon certain factors
        // 1. Terminal function that we are using - findFirst / findAny - short circuiting or non short circuiting like collect
        // 2. Type of data structure we are using to convert it into streams - findFirst on a set does not make sense
        // 3. Which type of stream we are using : sequential or parallel ? findFirst - evaluations can be more because multiple threads are used for evaluating the expression, answer will not change even if you are using sequential or parallel streams
        //          if you are using wrong identity in reduce functions like addition / subtraction / multiplication - sequential streams and parallel streams outputs can be different


    }
}
