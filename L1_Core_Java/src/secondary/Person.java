package secondary;

public class Person {

    public Integer age; // member variable / instance variable
    private String name;
    String gender;
    protected String country;

    // Setter
    private void setAge(Integer ageParam){// member functions / instance functions
        if(ageParam < 0){
            System.out.println("Invalid age");
            return;
        }
        age = ageParam;
    }

    // Getter
    Integer getAge(){
        return age;
    }

    public static void main(String[] args) {
        Person person = new Person();
    }
}
