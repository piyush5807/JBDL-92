import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Child extends Parent{

    private String name;

    public Child(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        List<Child> children = Arrays.asList(
                new Child("ABC"),
                new Child("DEF")
        );

        Stream<Child> stream = children.stream();

        Function<Parent, ResultParent> function = new Function<Parent, ResultParent>() {
            @Override
            public ResultParent apply(Parent parent) {
                return null;
            }
        };

        // T - Child
        // Parent
        // Child extends from parent


        List<ResultParent> result = stream
                .map(function)
                .collect(Collectors.toList());
    }
}
