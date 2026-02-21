import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        System.out.println("Comparison happening: " + o1.getName() + " " + o2.getName());
        if(o1.getId() == o2.getId()){
            return o2.getName().compareTo(o1.getName()); // descending order of name
        }

        return o1.getId() - o2.getId(); // ascending order of id
    }
}
