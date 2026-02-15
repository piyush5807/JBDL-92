import java.util.concurrent.Callable;

public interface ICalculator {

    int add(int a, int b);

    int add(String a, String b);

    /**
     * Default functions in interfaces are introduced in Java 8. Because of this, now a developer
     * can write even non-abstract functions in an interface just like we do in abstract classes
     */

    default int subtract(int a, int b){
        return a - b;
    }
}
