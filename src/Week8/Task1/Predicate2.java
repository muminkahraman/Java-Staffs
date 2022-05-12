package Week8.Task1;

import java.util.function.Predicate;

public class Predicate2 implements Predicate<Person> {
    private int[] ages = {5,6,7};

    public Predicate2()
    {}

    @Override
    public boolean test(Person person) {
        boolean result = false;
        int age = person.getAge();
        for (int element : ages){
            if (element == age){
                result = true;
            }
        }
        return result;
    }
}