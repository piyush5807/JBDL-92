public abstract class Calculator {

    public int add(int a, int b){
        return a+b;
    }

    public int subtract(int a, int b){
        return a - b;
    }

    public int multiply(int a, int b){
        return a * b;
    }

    public static void main(String[] args) {
//        Calculator c = new Calculator() { // Anonymous inner class
//            @Override
//            public int add(int a, int b) {
//                return 0;
//            }
//        };

        Calculator calculator = new Calculator() {};

//        Calculator calculator = new Calculator(){
//            @Override
//            public int add(int a, int b){
//                return a + b;
//            }
//
//            @Override
//            public int subtract(int a, int b){
//                return Math.abs(a - b);
//            }
//        };
//        System.out.println(calculator.add(1, 2));
//        System.out.println(calculator.subtract(10, 2));

        ICalculator calculator2 = new ICalculator(){
            @Override
            public int add(int a, int b){
                return a + b;
            }

            public int add(String a, String b){
                return Integer.parseInt(a + b);
            }
        };

//        Calculator calci = new CalculatorChild();
//        calci

        System.out.println(calculator2.add("a", "b"));

    }

}
