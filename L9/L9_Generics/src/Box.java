import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Box<E> {

    private E item;

    public Box(E obj){
        this.item = obj;
    }

    public E getItem(){
        return this.item;
    }

    public void setItem(E obj){
        this.item = obj;
    }

    public String getItemClass(){
        return this.item.getClass().getName();
    }

    public E add(E value){
        if(value instanceof String){
            String item = (String) this.item;
            String addValue = (String) value;
            item.concat(addValue);
        }else if(value instanceof Integer){
            Integer item = (Integer) this.item;
            Integer addValue = (Integer) value;
            item += addValue;
//            setItem(item);
        }

        return null;
    }



    public static void main(String[] args) {

//        Box<Integer> o1 = new Box<>(10);
//        Box<String> o2 = new Box<>("Hello");
//        Box<Double> o3 = new Box<>(1.5);
//
//        Box<Person<Employee>> o4 = new Box<Person<Employee>>(new Person<>(new Employee("Rahul", "Gera", 20000l)));
//
//        Box<Employee> o6 = new Box<>(new Employee("abc", "def", 10000l));
////        Box<Person<Employee>> o7 = new Box<>(new Employee("abc", "def", 10000l)); This is not possible
//
////        Box<User> o8 = new Box<Person>(new User(10));
////        Box<Person> o9 = new Box<User>(new User(10));
//
//        Box<Person<Employer>> o5 = new Box<>(new Person<>(new Employer("ABC", "Technologies")));
//
//        System.out.println(o1.getItem() + " " + o2.getItem() + " " + o3.getItem() + " " + o4.getItem() + " " + o5.getItem());
//
//        System.out.println(o1.getItemClass() + " " + o2.getItemClass() + " " + o3.getItemClass() + " " + o4.getItemClass() +  " " + o5.getItemClass());
//
//        Map<String, List<Integer>> map = new HashMap<>();

//        Map<K, V> // K ==> String V ==> List<E>
//                                            ==> Integer

//        Object a = new Object();
//        Object b = new Object();
//
//        Object c = a + b;
//
//        Integer a = 10;
//        Integer b = 20;
//        Integer result = a + b;

        List<Person<Employee>> employees = Arrays.asList(
                new Person<>(new Employee("abc", "deg", 150l)),
                new Person<>(new Employee("abc", "def", 100l)),
                new Person<>(new Employee("abd", "def", 200l)));

//        Stream<User> stream = employees.stream();

//        Function<User, Boolean> function = new Function<User, Boolean>() {
//            @Override
//            public Boolean apply(User user) {
//                return true;
//            }
//        };
//
//        stream.map(function).collect(Collectors.toList());

    }
}