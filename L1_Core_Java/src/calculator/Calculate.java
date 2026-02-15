package calculator;

public class Calculate {

    public static void main(String[] args) {
        USCalculator calculator = new USCalculator();
        System.out.println("Sum = " + calculator.add(10, 50));

        EnglishCalculator englishCalculator = new EnglishCalculator();
        System.out.println("Sum = " + englishCalculator.add(10, 50));

        // Reference     ->  Instantiation / Object
        Calculator calci = new EnglishCalculator();
        System.out.println(calci.add(10, 50));

        Calculator2 calci2 = new EnglishCalculator();
        System.out.println(calci2.add(10, 60));

//        EnglishCalculator englishCalculator2 = new EnglishCalculator();
//        englishCalculator2.multiply()

//        calci2.multiply();


//        Calculator calci = new Calculator(){ // Anonymous inner class
//            @Override
//            public Integer add(Integer a, Integer b){
//                return a + b;
//            };
//
//        }
    }
}
