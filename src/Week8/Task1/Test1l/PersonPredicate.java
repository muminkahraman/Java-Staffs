package Week8.Task1.Test1l;

import java.util.function.Predicate;

public class PersonPredicate implements Predicate<Person> {

    private final String C1 ;

    public PersonPredicate(String C1)
    {
        this.C1 = C1 ;
    }

    @Override
    public boolean test(Person person) {
        String name = person.getName();
        return (name.compareTo(C1)>=0);
    }
}