public class EnglishCalculator implements USCalculator {

    @Override
    public int add(int a, int b) {
        return a + b + 1;
    }


    public static void main(String[] args) {
        EnglishCalculator calci = new EnglishCalculator();
        System.out.println(calci.add(10, 20));

        USCalculator usCalculator = new USCalculator() {
        };

        System.out.println(usCalculator.add(10, 20));

//        USCalculator calci2 = (a, b) -> a + b + 3;
    }
}
