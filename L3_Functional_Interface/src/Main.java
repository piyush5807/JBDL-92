//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{

    /**
     * Functional Interface -  Interfaces which have only 1 non overridden abstract function
     * From Java 8 onwards, there's an introduction to lambda functions
     *
     * Lambda expression - expression that do not have name of the function being invoked, type of arguments etc.
     * We can write lambda expressions only for functional interfaces not for any other interface
     *
     * Main use case of lambda expressions is in Java streams / or anywhere else as well where you don't want to write the anonymous inner class
     *
     * Every class or interface in Java implicitly inherits from java.lang.Object class
     */

    public static void main(String[] args) {

//        Calculator c = new Calculator() {
//            @Override
//            public int add(int a, int b) {
//                System.out.println("Inside add function of anonymous class");
//                return a + b;
//            }
//
////            @Override
////            public int subtract(int a, int b) {
////
////            }
//        };

//        System.out.println(c.add(10, 20));

//        Calculator c2 = (a, b) -> a + b;  // single line lambda expression
//
        Calculator c3 = (a, b) -> {
            System.out.println("Inside lambda expression : a = " + a + ", b = " + b);
            return a + b;
        };

        System.out.println(c3.add(10, 20));
        System.out.println(c3.subtract(100, 20));

        CalculatorOps ops = (i, j) -> i + j + 10;
        System.out.println(ops.add(20, 35));

        /**
         * CalculatorOps ops = new CalculatorOps(){
         *     public int add(int i, int j){
         *         return i + j + 10;
         *     }
         * }
         */

    }
}