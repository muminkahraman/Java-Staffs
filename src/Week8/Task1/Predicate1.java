package Week8.Task1;

import java.util.function.Predicate;

public class Predicate1 implements Predicate<Person> {
    private char testLetter ;

    public Predicate1(String letter)
    {
        this.testLetter = letter.toUpperCase().charAt(0) ;
    }

    @Override
    public boolean test(Person person) {
        char nameLetter = person.getName().toUpperCase().charAt(0);
        if (Character.compare(nameLetter, testLetter) == 0){
            return true;
        } else {
            return false;
        }
    }
}