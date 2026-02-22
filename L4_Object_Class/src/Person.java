import java.util.HashMap;
import java.util.Objects;

public class Person implements AutoCloseable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)  return false;

        Person person = (Person)obj;
        if(this.name.equals(person.name)){
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
        // int / Integer => hashCode() value
        // string => hashCode () value
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Hey! I am going to deleted now, this is printed before deletion..." + this);
    }

    public static void main(String[] args) throws InterruptedException {
        Person person = new Person("Ashish", 20);
        Person person2 = new Person("Ashish", 30);


        HashMap<Person, Boolean> personMap = new HashMap<>();
        personMap.put(person, true);
        personMap.put(person2, true);

        System.out.println(person == person2);
        System.out.println(person.equals(person2));

        System.out.println(person.hashCode() + " " + person2.hashCode());
        System.out.println(personMap);

        person = null;
        System.gc();

        /**
         * GC of Java is unpredictable as to when it will run and what all memory reference will be cleaned
         * From Java 9+ onwards, finalize function has been deprecated so that no developer defines some logical stuff
         * to take place inside finalize function because it may or may not be invoked and the logical stuff (database connection close)
         * is not done.
         */

        Thread.sleep(60000); // Waiting for 20 seconds more

        // int - primitive
        // Integer -

        // float -
        // Float

        String a = new String("abc");
        String b = new String("abc");

//        System.out.println(number.hashCode() + " " + number2.hashCode());
        System.out.println(a.hashCode() + " " + b.hashCode());

        Integer number = 20;
        Integer number2 = 30;

//        HashMap<String, Integer> map = new HashMap<>();
//        map.put(new String("abc"), 1);
//        map.put(new String("abc"), 2);
//
//        System.out.println(map);


        // Ideally your hashcode function should return different values for different objects and same value for same objects
        // same objects - hypothetical term, can be objects referring the same memory address or it can be on the basis of equality
        // o1 -> h1
        // o1' -> h1


        // Strategy used to do garbage collection - Mark and Sweep
        //
    }

    @Override
    public void close() throws Exception {
        System.out.println("Just before deletion, in the close block");
    }
}