package inheritance;

public class Car extends Vehicle{

    /**
     * Car becomes a child class
     * Vehicle becomes a parent class
     *
     * What all comes to the child from parent ?
     * 1. public variables and methods
     * 2. protected variables and methods
     * 3. default variables and methods are inherited only when the parent and child are in the same package
     */

    public static void main(String[] args) {
        Car car = new Car();
        System.out.println(car.getMileage());
        System.out.println(car.model);
        System.out.println(car.color);
    }
}
