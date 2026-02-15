package overriding;

public class Parent {

    public void test(){
        System.out.println("Inside Parent: test");
    }

    public void test(String a){
        System.out.println("Inside Parent: test, a = " + a);
    }

    private void test2(){

    }

    public static void main(String[] args) {

        Parent parent = new Parent();
        parent.test2();

//        Child child = new Parent();
//        child.test2();

        Parent obj = new Child();
    }
}
