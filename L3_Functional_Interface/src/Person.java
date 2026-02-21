import java.sql.Array;
import java.util.*;

public class Person{

    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null){
            return false;
        }

        System.out.println("obj is not null");

//        Person p = (Person) obj;
//        if(p.id == this.id && p.name == this.name){
//            return true;
//        }

        User user = (User) obj;

        if(user.getId() == this.id && user.getName().equals(this.name)){
            return true;
        }

        return false;

    }

    @Override
    public String toString() {
        return "{ id = " + id + ", name = " + name + " }";
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "ABC");
//        Person p2 = new Person(1, "ABD");
//
//        System.out.println(p1 == p2);
//        System.out.println(p1.equals(p2));

        String s1 = "ABC";
        String s2 = "ABC";

        String s3 = new String("ABC");
        String s4 = new String("ABC");


//        System.out.println(s1 == s2);
//        System.out.println(s3 == s4);
//
//        System.out.println(s3.equals(s4));
//
        User u1 = new User(1, "ABC");

        System.out.println(p1.equals(u1));


//        System.out.println(u1 instanceof User);
//        System.out.println(p1 instanceof User);


        /**
         * Given a list of people, you need to sort them in ascending order
         * Logic : First sort on the id in ascending order, if the ids are same then sort on the basis
         *         of name in descending order
         *
         */

        List<Person> people = Arrays.asList(
                new Person(1, "ABC"),
                new Person(2, "DEF"),
                new Person(2, "DEG"),
                new Person(5, "PQR"),
                new Person(3, "XYZ")
        );

        Comparator<Person> comp = (o1, o2) -> { // I'm creating a new object of anonymous inner class of Comparator FI and defining the function with the help of lambda expression
            System.out.println("Comparison happening: " + o1.getName() + " " + o2.getName());
            if(o1.getId() == o2.getId()){
                return o2.getName().compareTo(o1.getName()); // descending order of name
            }

            return o1.getId() - o2.getId(); // ascending order of id
        };

//        Collections.sort(people, comp);
//        Collections.sort(people, new PersonComparator()); // here also I'm creating a new object of personComparator which is an implementing class of Comparator FI

//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                System.out.println("Comparison happening: " + o1.getName() + " " + o2.getName());
//                if(o1.getId() == o2.getId()){
//                    return o2.getName().compareTo(o1.getName()); // descending order of name
//                }
//
//                return o1.getId() - o2.getId(); // ascending order of id
//            }
//        });

        System.out.println(people);
    }
}
