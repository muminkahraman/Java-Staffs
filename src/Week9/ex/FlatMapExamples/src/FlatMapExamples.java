
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author gdm1
 */
public class FlatMapExamples
{

    public static void main(String[] args)
    {
        flatMapSentencesToWords();
        flatMap_2d_Array_To_1d_Array();
        use_join_when_printing_2d_Array_and_1d_Array();
    }

    public static void flatMapSentencesToWords()
    {
        System.out.println("\nConvert a stream of sentences to a stream of words");
        List<String> sentences
                = Arrays.asList(
                        "The cat sat on the mat",
                        "The dog ate the sausage");

        System.out.println("\tSentences stream");
        sentences
                .stream()
                .forEach(s -> System.out.println("\t\t" + s));

        System.out.println("\n\tSentences flatMapped stream");
        sentences
                .stream()
                .flatMap(sentence -> Stream.of(sentence.split(" ")))
                .forEach(s -> System.out.println("\t\t" + s));
    }

    private static void flatMap_2d_Array_To_1d_Array()
    {
        System.out.println("\nConvert a 2d array to a 1d array");

        int[][] _2dArray =
        {
            {2, 4, 6, 8}, 
            {1, 3, 5, 7, 9}
        };
        
        int[] _1dArray
                = Arrays.stream(_2dArray)
                        .flatMapToInt(a -> IntStream.of(a))
                        .toArray();

        System.out.println("\t2d array stream");
        System.out.println("\t\t{ ");
        Arrays.stream(_2dArray)
                .forEach(a ->
                {
                    System.out.print("\t\t    { ");
                    Arrays.stream(a)
                            .forEach(i -> System.out.print(i + " "));
                    System.out.println("}");
                });
        System.out.println("\t\t}");

        System.out.println("\n\t1d array stream");
        System.out.print("\t\t{ ");
        Arrays.stream(_1dArray)
                .forEach(i -> System.out.print(i + " "));
        System.out.println("}");
    }

    private static void use_join_when_printing_2d_Array_and_1d_Array()
    {
        System.out.println("\nUsing join when printing a 2d array and a 1d array");

        int[][] _2dArray =
        {
            {2, 4, 6, 8}, 
            {1, 3, 5, 7, 9}
        };
        
        int[] _1dArray
                = Arrays.stream(_2dArray)
                        .flatMapToInt(a -> IntStream.of(a))
                        .toArray();

        System.out.println("\t2d array stream");
        System.out.println(
                Arrays.stream(_2dArray)
                        .map(a -> 
                                Arrays.stream(a)
                                        .mapToObj(String::valueOf)
                                        .collect(Collectors.joining(", ", "\t\t    { ", " }")))
                        .collect(Collectors.joining(",\n", "\t\t{\n","\n\t\t}")));

        System.out.println("\n\t1d array stream");
        System.out.println(
                Arrays.stream(_1dArray)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ", "\t\t{ ", " }")));
    }
}
