//@FunctionalInterface
public interface Calculator {

    int add(int a, int b);

    boolean equals(Object o);

    default int subtract(int a, int b){
        System.out.println("Inside subtract default function : a = " + a + ", b = " + b);
        return a - b;
    }
//    int add(int a, int b, int c);
//    int subtract(int a, int b);
}
