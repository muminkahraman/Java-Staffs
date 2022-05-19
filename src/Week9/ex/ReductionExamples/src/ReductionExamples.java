
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author gdm1
 */
public class ReductionExamples
{

    public static void main(String[] args)
    {
        intStreamReductionExamples();
        personStreamReductionExamples();
        streamCollectionExamples();
    }

    private static void intStreamReductionExamples()
    {
        System.out.println("IntStream reductions on stream: 2, 4, 3, 1, 6, 5");
        System.out.printf("%9s\t%8s\t%6s\n", "Operation", "Expected", "Actual");
        System.out.printf("%9s\t%8s\t%6s\n", "=========", "========", "======");
        intStreamAverageExample();
        intStreamCountExample();
        intStreamMaxExample();
        intStreamMinExample();
        intStreamSumExample();

        System.out.println("");
        System.out.println("Custom reductions on stream: 2, 4, 3, 1, 6, 5");
        System.out.printf("%9s\t%8s\t%6s\n", "Operation", "Expected", "Actual");
        System.out.printf("%9s\t%8s\t%6s\n", "=========", "========", "======");
        intStreamReduceExample();
    }

    private static void intStreamAverageExample()
    {
        double average
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .average()
                        .getAsDouble();

        System.out.printf("%9s\t%8.1f\t%6.1f\n", "Average", 3.5, average);
    }

    private static void intStreamCountExample()
    {
        long count
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .count();

        System.out.printf("%9s\t%8d\t%6d\n", "Count", 6, count);
    }

    private static void intStreamMaxExample()
    {
        int max
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .max()
                        .getAsInt();

        System.out.printf("%9s\t%8d\t%6d\n", "Max", 6, max);
    }

    private static void intStreamMinExample()
    {
        int min
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .min()
                        .getAsInt();

        System.out.printf("%9s\t%8d\t%6d\n", "Min", 1, min);
    }

    private static void intStreamSumExample()
    {
        int sum
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .sum();

        System.out.printf("%9s\t%8d\t%6d\n", "Sum", 21, sum);
    }

    private static void intStreamReduceExample()
    {
        int sum
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new)
                        .reduce(0, (a, b) -> a + b);

        // Could also be written as...
//        int sum
//                = Arrays.asList(2, 4, 3, 1, 6, 5)
//                        .stream()
//                        .mapToInt(Integer::new)
//                        .reduce(0, Integer::sum);
        System.out.printf("%9s\t%8d\t%6d\n", "Sum", 21, sum);
    }

    private static void personStreamReductionExamples()
    {
        System.out.println("");
        System.out.println("Custom reductions on stream of Person objects to produce a string containing all names in the stream");
        personStreamReductionExample1();
        personStreamReductionExample2();
    }

    private static void personStreamReductionExample1()
    {
        String names
                = Arrays.asList(
                        new Person("Graham", 23),
                        new Person("Ben", 25),
                        new Person("Andy", 36),
                        new Person("Phil", 44))
                        .stream()
                        .map(p -> p.getName())
                        .filter(name -> !name.startsWith("A"))
                        .reduce("", (str, name) -> str += name + " ")
                        .trim()
                        .replaceAll(" ", ", ");

        System.out.println("Names: '" + names + "'");
    }

    private static void personStreamReductionExample2()
    {
        String names
                = Arrays.asList(
                        new Person("Graham", 23),
                        new Person("Ben", 25),
                        new Person("Andy", 36),
                        new Person("Phil", 44))
                        .stream()
                        .filter(s -> !s.getName().startsWith("A"))
//                        .reduce("", (String str, Person p) -> str += p.getName() + " "); // does not compile
                        .reduce("", (str, p) -> str += p.getName() + " ", String::concat)
                        .trim()
                        .replaceAll(" ", ", ");

        System.out.println("Names: '" + names + "'");
    }

    private static void streamCollectionExamples()
    {
        System.out.println("");
        System.out.println("Collections on stream: 2, 4, 3, 1, 6, 5");
        intStreamCollectionExample1();
        intStreamCollectionExample2();
    }
    
    private static void intStreamCollectionExample1()
    {
        IntStream intStream
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream()
                        .mapToInt(Integer::new);

        System.out.println("\nIntStream collection on stream: 2, 4, 3, 1, 6, 5");

        ArrayList<Integer> list = intStream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        
        System.out.print("Resulting list: ");
        list.stream().forEach(i -> System.out.printf("%d ", i));
        System.out.println();
    }
    
    private static void intStreamCollectionExample2()
    {
        Stream<Integer> intStream
                = Arrays.asList(2, 4, 3, 1, 6, 5)
                        .stream();

        System.out.println("\nIntStream collection on stream: 2, 4, 3, 1, 6, 5");

        List<Integer> list = intStream.collect(Collectors.toList());
        
        System.out.print("Resulting list: ");
        list.stream().forEach(i -> System.out.printf("%d ", i));
        System.out.println();
    }

}
