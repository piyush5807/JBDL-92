public class Person<T> {

    private T value;

    public Person(T value) {
       this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
