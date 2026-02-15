//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

//    public abstract void function(int a); // Not possible to define abstract functions in non abstract classes

    public static void main(String[] args) {

        /**
         * There are 2 ways to achieve abstraction in our codebases
         * 1. Interface
         * 2. Abstract classes - A class who instance cannot be created, or we can say a class where we can write
         * abstract and non abstract function
         *
         * Abstract - which does not have a definition
         *
         * Polymorphism - many forms. Object can execute similar functionality in multiple forms / ways
         *
         * Compile time polymorphism is exhibited by function overloading
         * Defining functions with same number but with different signature is known as function overloading
         * Signature - Argument types + Number of Arguments
         *
         *
         * Run time polymorphism is exhibited by method overriding
         * Defining the exact same function in the both the parent and child classes is known as method overriding.
         * Here the JVM decided which function to invoke during the runtime, not the compiler
         *
         *
         * calculator - generic
         * integers, string, floats,
         *
         * add(int a , int b)
         * add (String a, String b)
         */

        System.out.println(2 + 3);
        System.out.println(3.4 + 2.3);
        System.out.println("a" + "b");

    }
}