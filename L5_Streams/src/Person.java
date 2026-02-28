import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }


    public boolean nameStartsWithVowel(){
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');
        vowelSet.add('A');
        vowelSet.add('E');
        vowelSet.add('I');
        vowelSet.add('O');
        vowelSet.add('U');

        if(this.name == null || this.name.isEmpty()){
            return false;
        }

        char ch = this.name.charAt(0);
        if(vowelSet.contains(ch)){
            return true;
        }

        return false;
    }

    public static String compareNames(String n1, String n2){
        return n1.compareTo(n2) < 0 ? "true" : "false";
    }


    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jack", 18));
        personList.add(new Person("John", 19));
        personList.add(new Person("Jim", 20));
        personList.add(new Person("Adam", 25));
        personList.add(new Person("Mary", 26));
        personList.add(new Person("oliver", 19));



//        System.out.println(convertNames(personList));
        System.out.println(getPeople(personList));
//        print(personList);

//        List<String> names = Arrays.asList("Jack, John", "Jim");
//        String result = names
//                .stream()
//                        .reduce("", Person::compareNames); // x, y -> compareNames(x, y)
////
//
//        String result2 = names
//                .stream()
//                .reduce("", (x, y) -> compareNames(y, x));
//
//        System.out.println(result + " " + result2);


        // Q1. get the names in uppercase of all the people in the list
        // Q2. Find all the people who are older than 20 years and their name starts with a vowel (Can be in uppercase or lowercase)
    }

    public static List<String> convertNames(List<Person> people){

        return people.stream()
                .map(x -> x.name.toUpperCase())
                .collect(Collectors.toList());
    }

    public static List<Person> getPeople(List<Person> people){

        return people.stream()
                .filter(p -> {
                    System.out.println("Inside filter function: p - " + p.name);
                    return p.age > 20;
                })
                .filter(x -> {
                    System.out.println("Inside 2nd filter function: p - " + x.name);
                    return x.nameStartsWithVowel();
                }).collect(Collectors.toList());
    }

    public static void print(List<Person> people){

        people.stream()
                .forEach(System.out::println);
//                .forEach(x -> System.out.println(x));
    }

    public static List<String> collectAll(List<Person> people){

        List<String> result = new ArrayList<>();
        people.stream()
                .map(x -> x.name)
                .forEach(x -> result.add(x));      // t1 (p1) --> list        // t2 (p2) --> list

        return result;
    }

    // findFirst - returns the first element which matches some condition (if a filter function is applied)
    //  10 worker threads - 100 elements
    //  multiple of 9 - sorted list
    //  1, 2, 21, 13, 14, 50, 67, 70, 89, 40
    //  18, 19, 10, 5, 6,        7, 8, 11, 12
}
