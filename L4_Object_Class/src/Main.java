import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    /**
     * Exception Handling : Different Ways to handle exceptions
     *  1. Exception vs Error -
     *
     *  Exceptions - Less severe than errors and they can be handled by the programmer
     *      1. Runtime exception / Unchecked exceptions
     *      2. Non runtime exception / Checked exception
     *
     *  Error - Out of Memory error - whenever there's a memory leak
     *        - stack overflow - infinite loop
     *        - resources not found error
     *        - deadlock -
     *
     *  Ways to handle any exception:
     *  1. try catch block : the place where this code is written, exception is being then and there only
     *  2. using throws keyword in the function declaration : not handling at the place where it's written but delegating
     *     this to the function from where it's being called.
     */

    public static void main(String[] args) throws IOException, NullPointerException, ArithmeticException{

//        int a = 1 / 0;
//        System.out.println(a);

//        Person p = null;
//        System.out.println(p.hashCode());


//        try {
//            FileInputStream fis = new FileInputStream("/Users/piyush/Downloads/L4_Object_Class/.gitignore");
//            fis.read();
//            fis.close(); // throws abc exception which is also a child of IOException
//        } catch (FileNotFoundException  | ArithmeticException e){
//            System.out.println("IO Exception: " + e.getMessage());
//            e.printStackTrace();
//            throw e;
//        } finally {
//            System.out.println("Inside finally block");
//        }

//        try (FileInputStream fis = new FileInputStream("/Users/piyush/Downloads/L4_Object_Class/.gitignore")){
//            System.out.println("Inside try block");
//            fis.read();
//        }catch(Exception e){
//            System.out.println("Exception in try block");
//            e.printStackTrace();
//        }

        try (Person p = new Person("Aditya", 10)){
            System.out.println("Inside try block" + p.hashCode());
        }catch (Exception e){
            System.out.println("Exception in try block");
        }

        // By default java will call the close of the object which is defined in the try with resource block

    }

    public static void A(){
        B();
    }

    public static void B() {
        try {
            C();
        }catch (Exception e){
            e.printStackTrace();
//            throw e;
        }
    }

    public static void C() throws Exception {
        System.out.println("Inside C block");
        throw new Exception("random message...");
    }

    /**
     * try with resources
     */

    /**
     * GC
     * 1 abc
     * 2.  def
     * 3. call finalize()
     * 4. deletes the object
     *
     *
     * GC
     * 1. abc
     * 2. def
     * 3. deletes the object
     */
}
