package calculator;

public class EnglishCalculator implements Calculator, Calculator2{

//    @Override - only for checking whether the name of the function and signature is matching the super class method's name and signature
    public Integer add(Integer a, Integer b) {
        System.out.println("Inside EnglishCalculator add function... a = " + a + ", b = " + b);
        return a + b + 1;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return Math.abs(a - b);
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b + 1;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return a / b + 1;
    }

//    @Override  // coming by the virtue of inheritance
//    public void run() {
//
//    }
}
