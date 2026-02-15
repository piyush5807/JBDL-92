package reskeywords;

public class Person {

    // This keyword is used to refer to the current object. It cannot be used in a static function

    Person(String name, Integer age){ // default constructor
        System.out.println("Inside person constructor.... name = " + name  + ", age = " + age);

        this.name = name;
        this.age = age;
    }

    Person(){
        System.out.println("Inside person constructor...");
    }

    public static int count;

    private String name;
    private Integer age;

    public static Integer getCount(){
        return count;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isSeniorCitizen(){
//        Integer age = this.getAge();
        if(age >= 60){
            return true;
        }

        return false;
    }
}
