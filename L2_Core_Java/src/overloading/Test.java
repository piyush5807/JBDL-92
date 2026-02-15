package overloading;

public class Test {

    public int add(int a, int b){
        return a + b;
    }

    public String add(String a, String b){
        return a + b;
    }

    public int add(int a, int b, int c){
        return a + b + c;
    }

//    Not an example of function overloading, this is defining duplicate functions with the diff return type
//    public String add(int a, int b){
//        return String.valueOf(a + b);
//    }

    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(test.add(1, 2, 3));
        System.out.println(test.add("1", "10"));
    }
}
