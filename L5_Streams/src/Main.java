import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 10, 5, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20);
//        System.out.println(compute(numbers));
//        System.out.println(compute2(numbers));
//        System.out.println(computeUsingStreams(numbers));
        System.out.println(computeUsingStreamsAndLambdas(numbers));

//        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    /**
     * Write a program to evaluate the sum of squares of even numbers from a list
     *
     * Write a program to find the first multiple of 5 from the list
     */

    // Stream - Creating a pipeline of certain stages which may or may not result in some output
//              There will be final stage to end that pipeline

    /**
     * The order of execution of stream functions is determined by the terminal operation
     *
     * Ex:
     * collect / reduce / for each --> all the elements were getting passed in the filter function
     * findFirst / findAny  --> not all the elements might go through the filter function as this is short circuiting terminal operation
     *
     */

    public static Integer findMultipleOf5_Imperative(List<Integer> numbers){

        for(Integer number: numbers){
            if(number % 5 == 0){
                return number;
            }
        }

        return null;
    }

    public static Integer findMultipleOf5(List<Integer> numbers){

        return numbers.stream()
                .parallel()
                .filter(x -> {
                    System.out.println("Inside filter function: x - " + x);
                    return x % 5 == 0;
                })
                .findFirst().orElse(null);
    }

    public static Integer computeUsingStreams(List<Integer> numbers){

        Stream<Integer> stream =  numbers.stream();

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        Function<Integer, Integer> function = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
//                Double d = Math.pow(integer, 2);
//                return d.intValue();

                return integer * integer;
            }
        };

        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer + integer2;
            }
        };

        stream = stream.filter(predicate);
        stream = stream.map(function);
        return stream.reduce(1, binaryOperator);
    }

    public static Integer computeUsingStreamsFinal(List<Integer> numbers){

        Integer result = numbers
                .stream() // Stream<Integer>
                .filter(new Predicate<Integer>() {      // Stream<Integer>
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                }).map(new Function<Integer, Integer>() {   // Stream<Integer>
                    @Override
                    public Integer apply(Integer integer) {
                        return integer * integer;
                    }
                }).reduce(0, new BinaryOperator<Integer>() {    // Integer
                    @Override
                    public Integer apply(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                });

        System.out.println(numbers);
        return result;
    }


    // Declarative programming - which is more verbose and readable
    // Till now we have not achieved any optimization in terms of speed. This code is not slower or faster than your
    // imperative program
    public static Integer computeUsingStreamsAndLambdas(List<Integer> numbers){

        return numbers.stream()
                .parallel()
                .filter( x -> {
                    System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread().getName());
                    return x % 2 == 0;
                })
                .map(x -> {
                    System.out.println("Inside map: x = " + x + ", thread = " + Thread.currentThread().getName());
                    return x * x;
                })
                .reduce(0, (x, y) -> {
                    System.out.println("Inside reduce: x = " + x + ", y = " + y + ", thread = " + Thread.currentThread().getName());
                    return x + y;
                });
    }

    /**
     * Time complexity - same
     * Cognitive complexity - score given to readability and understanding of a particular piece of code
     * Higher the cognitive complexity, more complex is your code in terms of readability
     *
     * Sonar Qube / Sonar Lint -
     */

    public static Integer compute(List<Integer> numbers){

        int sum = 0;
        for(int i = 0; i < numbers.size(); i = i + 1){
            if(numbers.get(i) % 2 == 0){ // This comparison will happen for all 10 elements
                sum += numbers.get(i) * numbers.get(i); // This evaluation will happen for only 5 elements which were even
            }
        }

        return sum;

        // Step 1: We are filtering out all the odd numbers
        // Step 2: We are computing the square of all the remaining numbers in the list
        // Step 3: Adding those computed numbers from step 2
    }

    public static Integer compute2(List<Integer> numbers){

        // Step 1: We are computing the square of all the remaining numbers in the list
        // Step 2: We are filtering out all the odd numbers
        // Step 3: Adding those computed numbers from step 2


        int sum = 0;
        for(int i = 0; i < numbers.size(); i = i + 1){
            int square = numbers.get(i) * numbers.get(i);
            if(square % 2 == 0){
                sum += square;
            }
        }

        return sum;
    }

    /**
     * In Streams.java interface, we can have 2 types of functions
     * Intermediate functions - functions that return stream as an output, i.e we need to apply certain other function on the output
     * to get some logical result
     *
     * Terminal functions - functions that do not return stream output, instead they return some logical output which is not a stream
     *
     * Every stream that we write needs exactly 1 terminal function to execute, if you don't end the stream with a terminal
     * function, your stream won't even execute.
     */
}