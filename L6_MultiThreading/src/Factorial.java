import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Factorial {

    /**
     * Given a list of numbers, we need to calculate the factorial of each number
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * [1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800 ]
     *
     * [10000, 20000, 30000, 40000, 50000, 60000, 35000, 25000, 45000, 55000]
     */

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 35000, 25000, 45000, 55000);
        long start = System.currentTimeMillis();
        System.out.println(compute(numbers));
        long end = System.currentTimeMillis();

        System.out.println("Time spent - " + (end - start));
    }

    public static List<BigInteger> compute(List<Integer> numbers){

        return numbers.stream()
                .map(Factorial::factorial) // method referencing
                .collect(Collectors.toList());
    }

    public static BigInteger factorial(Integer number){
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
