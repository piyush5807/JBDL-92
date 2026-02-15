package reskeywords;

public class Main {

    /**
     * If you don't define a constructor, by default JDK adds a default constructor in the bytecode on behalf of you
     * However if you define a parameterized constructor, this will override the default constructor
     */

    public static void main(String[] args) {
//        Person p = new Person();
//        Person p1 = new Person();

//        Person[] people = new Person[100];
//        for(int i = 0; i < 100; i++){
//            // Scanner /
//            people[i] = new Person();
//        }


//        p.setAge(10);
//        p.setName("ABC");
//
////        p.count = 20; should not do i.e refer static variables from non static context
//        Person.count = 10;
//
//        System.out.println(p.getName() + " " + p.getAge());
//        System.out.println(Person.getCount());
//
//        Person p2 = new Person("XYZ", 20);

        Dummy d = new Dummy(20);
        Dummy d2 = new Dummy(20);
        Dummy d3 = new Dummy(20);
    }

    // static - attached in front of variables, methods to dignify that these entities are at a class level and not at an object / instance level
}
