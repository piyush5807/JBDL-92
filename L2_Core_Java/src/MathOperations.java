public class MathOperations extends Thread implements ICalculator, ICalculator2{

    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public int add(String a, String b) {
        return 0;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b + 1;
    }

    public static void main(String[] args) {
        MathOperations m = new MathOperations();
        m.subtract(1, 2);
    }
}
