public class Add<E, R> {

    public void print(E e, R r){
        System.out.println("e = " + e + ", r = " + r);
    }

    public static void main(String[] args) {
        Add<Integer, String> add = new Add();
        add.print(1, "10");

        // + - * /
        // Primitive data type + Wrapper classes
        // Derived data type - cannot perform any operation with these operators
    }
}
