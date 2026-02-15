package reskeywords;

import java.util.Random;

public class Dummy {

    // Default value of int --> 0
    // float --> 0.0
    // string --> null

    /**
     * Order of assignments on object initialization
     * 1. Member variables / non static blocks are defined with either default value or the value which is assigned to them
     * 2. Constructor is invoked and the logic inside the constructor is executed
     *
     * Note: Member variables and blocks are initialized / executed in the order they are defined in a class
     *
     * For both static and non static block, if we are not using this or the class name for referencing any instance or static variable
     * and the block is defined before the variable assignment, we are going to get compilation error
     */

    {
        int a = 10;
        System.out.println("Inside block, a = " + a);
        System.out.println("Inside block, this.number = " + this.number) ; // 0 , 10, 20
    }

    private int number = 10;
    private int number2;

    static { // This is at a class level not at an instance level, so whenever a class is loaded in the JVM, this will be called
//        System.out.println("Inside static block..., random number - " + count());
        System.out.println("Inside static block... finalCount = " + Dummy.finalCount);
    }

    public static int finalCount = 30;


    {
        System.out.println("Inside secondary block, this.number = " + this.number) ; // 0 , 10, 20
    }

    // this will be invoked whenever user invokes it.
    public void random(){
        System.out.println("Inside random method, number = " + this.number);
    }

    public static int count(){
        return new Random().nextInt(20);
    }

    public Dummy(int number){
        System.out.println("Inside constructor, number = " + number + ", this.number = "
                + this.number + ", this.number2 = " + this.number2);
        this.number = number;
        System.out.println("Inside constructor, this.number changed to --> " + this.number);
    }

    public static void main(String[] args) {
//        Dummy d = new Dummy(20);
//        d.random();

    }

}
