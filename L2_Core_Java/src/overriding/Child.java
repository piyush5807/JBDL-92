package overriding;

import java.util.ArrayList;
import java.util.List;

public class Child extends Parent{

//    @Override
    public void test(){
        System.out.println("Inside Child: test");
    }

    public void random(){
        System.out.println("Inside Child: random");
    }

//    public void test(){  // This is coming by the virtue of inheritance and hence contributing to method overloading
//        System.out.println("Inside Parent: test");
//    }

    public static void main(String[] args) {

//        Parent p = new Parent(); // all functions that will be invoked will be of parent class whose instance is created
//        p.test();

//        Child c = new Child(); // all functions that will be invoked will be of child class whose instance is created
//        c.test();
//        c.random();

        // Reference -- Instance
        // Reference is only for restricting the scope of the right hand side (object which is getting called)
//        Child child = new Parent(); // This is not possible

//        Parent obj = new Child(); // child function will be called
//        obj.test();
//        obj.test("10");
//        obj.random();

        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.trimToSize();
        System.out.println(al);

        List<Integer> list = new ArrayList<>();
        list.add(10);
//        list.trimtoSize();
        System.out.println(list);

    }
}
