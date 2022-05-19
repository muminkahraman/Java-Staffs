
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author gdm1
 */
public class StreamExamples
{

    public static void main(String[] args)
    {
        intStreamExample1();
        pipelineExample1();
        operationOrderExample1();
        operationOrderExample2();
        sortAnIntStream();
        filterExample1();
        filterExample2();
        pipelineEfficiencyExample1();
        streamBuilderExample();
    }

    private static void intStreamExample1()
    {
        System.out.println("\nIntStream example 1");
        // Generate a sequence of integers in the range 1-9, inclusive
        IntStream stream = IntStream.range(1, 10);

        // Print each integer in the stream
        stream.forEach(num -> System.out.print(num + " "));

        System.out.println();
    }

    private static void pipelineExample1()
    {
        System.out.println("\nPipeline example 1");
        IntStream.range(1, 10)
                .map(i -> i * 6) // produces a new stream containing the values of the previous stream (i) multiplied by 6
                .map(i -> i - 2) // produces a new stream containing the values of the previous stream (i) minus 2
                .forEach(num -> System.out.print(num + " "));

        System.out.println();
    }

    private static void operationOrderExample1()
    {
        System.out.println("\nOperation order example 1");
        IntStream.range(1, 10)
                .peek(num -> System.out.print("\n\t" + num + " "))
                .map(i -> i * 6)
                .peek(num -> System.out.print(num + " "))
                .map(i -> i - 2)
                .forEach(num -> System.out.print(num + " "));

        System.out.println();
    }

    private static void operationOrderExample2()
    {
        System.out.println("\nOperation order example 2");
        Arrays
                .asList("One", "Two", "Three", "Four", "Five")
                .stream()
//                .parallelStream()
                .peek(e -> System.out.print("\n\t" + e + " "))
                .map(String::toLowerCase)
                .peek(e -> System.out.print(e + " "))
                .mapToInt(String::length)
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }

    private static void sortAnIntStream()
    {
        Random r = new Random();

        System.out.println("\nSort an IntStream");
        int[] ints
                = r.ints(10, 50, 60)
                    .peek(i -> System.out.print(i + " "))
                    .toArray();

        System.out.println();
        
        Arrays.stream(ints)
                .sorted()
                .forEach(i -> System.out.print(i + " "));

        System.out.println();
    }

    private static void filterExample1()
    {
        System.out.println("\nFilter example 1");
        Arrays
                .asList("One", "Two", "Three", "Four", "Five")
                .stream()
                .filter(e -> e.startsWith("F") || e.startsWith("T"))
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }

    private static void filterExample2()
    {
        System.out.println("\nFilter example 2 - showing the effect of filtering on processing");
        Arrays
                .asList("One", "Two", "Three", "Four", "Five")
                .stream()
                .peek(e -> System.out.print("\n\t" + e + " "))
                .filter(e -> e.startsWith("F") || e.startsWith("T"))
                .peek(e -> System.out.print(e + " "))
                .map(String::toLowerCase)
                .peek(e -> System.out.print(e + " "))
                .mapToInt(String::length)
                .forEach(e -> System.out.print(e + " "));

        System.out.println();
    }

    private static void pipelineEfficiencyExample1()
    {
        Random r = new Random();

        System.out.println("\nPipeline efficiency example 1");
        int[] ints = r.ints(100, 50, 60).toArray();

        System.out.println("About to sort ints...");
        int[] sorted1
                = Arrays.stream(ints)
                        .peek(i -> System.out.print(i + " "))
                        .sorted()
                        .distinct()
                        .toArray();

        System.out.println("\nNow about to sort distinct ints...");
        int[] sorted2
                = Arrays.stream(ints)
                        .distinct()
                        .peek(i -> System.out.print(i + " "))
                        .sorted()
                        .toArray();

        System.out.println("\n\nThe results are the same (even if one is less efficient than the other)...");
        System.out.println("Sorted 1:");
        Arrays.stream(sorted1).forEach(i -> System.out.print(i + " "));
        System.out.println("\nSorted 2:");
        Arrays.stream(sorted2).forEach(i -> System.out.print(i + " "));

        System.out.println();
    }

    private static void streamBuilderExample()
    {
        //build a stream of strings
        Stream<String> animals
                = Stream.<String>builder()
                        .add("Dog")
                        .add("Cat")
                        .add("Bird")
                        .add("Fish")
                        .add("Elephant")
                        .build();
        
        System.out.println("\nStream builder example");

        animals.sorted().forEach(System.out::println);

        System.out.println();
    }

}
