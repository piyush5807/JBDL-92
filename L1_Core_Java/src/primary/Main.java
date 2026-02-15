package primary;

import secondary.Person;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person = new Person();
//        person.setAge(-20);
//        Integer age = person.getAge();

         person.age = -20;
         Integer age2 = person.age;

//         person.name = "ABC";

//        person.gender = "Male";
//        person.country = "India";
    }
    /**
     * JDK - Java development kit
     * JRE - Java Runtime Environment
     *
     * Whenever we run a program from the IDE, it's a 2 step process
     * 1. High level code (.java) --> ByteCode (JDK) (.class)
     *      javac <highlevelcode-filename>
     * 2. ByteCode is run inside the JVM (Java virtual machine) JVM comes from JRE when you install Java
     *      java <bytecode-filename>
     *
     *  Oops: Object oriented programming
     *  Classes and Objects
     *  Object represents a real world entity in an application
     *
     *  Class is a place where we can list what all fields are there for an object and what all actions can be taken on a specific object
     *
     *  video - name, duration, directedBy, producedBy, ...
     *          play video, change the details of the video
     *
     *  1. Encapsulation -  Putting together data fields / variables and the functionalities that can be
     *  implemented on those data field together at a single place
     *  This is shown classes in Java
     *
     *  2. Data hiding - Attributes or member variables should be not directly accessible from outside the class
     *                   Instead they should be accessed via member functions.
     *     Private - variables / functions that have private access modifier are not accessible outside the current class in which they are defined
     *     Empty / Default - variables / functions that have default access modifier are not accessible outside the current package in which they are defined
     *     Protected - variables / functions that have protected access modified are accessible in all the classes of the current package (just like default scope)
     *     + also accessible in inherited classes of a different package
     *     Public - Variables / functions that have public access modifier are accessible everywhere in the entire project
     *
     *  3. Inheritance - Phenomenon of extracting some properties and behaviours from an existing parent class
     *  Exhibited by classes and interfaces
     *
     *  4. Abstraction -  It involves hiding the complex implementation details while only showing the
     *                    essential functionality to the user
     *  Exhibited by interfaces and abstract classes.
     *
     *
     *  5. Polymorphism
     *      5.1 Compile Time Polymorphism
     *      5.2 Run time Polymorphism
     *
     *
     * Data types
     * 1. primitive data types
     *     a) int
     *     b) char
     *     c) float
     *     d) double
     *     e) byte
     *     f) boolean
     *     g) long
     *     h) short
     *
     * 2. derived data types : all the classes except the primitive data types whether it is created by an end user
     *                         or exists as library class (predefined by the library creator)
     */
}