package calculator;

public interface Calculator{

    /**
     * Interfaces are like a contract which the implementing classes needs to adhere / follow,
     * so usually people don't define variables in the interface
     *
     * Abstract functions are those that do not have any implemention, just the declaration is there.
     */

    /**
     * Implement (implements) vs Inherit (extends) ?
     * A class can implement an interface
     * A class can inherit another class
     * An interface can inherit another interface
     */

    /**
     * Kept the access modifier of all the interface functions to public, why ?
     *  1)
     */

    public Integer add(Integer a, Integer b);
    Integer subtract(Integer a, Integer b);
    Integer multiply(Integer a, Integer b);
    Integer divide(Integer a, Integer b);
}
