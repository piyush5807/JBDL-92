package collections;

import java.util.*;

public class Main {

    /**
     * Arrays
     * List => ArrayList -
     * Set => HashSet
     * Map => HashMap
     */

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();

        List<String> capitalizedCities = new ArrayList<>();

        cities.add("Hyderabad");
        cities.add("London");
        cities.add("Paris");
        cities.add("New York");
        cities.add("San Francisco");
        cities.add("Delhi");

        // Add function
        for(int i = 0; i < cities.size(); i++) {
            capitalizedCities.add(cities.get(i).toUpperCase());
        }

//        System.out.println(capitalizedCities);
//
//
//        // delete
//        cities.remove("London");
//        cities.remove(0);
//        System.out.println(cities);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(50);
        numbers.add(60);
        numbers.add(70);
        numbers.add(80);

//        int index = numbers.indexOf(80);
//        Integer a = Integer.valueOf(80);
//        numbers.remove((Integer) 80);
//        System.out.println(numbers);

        // ArrayList - ordered collection
        // Time complexity
        // add element towards the end - O(1)
        // add element in b/w - O(N)
        // delete from the list - O(N)
        // get from array list - O(1)

        // Sets - unordered collection / data structure - DATA IS NOT STORED IN ANY PARTICULAR ORDER
        // Time complexity -
        // add / removal / retrieval - O(1)
        // duplicates are not allowed in sets unlike lists

        Set<String> days = new HashSet<>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Thursday");

//        System.out.println(days);

        // Map - unorder collection / data structure which stores key value pairs, extension of sets which only stores keys

        // Duplicate keys are not allowed, if you try to insert a key value pair which is already present in the map, the incoming one will override the existing one
        // Number of tasks done by a person on respective days

        // Time complexities
        // GET - O(1) // average case complexity | worst case | best case
        // PUT - O(1)
        // REMOVE - O(1)
        Map<String, Integer> map = new HashMap<>();
        map.put("Monday", 2);
        map.put("Tuesday", 3);

        System.out.println(map);

        map.put("Tuesday", 5);
        System.out.println(map);

        // Take as homework - read about them
        // Priority Queue
        // Stack
        // Queue
        // Dequeue
        // LinkedList



    }
}
