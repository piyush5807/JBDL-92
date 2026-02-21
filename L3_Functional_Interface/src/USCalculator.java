public interface USCalculator extends Calculator {
    @Override
    default int add(int a, int b){
        return a + b + 2;
    }
}
