
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author gdm1
 */
public class SearchingExamples
{

    public static void main(String[] args)
    {
        intStreamSearchingExamples();
        personStreamSearchingExamples();
    }

    private static void intStreamSearchingExamples()
    {
        System.out.println("");
        System.out.println("Searching stream: 2, 4, 3, 1, 6, 5");
        searchIntStreamForFirstValue();
        searchEmptyIntStreamForFirstValueGetException();
        searchEmptyIntStreamForFirstValueOrElse();
        searchEmptyIntStreamForFirstValueWithTestIfPresent();
    }

    private static void searchIntStreamForFirstValue()
    {
        int firstNum
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .findFirst()
                        .getAsInt();

        System.out.println("First value: " + firstNum);
    }

    private static void searchEmptyIntStreamForFirstValueGetException()
    {
        try
        {
            int firstNum
                    = Arrays.asList(2, 4, 3, 1, 6, 5)
                            .stream()
                            .mapToInt(Integer::new)
                            .filter(i -> i > 10)
                            .findFirst()
                            .getAsInt();

            System.out.println("First value: " + firstNum);
        }
        catch (NoSuchElementException e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private static void searchEmptyIntStreamForFirstValueOrElse()
    {
        int firstNum
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .filter(i -> i > 10)
                        .findFirst()
                        .orElse(-1);

        System.out.println("First value: " + firstNum);
    }

    private static void searchEmptyIntStreamForFirstValueWithTestIfPresent()
    {
        OptionalInt firstNum
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .filter(i -> i > 10)
                        .findFirst();

        if (firstNum.isPresent())
        {
            System.out.println("First value: " + firstNum);
        }
        else
        {
            System.out.println("First value: Not present");
        }
    }

    private static void personStreamSearchingExamples()
    {
        System.out.println("");
        System.out.println("Searching person stream");
        searchPersonStreamForAnyValue();
        searchPersonStreamForFirstValue();
        searchEmptyPersonStreamForFirstValue();
    }

    private static void searchPersonStreamForAnyValue()
    {
        Person p
                = Arrays.asList(
                        new Person("Graham", 23),
                        new Person("Ben", 25),
                        new Person("Andy", 36),
                        new Person("Phil", 44))
                        .stream()
                        .findAny()
                        .get();

        System.out.println("Any person: " + p.getName());
    }

    private static void searchPersonStreamForFirstValue()
    {
        Optional<Person> p
                = Arrays.asList(
                        new Person("Graham", 23),
                        new Person("Ben", 25),
                        new Person("Andy", 36),
                        new Person("Phil", 44))
                        .stream()
                        .findFirst();

        if (p.isPresent())
        {
            System.out.println("First person: " + p.get().getName());
        }
        else
        {
            System.out.println("First person: Not present");
        }
    }

    private static void searchEmptyPersonStreamForFirstValue()
    {
        Optional<Person> p
                = Arrays.asList(
                        new Person("Graham", 23),
                        new Person("Ben", 25),
                        new Person("Andy", 36),
                        new Person("Phil", 44))
                        .stream()
                        .filter(person -> person.getName().startsWith("C"))
                        .findFirst();

        if (p.isPresent())
        {
            System.out.println("First person: " + p.get().getName());
        }
        else
        {
            System.out.println("First person: Not present");
        }
    }
}
